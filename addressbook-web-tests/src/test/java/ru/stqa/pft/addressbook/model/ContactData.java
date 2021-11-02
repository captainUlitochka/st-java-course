package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id;
  private final String contactName;
  private final String contactMiddleName;
  private final String contactLastName;
  private final String contactEmail;
  private String group;

  public ContactData(int id, String firstName, String middleName, String lastName, String contactEmail, String group) {
    this.id = id;
    this.contactName = firstName;
    this.contactMiddleName = middleName;
    this.contactLastName = lastName;
    this.contactEmail = contactEmail;
    this.group = group;
  }

  public ContactData(String firstName, String middleName, String lastName, String contactEmail, String group) {
    this.id = Integer.MAX_VALUE;
    this.contactName = firstName;
    this.contactMiddleName = middleName;
    this.contactLastName = lastName;
    this.contactEmail = contactEmail;
    this.group = group;
  }

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

  public void setId(int id) {
    this.id = id;
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
