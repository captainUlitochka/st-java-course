package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@XStreamAlias("group")
@Entity
@Table(name = "group_list")
public class GroupData {
  @XStreamOmitField
  @Id
  @Column(name = "group_id")
  private int id = Integer.MAX_VALUE;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    if (id != groupData.id) return false;
    if (groupName != null ? !groupName.equals(groupData.groupName) : groupData.groupName != null) return false;
    if (groupHeader != null ? !groupHeader.equals(groupData.groupHeader) : groupData.groupHeader != null) return false;
    return groupFooter != null ? groupFooter.equals(groupData.groupFooter) : groupData.groupFooter == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
    result = 31 * result + (groupHeader != null ? groupHeader.hashCode() : 0);
    result = 31 * result + (groupFooter != null ? groupFooter.hashCode() : 0);
    return result;
  }

  @Expose
  @Column(name = "group_name", columnDefinition = "text")
  private String groupName;
  @Expose
  @Column(name = "group_header", columnDefinition = "mediumtext")
  private String groupHeader;
  @Expose
  @Column(name = "group_footer", columnDefinition = "mediumtext")
  // Используемая версия hibernate, по всей видимости, не поддерживает @Type;
  private String groupFooter;                                     // В результате поиска нашла, что передать тип можно через columnDefinition в @Column

  @ManyToMany(mappedBy = "groups")
  private Set<ContactData> contacts = new HashSet<ContactData>();

  public int getId() {
    return id;
  }

  public String getGroupName() {
    return groupName;
  }

  public String getGroupHeader() {
    return groupHeader;
  }

  public String getGroupFooter() {
    return groupFooter;
  }

  public GroupData withId(int id) {
    this.id = id;
    return this;
  }

  public GroupData withName(String groupName) {
    this.groupName = groupName;
    return this;
  }

  public GroupData withHeader(String groupHeader) {
    this.groupHeader = groupHeader;
    return this;
  }

  public GroupData withFooter(String groupFooter) {
    this.groupFooter = groupFooter;
    return this;
  }

  public Contacts getContacts() {
    return new Contacts(contacts);
  }


  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", groupName='" + groupName + '\'' +
            '}';
  }

}

