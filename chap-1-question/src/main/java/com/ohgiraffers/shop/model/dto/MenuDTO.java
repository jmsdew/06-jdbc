package com.ohgiraffers.shop.model.dto;

public class MenuDTO {

    private String orderCode;
    private String userCode;
    private String discountCode;

    public MenuDTO() {
    }

    public MenuDTO(String orderCode, String userCode, String discountCode) {
        this.orderCode = orderCode;
        this.userCode = userCode;
        this.discountCode = discountCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "orderCode='" + orderCode + '\'' +
                ", userCode='" + userCode + '\'' +
                ", discountCode='" + discountCode + '\'' +
                '}';
    }
}
