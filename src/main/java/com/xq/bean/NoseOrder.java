package com.xq.bean;

import java.util.List;

/**
 * @author Mechrevo
 * @version v1.0
 * 2019/9/21 16:42
 */
public class NoseOrder {


    // private String id;
    private Integer order_id;

    private String send_time;
    private Users send_user;
    private String send_address;

    private String receive_time;
    private Users receive_user;
    private String receive_address;

    private Double weight;
    private String money;
    private OrderState orderState;
    private List<OrderTransferInfoName> infos;

    public Integer getOrder_id() {

        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getSend_time() {
        return send_time;
    }

    public void setSend_time(String send_time) {
        this.send_time = send_time;
    }

    public Users getSend_user() {
        return send_user;
    }

    public void setSend_user(Users send_user) {
        this.send_user = send_user;
    }

    public String getSend_address() {
        return send_address;
    }

    public void setSend_address(String send_address) {
        this.send_address = send_address;
    }

    public String getReceive_time() {
        return receive_time;
    }

    public void setReceive_time(String receive_time) {
        this.receive_time = receive_time;
    }

    public Users getReceive_user() {
        return receive_user;
    }

    public void setReceive_user(Users receive_user) {
        this.receive_user = receive_user;
    }

    public String getReceive_address() {
        return receive_address;
    }

    public void setReceive_address(String receive_address) {
        this.receive_address = receive_address;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public List<OrderTransferInfoName> getInfos() {
        return infos;
    }

    public void setInfos(List<OrderTransferInfoName> infos) {
        this.infos = infos;
    }
    // private Integer send_user_id;
    // private Integer receive_user_id;
    // private Integer order_state_id;
}
