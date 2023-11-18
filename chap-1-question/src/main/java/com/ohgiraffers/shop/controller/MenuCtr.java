package com.ohgiraffers.shop.controller;

import com.ohgiraffers.shop.service.MenuService;

public class MenuCtr {

    private MenuService menuService;


    public MenuCtr(MenuService menuService) {
        this.menuService = menuService;
    }
}
