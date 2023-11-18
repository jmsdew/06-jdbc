package com.ohgiraffers.shop.service;

import com.ohgiraffers.shop.model.dao.MenuDAO;

public class MenuService {
    private MenuDAO menuDAO;

    public MenuService(String url) {
        this.menuDAO = new MenuDAO();
    }

}
