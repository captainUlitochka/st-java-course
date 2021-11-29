package ru.stqa.pft.mantis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mantis_user_table")
public class UsersData {

  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;

  @Column(name = "username")
  private String name;
  private String password;

  @Column(name = "email")
  private String email;


  public int getId() {
    return id;
  }
  public String getUserName() {
    return name;
  }
  public String getPassword() {
    return password;
  }
  public String getEmail() {
    return email;
  }

  public UsersData withId(int id) {
    this.id = id;
    return this;
  }
  public UsersData withUserName(String name) {
    this.name=name;
    return this;
  }
  public UsersData withPassword(String password) {
    this.password = password;
    return this;
  }
  public UsersData withEmail(String email) {
    this.email=email;
    return this;
  }


  @Override
  public String toString() {
    return "UsersData{" +
            "id=" + id +
            ", userName='" + name + '\'' +
            ", email='" + email + '\'' +
            '}';
  }

}
