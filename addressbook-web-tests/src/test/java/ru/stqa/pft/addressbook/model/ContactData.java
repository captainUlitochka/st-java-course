package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.mysql.cj.util.StringUtils;
import jakarta.persistence.*;

import java.io.File;
import java.util.Objects;

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

  //@Column(name="photo", columnDefinition = "mediumtext")
  @Transient
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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (!Objects.equals(contactName, that.contactName)) return false;
    if (!Objects.equals(contactMiddleName, that.contactMiddleName))
      return false;
    if (!Objects.equals(contactLastName, that.contactLastName))
      return false;

    if (!StringUtils.isNullOrEmpty(contactEmail) || !StringUtils.isNullOrEmpty(that.contactEmail)) {
      if (!Objects.equals(contactEmail, that.contactEmail)) return false;
    }

    if (!StringUtils.isNullOrEmpty(contactEmail2) || !StringUtils.isNullOrEmpty(that.contactEmail2)) {
      if (!Objects.equals(contactEmail2, that.contactEmail2)) return false;
    }

    if (!StringUtils.isNullOrEmpty(contactEmail3) || !StringUtils.isNullOrEmpty(that.contactEmail3)) {
      if (!Objects.equals(contactEmail3, that.contactEmail3)) return false;
    }

    if (!StringUtils.isNullOrEmpty(contactWorkPhone) || !StringUtils.isNullOrEmpty(that.contactWorkPhone)) {
      if (!Objects.equals(contactWorkPhone, that.contactWorkPhone)) return false;
    }

    if (!StringUtils.isNullOrEmpty(contactHomePhone) || !StringUtils.isNullOrEmpty(that.contactHomePhone)) {
      if (!Objects.equals(contactHomePhone, that.contactHomePhone)) return false;
    }

    if (!StringUtils.isNullOrEmpty(contactMobilePhone) || !StringUtils.isNullOrEmpty(that.contactMobilePhone)) {
      if (!Objects.equals(contactEmail3, that.contactEmail3)) return false;
    }

    if (!StringUtils.isNullOrEmpty(allEmails) || !StringUtils.isNullOrEmpty(that.allEmails)) {
      if (!Objects.equals(allEmails, that.allEmails)) return false;
    }

    if (!StringUtils.isNullOrEmpty(allPhones) || !StringUtils.isNullOrEmpty(that.allPhones)) {
      if (!Objects.equals(allPhones, that.allPhones)) return false;
    }

    if (!StringUtils.isNullOrEmpty(contactAddress) || !StringUtils.isNullOrEmpty(that.contactAddress)) {
      if (!Objects.equals(contactAddress, that.contactAddress)) return false;
    }
    return true;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (contactName != null ? contactName.hashCode() : 0);
    result = 31 * result + (contactMiddleName != null ? contactMiddleName.hashCode() : 0);
    result = 31 * result + (contactLastName != null ? contactLastName.hashCode() : 0);
    result = 31 * result + (contactEmail != null ? contactEmail.hashCode() : 0);
    result = 31 * result + (contactEmail2 != null ? contactEmail2.hashCode() : 0);
    result = 31 * result + (contactEmail3 != null ? contactEmail3.hashCode() : 0);
    result = 31 * result + (contactHomePhone != null ? contactHomePhone.hashCode() : 0);
    result = 31 * result + (contactWorkPhone != null ? contactWorkPhone.hashCode() : 0);
    result = 31 * result + (contactMobilePhone != null ? contactMobilePhone.hashCode() : 0);
    result = 31 * result + (allPhones != null ? allPhones.hashCode() : 0);
    result = 31 * result + (allEmails != null ? allEmails.hashCode() : 0);
    result = 31 * result + (contactAddress != null ? contactAddress.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", contactName='" + contactName + '\'' +
            ", contactLastName='" + contactLastName + '\'' +
            '}';
  }


}
