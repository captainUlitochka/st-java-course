package ru.stqa.pft.addressbook.model;

public class GroupData {
  private final String id;
  private final String groupName;
  private final String groupHeader;
  private final String groupFooter;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    if (id != null ? !id.equals(groupData.id) : groupData.id != null) return false;
    return groupName != null ? groupName.equals(groupData.groupName) : groupData.groupName == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", groupName='" + groupName + '\'' +
            '}';
  }

  public String getId() {
    return id;
  }

  public GroupData(String id, String groupName, String groupHeader, String groupFooter) {

    this.id = id;
    this.groupName = groupName;
    this.groupHeader = groupHeader;
    this.groupFooter = groupFooter;
  }

  public GroupData(String groupName, String groupHeader, String groupFooter) {

    this.id = null;
    this.groupName = groupName;
    this.groupHeader = groupHeader;
    this.groupFooter = groupFooter;
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

}
