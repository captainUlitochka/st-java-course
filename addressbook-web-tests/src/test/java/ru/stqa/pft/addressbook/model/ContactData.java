package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String contactName;
  private String contactMiddleName;
  private String contactLastName;
  private String contactEmail;
  private String group;

  public int getId() {
    return id;
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

  public String getGroup() {
    return group;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withName(String contactName) {
    this.contactName = contactName;
    return this;
  }

  public ContactData withMiddleName(String contactMiddleName) {
    this.contactMiddleName = contactMiddleName;
    return this;
  }

  public ContactData withLastName(String contactLastName) {
    this.contactLastName = contactLastName;
    return this;
  }

  public ContactData withEmail(String contactEmail) {
    this.contactEmail = contactEmail;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }


  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", contactName='" + contactName + '\'' +
            ", contactLastName='" + contactLastName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;
    return (Objects.equals(contactName, that.contactName) && Objects.equals(contactLastName, that.contactLastName));

  }

  @Override
  public int hashCode() {
    int result = contactName != null ? contactName.hashCode() : 0;
    result = 31 * result + (contactLastName != null ? contactLastName.hashCode() : 0);
    return result;
  }
}
