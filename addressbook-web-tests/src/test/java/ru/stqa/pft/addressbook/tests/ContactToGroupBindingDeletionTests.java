package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactToGroupBindingDeletionTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test 1"));
    }

    if (app.db().contacts().size() == 0) {
      app.goTo().gotoHomePage();
      app.contact().create(new ContactData()
              .withName("Петр")
              .withLastName("Петров")
              .withMiddleName("Петрович")
              .withEmail("mail@companyname.com")
              .inGroup(app.db().groups().iterator().next()));
    }
  }

  @Test
  public void testDeleteContactFromGroup() {
    app.goTo().gotoHomePage();
    Contacts dbContacts = app.db().contacts();
    Groups dbGroups = app.db().groups();
    ContactData selectedContact = null;
    GroupData selectedGroup = null;

    // Перебираем контакты
    for (ContactData contact: dbContacts) {
      if (contact.getGroups().size() > 0) {
        // Нашли контакт с имеющейся группой
        selectedContact = contact;
        selectedGroup = contact.getGroups().iterator().next();
        break;
      }
    }

    if (selectedContact == null) {
      // Берем пару "первый контакт, первая группа"
      selectedContact = dbContacts.stream().iterator().next();
      selectedGroup = dbGroups.stream().iterator().next();
      app.goTo().gotoHomePage();
      app.contact().addToGroup(selectedContact, selectedGroup.getId());
    }

    ContactData finalSelectedContact = selectedContact;

    app.goTo().gotoHomePage();
    app.contact().selectGroupInFilter(selectedGroup.getId());
    int resultsBefore = app.contact().resultsCount();
    app.contact().deleteFromGroup(selectedContact, selectedGroup);
    int resultsAfter = app.contact().resultsCount();
    Contacts after = app.db().contacts();
    assertThat(resultsAfter, equalTo((resultsBefore) - 1));

    assertThat(after.stream().filter(c -> c.getId() == finalSelectedContact.getId()).collect(Collectors.toList()).get(0).getGroups(), not(hasItem(selectedGroup)));
  }


}
