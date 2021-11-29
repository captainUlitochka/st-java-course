package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UsersData;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertTrue;

public class PasswordChangingTests extends TestBase{

  //@BeforeMethod
  public void ensurePreconditions() {

    app.mail().start();
  }

  @Test
  public void passwordResetTest() throws MessagingException, IOException {
    app.registration().login(new UsersData().withUserName("administrator").withPassword("root"));
    UsersData user = app.db().users()
            .stream().filter((u) -> (!u.getUserName().equals("administrator")))
            .collect(Collectors.toList()).iterator().next();
    app.james().drainEmail(user.getUserName(), "password");
    app.registration().resetByAdmin(user);
    List<MailMessage> mailMessages = app.james().waitForMail(user.getUserName(), "password", 60000);
    String confirmationLink = findConfirmationLink(mailMessages, user.getEmail());
    String newPassword = "password" + System.currentTimeMillis();
    app.registration().finish(confirmationLink, newPassword);
    app.newSession().login(user.getUserName(), newPassword);
  }


  public String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  //@AfterMethod(alwaysRun = true)
  public void stopMailServer(){
    app.mail().stop();
  }


}
