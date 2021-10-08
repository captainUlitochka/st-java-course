package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreationTests() {
    app.initContactCreation();
    app.fillContactForm(new ContactData("Иван", "Иванович", "Иванов", "mail@companyname.com"));
    app.submitContactCreation();
    app.returnToHomepage();
  }

}
