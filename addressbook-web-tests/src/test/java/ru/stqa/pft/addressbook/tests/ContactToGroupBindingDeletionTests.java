package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
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
    ContactData selectedContact = dbContacts.iterator().next(); // Берём первый попавшийся контакт
    GroupData selectedGroup = dbGroups.iterator().next();

    if (selectedContact.getGroups().size() > 0) {
      selectedGroup = selectedContact.getGroups().stream().findFirst().stream().iterator().next();

    } else {
      app.goTo().gotoHomePage();
      app.contact().addToGroup(selectedContact, selectedGroup.getId());
    }

    app.goTo().gotoHomePage();
    app.contact().selectGroupInFilter(selectedGroup.getId());
    int resultsBefore = app.contact().resultsCount();
    app.contact().deleteFromGroup(selectedContact, selectedGroup);
    int resultsAfter = app.contact().resultsCount();
    Contacts after = app.db().contacts();
    assertThat(resultsAfter, equalTo((resultsBefore) - 1));
    assertThat(after.stream().filter(c -> c.getId() == selectedContact.getId()).collect(Collectors.toList()).get(0).getGroups(), not(hasItem(selectedGroup)));
  }


}
