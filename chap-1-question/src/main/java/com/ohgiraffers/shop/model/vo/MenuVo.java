package com.ohgiraffers.shop.model.vo;

public class MenuVo {

    private String orderNum;
    private String UserNum;
    private String disNum;

    public MenuVo() {
    }

    public MenuVo(String orderNum, String userNum, String disNum) {
        this.orderNum = orderNum;
        this.UserNum = userNum;
        this.disNum = disNum;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getUserNum() {
        return UserNum;
    }

    public void setUserNum(String userNum) {
        UserNum = userNum;
    }

    public String getDisNum() {
        return disNum;
    }

    public void setDisNum(String disNum) {
        this.disNum = disNum;
    }

    @Override
    public String toString() {
        return "MenuVo{" +
                "orderNum='" + orderNum + '\'' +
                ", UserNum='" + UserNum + '\'' +
                ", disNum='" + disNum + '\'' +
                '}';
    }
}
