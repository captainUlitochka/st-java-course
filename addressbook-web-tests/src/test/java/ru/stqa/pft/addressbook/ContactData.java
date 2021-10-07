package ru.stqa.pft.addressbook;

public class ContactData {
  private final String contactName;
  private final String contactMiddleName;
  private final String contactLastName;
  private final String contactEmail;

  public ContactData(String contactName, String contactMiddleName, String contactLastName, String contactEmail) {
    this.contactName = contactName;
    this.contactMiddleName = contactMiddleName;
    this.contactLastName = contactLastName;
    this.contactEmail = contactEmail;
  }

  public String getContactName() {
    return contactName;
  }

  public String getContactMiddleName() {
    return contactMiddleName;
  }

  public String getContactLastName() {
    return contactLastName;
  }

  public String getContactEmail() {
    return contactEmail;
  }
}
