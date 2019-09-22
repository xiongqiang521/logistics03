package com.xq.bean;

import java.io.Serializable;


public class EmployeeState implements Serializable {

  private Integer id;
  private String type;
  private Integer group;

  private Station station;

  @Override
  public String toString() {
    return "EmployeeState{" +
            "id=" + id +
            ", type='" + type + '\'' +
            ", group=" + group +
            ", station=" + station +
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

  public Station getStation() {
    return station;
  }

  public void setStation(Station station) {
    this.station = station;
  }
}
