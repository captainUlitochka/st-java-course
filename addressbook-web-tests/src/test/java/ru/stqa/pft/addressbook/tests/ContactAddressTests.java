package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withName("Петр")
              .withLastName("Петров")
              .withMiddleName("Петрович")
              .withEmail("mail@companyname.com")
              .withAddress("улица Пушкина, дом Колотушкина")
              .withGroup("test1"));
    }
  }

  @Test
  public void testContactAddress() {
    app.goTo().gotoHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress())); // Сравниваем с содержимым поля, так как клеить нечего
  }
}
