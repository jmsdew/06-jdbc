package com.ohgiraffers.shop.view;

import com.ohgiraffers.shop.controller.MenuCtr;
import com.ohgiraffers.shop.model.dto.MenuDTO;
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
                case 1 :
                    System.out.println(menuCtr.registMenu(registMenu())); break ;
                case 2 :
                    System.out.println(menuCtr.registMenu(insertMEnu()));break ;
                case 3 : break ;
                default: return;
            }


        }
    }

    public static MenuDTO insertMEnu(){
        Scanner scr = new Scanner(System.in);
        MenuDTO order = new MenuDTO();
        System.out.println("=================================");
        System.out.println("기입하실 할인코드를 입력 해주세요");
        order.setDiscountCode(scr.nextLine());
        System.out.println("원가 금액을 입력 해주세요");
        int a = scr.nextInt();
        System.out.println("할인되는 퍼센트를 입력 해주세요");
        int b = scr.nextInt();
        order.setDiscountMoney(a*(1-b/100));

        return  order;

    }

    public static MenuDTO registMenu(){
        MenuDTO order = new MenuDTO();
        Scanner scr = new Scanner(System.in);
        System.out.println("=================================");
        System.out.println();
        System.out.print("주문하실 상품 코드의 할인코드를 입력 해주세요 : " );
        order.setOrderCode(scr.nextLine());
        System.out.print("아이디를 입력 해주세요 : " );
        order.setUserCode(scr.nextLine());



        // 일반적으로 front에서 js를 이용하여 1차 유효성 검사를 진행한다.
        return order;

    }
}
