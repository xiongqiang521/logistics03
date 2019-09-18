package com.xq.bean;


public class Users {

  private long id;
  private String user_id;
  private String name;
  private String password;
  private String create_time;
  private String state;
  private String telephone;

  @Override
  public String toString() {
    return "Users{" +
            "id=" + id +
            ", user_id='" + user_id + '\'' +
            ", name='" + name + '\'' +
            ", password='" + password + '\'' +
            ", create_time='" + create_time + '\'' +
            ", state='" + state + '\'' +
            ", telephone='" + telephone + '\'' +
            '}';
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUser_id() {
    return user_id;
  }

  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getCreate_time() {
    return create_time;
  }

  public void setCreate_time(String create_time) {
    this.create_time = create_time;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }
}
