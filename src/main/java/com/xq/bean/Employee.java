package com.xq.bean;

import java.io.Serializable;

public class Employee implements Serializable {

  private Integer id;
  private Integer employee_num;
  private String name;
  private String password;
  private String sex;
  private String telephone;
  private Integer state;

  @Override
  public String toString() {
    return "Employee{" +
            "id=" + id +
            ", employee_num=" + employee_num +
            ", name='" + name + '\'' +
            ", password='" + password + '\'' +
            ", sex='" + sex + '\'' +
            ", telephone='" + telephone + '\'' +
            ", state=" + state +
            '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getEmployee_num() {
    return employee_num;
  }

  public void setEmployee_num(Integer employee_num) {
    this.employee_num = employee_num;
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


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }


  public Integer getState() {
    return state;
  }

  public void setState(Integer state) {
    this.state = state;
  }

}
