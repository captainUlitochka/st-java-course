package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import jakarta.persistence.*;

import java.io.File;

@Entity
@Table(name="addressbook")
public class ContactData {
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column(name="firstname", columnDefinition = "text")
  private String contactName;

  @Expose
  @Column(name="middlename", columnDefinition = "text")
  private String contactMiddleName;

  @Expose
  @Column(name="lastname", columnDefinition = "text")
  private String contactLastName;

  @Column(name="email", columnDefinition = "text")
  private String contactEmail;

  @Column(name="email2", columnDefinition = "text")
  private String contactEmail2;

  @Column(name="email3", columnDefinition = "text")
  private String contactEmail3;

  @Column(name="home", columnDefinition = "text")
  private String contactHomePhone;

  @Column(name="work", columnDefinition = "text")
  private String contactWorkPhone;

  @Column(name="mobile", columnDefinition = "text")
  private String contactMobilePhone;

  @Transient
  private String allPhones;

  @Transient
  private String allEmails;

  @Column(name="address", columnDefinition = "text")
  private String contactAddress;

  @Expose
  @Transient
  private String group;

  @Column(name="photo", columnDefinition = "mediumtext")
  private String photo;

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

  public File getPhoto() {
    return new File(photo);
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

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
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
