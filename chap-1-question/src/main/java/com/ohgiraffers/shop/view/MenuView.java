package com.ohgiraffers.shop.view;

import com.ohgiraffers.shop.controller.MenuCtr;
import com.ohgiraffers.shop.service.MenuService;


import java.util.Scanner;

public class MenuView {

    public static void runApplication() {

        Scanner scr = new Scanner(System.in);
        MenuCtr menuCtr = new MenuCtr(new MenuService("src/main/resources/mapper/menu-query.xml"));

        loop:
        while (true) {
            System.out.println("메뉴관리 프로그램 입니다.");
            System.out.println(" 1. 가격등록 \n 2. 주문하기 \n 3. 주문조회 \n 종료 시 다른 버튼");
            int step = scr.nextInt();

            switch (step){
                case 1 : break ;
                case 2 : break ;
                case 3 : break ;
                default: return;
            }


        }
    }
}
