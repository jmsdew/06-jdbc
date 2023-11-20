package com.ohgiraffers.shop.view;

import com.ohgiraffers.shop.controller.MenuCtr;
import com.ohgiraffers.shop.model.dto.MenuDTO;
import com.ohgiraffers.shop.model.vo.MenuVo;
import com.ohgiraffers.shop.service.MenuService;


import java.sql.SQLOutput;
import java.util.List;
import java.util.Objects;
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
                    System.out.println(menuCtr.giveNum(giveNum()));break ;
                case 2 :
                    System.out.println(menuCtr.registMenu(registMenu())); break ;
                case 3 : viewMenu(menuCtr.findOrder()); break ;
                default: return;
            }


        }
    }

    public static void viewMenu(List<MenuVo> menuList){
        if(Objects.isNull(menuList)){           // 첫번째 조건 empty
            System.out.println("조회중 오류가 발생됨");
        } else if ( menuList.size()<0) {
            System.out.println("등록된 메뉴가 없네요");
        }else{
            for (MenuVo menu:menuList) {
                System.out.println(menu);
            }
        }


    }

    public static MenuDTO giveNum(){
        Scanner scr = new Scanner(System.in);
        MenuDTO order = new MenuDTO();
        System.out.println("=================================");
        System.out.println("기입하실 할인코드를 입력 해주세요");
        order.setDiscountCode(scr.nextLine());
        System.out.println("원가 금액을 입력 해주세요");
        int a = scr.nextInt();
        System.out.println("할인되는 퍼센트를 입력 해주세요");
        int b = scr.nextInt();
        order.setDiscountMoney(a-(a*b/100));

        return  order;

    }

    public static MenuDTO registMenu(){
        MenuDTO order = new MenuDTO();
        Scanner scr = new Scanner(System.in);
        System.out.println("=================================");
        System.out.println();
        System.out.println("주문코드를 입력 해주세요");
        order.setOrderCode(scr.nextLine());
        System.out.print("아이디를 입력 해주세요 : " );
        order.setUserCode(scr.nextLine());
        System.out.print("주문하실 상품 코드의 할인코드를 입력 해주세요 : " );
        order.setDiscountCode(scr.nextLine());



        return order;

    }
}
