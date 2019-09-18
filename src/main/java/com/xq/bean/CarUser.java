package com.xq.bean;

import java.io.Serializable;

public class CarUser implements Serializable {

  private Integer id;
  private String car_num;
  private Integer employee_id;
  private Integer exclusive;
  private String out_time;
  private String in_time;
  private String target;
  private Integer transfer_id;

  @Override
  public String toString() {
    return "CarUser{" +
            "id=" + id +
            ", car_num='" + car_num + '\'' +
            ", employee_id=" + employee_id +
            ", exclusive=" + exclusive +
            ", out_time='" + out_time + '\'' +
            ", in_time='" + in_time + '\'' +
            ", target='" + target + '\'' +
            ", transfer_id=" + transfer_id +
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


  public Integer getEmployee_id() {
    return employee_id;
  }

  public void setEmployee_id(Integer employee_id) {
    this.employee_id = employee_id;
  }


  public Integer getExclusive() {
    return exclusive;
  }

  public void setExclusive(Integer exclusive) {
    this.exclusive = exclusive;
  }


  public String getOut_time() {
    return out_time;
  }

  public void setOut_time(String out_time) {
    this.out_time = out_time;
  }


  public String getIn_time() {
    return in_time;
  }

  public void setIn_time(String in_time) {
    this.in_time = in_time;
  }


  public String getTarget() {
    return target;
  }

  public void setTarget(String target) {
    this.target = target;
  }


  public Integer getTransfer_id() {
    return transfer_id;
  }

  public void setTransfer_id(Integer transfer_id) {
    this.transfer_id = transfer_id;
  }

}
