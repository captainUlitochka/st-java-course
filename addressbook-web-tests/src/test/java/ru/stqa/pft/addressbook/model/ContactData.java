package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id = Integer.MAX_VALUE;

  private String contactName;
  private String contactMiddleName;
  private String contactLastName;
  private String contactEmail;
  private String contactEmail2;
  private String contactEmail3;
  private String contactHomePhone;
  private String contactWorkPhone;
  private String contactMobilePhone;
  private String allPhones;
  private String allEmails;
  private String contactAddress;
  private String group;

  public int getId() {
    return id;
  }

  public String getFirstName() {
    return contactName;
  }

  public String getMiddleName() {
    return contactMiddleName;
  }

  public String getLastName() {
    return contactLastName;
  }

  public String getEmail() {
    return contactEmail;
  }

  public String getEmail2() {
    return contactEmail2;
  }

  public String getEmail3() {
    return contactEmail3;
  }

  public String getGroup() {
    return group;
  }

  public String getHomePhone() {
    return contactHomePhone;
  }

  public String getWorkPhone() {
    return contactWorkPhone;
  }

  public String getMobilePhone() {
    return contactMobilePhone;
  }

  public String getAllPhones() {
    return allPhones;
  }
  public String getAllEmails() {
    return allEmails;
  }

  public String getAddress() {
    return contactAddress;
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

  public ContactData withHomePhone(String contactHomePhone) {
    this.contactHomePhone = contactHomePhone;
    return this;
  }

  public ContactData withWorkPhone(String contactWorkPhone) {
    this.contactWorkPhone = contactWorkPhone;
    return this;
  }

  public ContactData withMobilePhone(String contactMobilePhone) {
    this.contactMobilePhone = contactMobilePhone;
    return this;
  }

  public ContactData withEmail(String contactEmail) {
    this.contactEmail = contactEmail;
    return this;
  }

  public ContactData withEmail2(String contactEmail2) {
    this.contactEmail2 = contactEmail2;
    return this;
  }
  public ContactData withEmail3(String contactEmail3) {
    this.contactEmail3 = contactEmail3;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }
  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public ContactData withAddress(String contactAddress) {
    this.contactAddress = contactAddress;
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

    if (id != that.id) return false;
    if (contactName != null ? !contactName.equals(that.contactName) : that.contactName != null) return false;
    return contactLastName != null ? contactLastName.equals(that.contactLastName) : that.contactLastName == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (contactName != null ? contactName.hashCode() : 0);
    result = 31 * result + (contactLastName != null ? contactLastName.hashCode() : 0);
    return result;
  }


}
