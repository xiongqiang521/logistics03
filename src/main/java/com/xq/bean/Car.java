package com.xq.bean;;


public class Car {

  private Integer id;
  private String car_num;
  private String type;
  private Double load;
  private String state;

  @Override
  public String toString() {
    return "Car{" +
            "id=" + id +
            ", car_num='" + car_num + '\'' +
            ", type='" + type + '\'' +
            ", load=" + load +
            ", state='" + state + '\'' +
            '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getCar_num() {
    return car_num;
  }

  public void setCar_num(String car_num) {
    this.car_num = car_num;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public Double getLoad() {
    return load;
  }

  public void setLoad(Double load) {
    this.load = load;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

}
