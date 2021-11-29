package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UsersHelper extends HelperBase {

  private String username;

  public UsersHelper(ApplicationManager app) {
    super(app);
  }

  public void goToManageUsersPage() {
    wd.findElement(By.linkText("Manage")).click();
    wd.findElement(By.linkText("Manage Users")).click();
  }

  public void chooseUser(int userId) {
    WebElement user = wd.findElement(By.cssSelector("a[href='manage_user_edit_page.php?user_id=" + userId + "']"));
    user.click();
  }

  public void resetPassword(String user) {
    this.username = user;
    click(By.linkText(username));
    click(By.cssSelector("input[value='Reset Password']"));
//        wd.findElement(By.cssSelector("input[value='Reset Password']")).click();
  }

  public String getUserName() {
    String username = wd.findElement(By.cssSelector("input[name='username']")).getAttribute("value");
    return username;
  }

  public String getMail() {
    String email = wd.findElement(By.cssSelector("input[name='email']")).getAttribute("value");
    return email;
  }

  public void updatePassword(String resetPasswordLink, String newpassword) {
    wd.get(resetPasswordLink);
    type(By.name("password"), newpassword);
    type(By.name("password_confirm"), newpassword);
    click(By.cssSelector("input[type='submit']"));
  }

}
