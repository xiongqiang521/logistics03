package com.xq.bean;

import java.io.Serializable;

;


public class EmployeeState implements Serializable {

  private Integer id;
  private String type;
  private Integer group;

  @Override
  public String toString() {
    return "EmployeeState{" +
            "id=" + id +
            ", type='" + type + '\'' +
            ", group=" + group +
            '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public Integer getGroup() {
    return group;
  }

  public void setGroup(Integer group) {
    this.group = group;
  }

}
