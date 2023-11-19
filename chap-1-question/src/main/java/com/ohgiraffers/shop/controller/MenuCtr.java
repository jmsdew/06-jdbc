package com.ohgiraffers.shop.controller;

import com.ohgiraffers.shop.model.dto.MenuDTO;
import com.ohgiraffers.shop.service.MenuService;

import java.util.Objects;
import java.util.Scanner;

public class MenuCtr {

    private MenuService menuService;


    public MenuCtr(MenuService menuService) {
        this.menuService = menuService;
    }

    public String registMenu(MenuDTO menuDTO){
        if(Objects.isNull(menuDTO)){
            System.out.println("메뉴가 없네요");
            return "메뉴 정보가 존재하지 않아요 ";
        }
        if(menuDTO.getOrderCode() == null || menuDTO.getOrderCode().equals("")){
            return "메뉴 이름을 등록해주세요";
        }
        if (menuDTO.getUserCode() == null || menuDTO.getUserCode().equals("")){
            return "아이디를 기입 해주세요";
        }
        if(menuDTO.getDiscountCode() == null || menuDTO.getDiscountCode().equals("")){
            return "주문하실 상품 할인코드를 입력 해주세요";
        }

        // 유효성 검사가 끝난 메뉴
        int result = menuService.registMenu(menuDTO);

        if(result <= 0){
            return "등록중 오류가 발생됨";
        }else {
            return "등록 완료";
        }
    }


}
