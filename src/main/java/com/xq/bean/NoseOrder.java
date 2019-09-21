package com.xq.bean;

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

    // private Integer send_user_id;
    // private Integer receive_user_id;
    // private Integer order_state_id;
}
