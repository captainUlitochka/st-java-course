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

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactToGroupBindingCreationTests extends TestBase {

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
  public void testContactToGroupBindingCreation() {
    int selectedGroupID = -1; // Используется при добавлении контакта в группу

    app.goTo().gotoHomePage();
    Contacts dbContacts = app.db().contacts();

    Groups dbGroups = app.db().groups();
    ContactData selectedContact = null;
    List<Integer> allGroupIds = dbGroups.stream().map(GroupData::getId).collect(Collectors.toList());

    for (ContactData contactData : dbContacts) {
      Groups groups = contactData.getGroups();
      if (groups.size() < allGroupIds.size()) {
        // Нашли контакт, который не участвует во всех группах
        selectedContact = contactData;
        break;
      }
    }

    // Не нашли подходящий контакт - создаем группу и берем первый контакт
    if (selectedContact == null) {
      selectedContact = dbContacts.stream().iterator().next();
      GroupData newGroup = new GroupData()
              .withName("new group").withHeader("header 1").withFooter("footer 1");
      app.goTo().groupPage();
      app.group().create(newGroup);
      Groups allGroups = app.group().all();
      selectedGroupID = (allGroups.stream().max(Comparator.comparing(GroupData::getId)).orElseThrow(NoSuchElementException::new).getId());
    }
    else {
      List<Integer> contactExistingGroups = selectedContact.getGroups().stream().map(GroupData::getId).collect(Collectors.toList());
      allGroupIds.removeAll(contactExistingGroups); // Тут остались только те группы, в которых не участвует контакт
      selectedGroupID = allGroupIds.iterator().next();
    }


    app.contact().addToGroup(selectedContact, selectedGroupID); // Сейчас добавили контакт в группу
    app.contact().returnToHomepage();
    app.contact().selectGroupInFilter(selectedGroupID); // Отфильтровали по новой группе
    Contacts after = app.db().contacts();
    int finalSelectedGroupID = selectedGroupID;
    GroupData thatGroup = app.db().groups().stream().filter(g-> g.getId() == finalSelectedGroupID).collect(Collectors.toList()).get(0);

    ContactData finalSelectedContact = selectedContact;
    assertThat(after.stream().filter(c -> c.getId() == finalSelectedContact.getId()).collect(Collectors.toList()).get(0).getGroups(), hasItem(thatGroup));
  }
}