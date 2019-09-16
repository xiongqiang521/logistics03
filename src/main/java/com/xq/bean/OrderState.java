package com.xq.bean;;


public class OrderState {

  private Integer id;
  private String state;

  @Override
  public String toString() {
    return "OrderState{" +
            "id=" + id +
            ", state='" + state + '\'' +
            '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

}
