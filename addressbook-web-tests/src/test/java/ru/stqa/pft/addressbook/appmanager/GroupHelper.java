package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase{

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getGroupName());
    type(By.name("group_header"), groupData.getGroupHeader());
    type(By.name("group_footer"), groupData.getGroupFooter());
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void selectGroup() {
    click(By.name("selected[]"));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void initGroupModification() { click(By.name("edit"));
  }

  public void submitGroupModificaton() {  click(By.name("update"));
  }

  public void createGroup(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected"));
  }
}
