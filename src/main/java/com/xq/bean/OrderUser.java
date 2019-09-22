package com.xq.bean;

/**
 * @ProjectName: logistics03
 * @Package: com.xq.bean
 * @ClassName: OrderUser
 * @Author: yaoxiaolei
 * @Description:封装寄件的数据
 * @Date: 2019/9/20 16:39
 * @Version: 1.0
 */
/**
 private Integer id;
 private String user_id;
 private String name;
 private String password;
 private String create_time;
 private String state;
 private String telephone;
 以上为寄件人信息



 */
public class OrderUser {

    //这是寄件人的属性
    private Integer id;
    private String user_id;
    private String name;
    private String password;
    private String create_time;
    private String state;
    private String telephone;
//这是寄件人 属性
    private Integer sid;
    private String suser_id;
    private String sname;
    private String spassword;
    private String screate_time;
    private String sstate;
    private String stelephone;
    //收件人地址
    private String sendaddress;
    //寄件人地址
    private String receiveaddress;
    //重量
    private double weiht;



    public String getSendaddress() {
        return sendaddress;
    }

    public void setSendaddress(String sendaddress) {
        this.sendaddress = sendaddress;
    }

    public String getReceiveaddress() {
        return receiveaddress;
    }

    public void setReceiveaddress(String receiveaddress) {
        this.receiveaddress = receiveaddress;
    }

    public double getWeiht() {
        return weiht;
    }

    public void setWeiht(double weiht) {
        this.weiht = weiht;
    }

    public OrderUser(Integer id, String user_id, String name, String password, String create_time, String state, String telephone, Integer sid, String suser_id, String sname, String spassword, String screate_time, String sstate, String stelephone) {
        this.id = id;
        this.user_id = user_id;
        this.name = name;
        this.password = password;
        this.create_time = create_time;
        this.state = state;
        this.telephone = telephone;
        this.sid = sid;
        this.suser_id = suser_id;
        this.sname = sname;
        this.spassword = spassword;
        this.screate_time = screate_time;
        this.sstate = sstate;
        this.stelephone = stelephone;
    }


    public OrderUser() {
        super();
    }

    @Override
    public String toString() {
        return "OrderUser{" +
                "id=" + id +
                ", user_id='" + user_id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", create_time='" + create_time + '\'' +
                ", state='" + state + '\'' +
                ", telephone='" + telephone + '\'' +
                ", sid=" + sid +
                ", suser_id='" + suser_id + '\'' +
                ", sname='" + sname + '\'' +
                ", spassword='" + spassword + '\'' +
                ", screate_time='" + screate_time + '\'' +
                ", sstate='" + sstate + '\'' +
                ", stelephone='" + stelephone + '\'' +
                ", sendaddress='" + sendaddress + '\'' +
                ", receiveaddress='" + receiveaddress + '\'' +
                ", weiht=" + weiht +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSuser_id() {
        return suser_id;
    }

    public void setSuser_id(String suser_id) {
        this.suser_id = suser_id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }

    public String getScreate_time() {
        return screate_time;
    }

    public void setScreate_time(String screate_time) {
        this.screate_time = screate_time;
    }

    public String getSstate() {
        return sstate;
    }

    public void setSstate(String sstate) {
        this.sstate = sstate;
    }

    public String getStelephone() {
        return stelephone;
    }

    public void setStelephone(String stelephone) {
        this.stelephone = stelephone;
    }








}
