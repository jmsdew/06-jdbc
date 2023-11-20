package com.ohgiraffers.restaurant.model.dto;

public class MenuDTO {        // 값을 입력하는 용도

    private String menuName;
    private int price;
    private String category;
    private String status;
    private String oldMenuName;

    public MenuDTO() {
    }

    public MenuDTO(String menuName, int price, String category, String status) {
        this.menuName = menuName;
        this.price = price;
        this.category = category;
        this.status = status;
    }

    public MenuDTO(String menuName, int price, String category, String status, String oldMenuName) {
        this.menuName = menuName;
        this.price = price;
        this.category = category;
        this.status = status;
        this.oldMenuName = oldMenuName;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOldMenuName() {
        return oldMenuName;
    }

    public void setOldMenuName(String oldMenuName) {
        this.oldMenuName = oldMenuName;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "menuName='" + menuName + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

}
