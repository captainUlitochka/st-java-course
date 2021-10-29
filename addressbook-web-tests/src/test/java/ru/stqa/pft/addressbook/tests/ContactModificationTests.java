package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification() {
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData(
              "Петр",
              "Петрович",
              "Петров",
              "randomemail@test.com",
              "test1"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactModification();
    ContactData contact = new ContactData(before.get(before.size() -1).getId(),
            "Петр",
            null,
            "Петров",
            "randomemail@test.com",
            "test1");
    app.getContactHelper().fillContactForm(contact,false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnToHomepage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size()-1);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
