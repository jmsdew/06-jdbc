package com.ohgiraffers.restaurant.service;

import com.ohgiraffers.restaurant.model.dao.MenuDAO;
import com.ohgiraffers.restaurant.model.dto.MenuDTO;
import com.ohgiraffers.restaurant.model.vo.MenuVo;

import java.sql.Connection;
import java.util.List;
import java.util.Objects;

import static com.ohgiraffers.restaurant.common.JDBCTemplate.*;
public class MenuService {

    private MenuDAO menuDAO;

    public MenuService(String url) {
        this.menuDAO = new MenuDAO(url);
    }

    public List<MenuVo> findMenu(){
        // DB연결
        Connection con = getConnection();
       // 비즈니스 로직 ex)price > 0
        List<MenuVo> list = menuDAO.findAllMenu(con);

        close(con);
        return list;

    }

    public int insertMenu(MenuDTO menuDTO) {
        Connection con = getConnection();
        List<String> category = menuDAO.findAllCategoryCode(con);

        if(!category.contains(menuDTO.getCategory())){                      // 중요하게 고려해야함
            return 0;
        }

        if(menuDTO.getPrice() <= 1000){
            return 0;
        }

        int result = menuDAO.registMenu(con, menuDTO);

        close(con);

        return result;
    }

    public int updateMenu(MenuDTO menuDTO) {
        Connection con = getConnection();
        List<String> category = menuDAO.findAllCategoryCode(con);

        if(!category.contains(menuDTO.getCategory())){                      // 중요하게 고려해야함
            return 0;
        }

        if(menuDTO.getPrice() <= 1000){
            return 0;
        }

        int result = menuDAO.updateMenu(con, menuDTO);

        close(con);

        return result;
    }
}
