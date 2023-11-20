package com.ohgiraffers.shop.service;

import com.ohgiraffers.shop.model.dao.MenuDAO;
import com.ohgiraffers.shop.model.dto.MenuDTO;
import com.ohgiraffers.shop.model.vo.MenuVo;

import javax.naming.ContextNotEmptyException;
import java.sql.Connection;
import java.util.List;
import static com.ohgiraffers.shop.common.JDBCTemplate.*;
public class MenuService {
    private MenuDAO menuDAO;

    public MenuService(String url) {
        this.menuDAO = new MenuDAO(url);
    }

    public List<MenuVo> findMenu(){
        Connection con = getConnection();

        List<MenuVo> list = menuDAO.findOrder(con);

        close(con);

        return list;
    }


    public int registMenu(MenuDTO menuDTO) {
        Connection con = getConnection();
        List<String> category = menuDAO.findDisCode(con);

        if(!category.contains(menuDTO.getDiscountCode())){                      // 중요하게 고려해야함
            return 0;
        }
        int result = menuDAO.registOrder(con, menuDTO);

        close(con);

        return result;
    }
    public int giveNum(MenuDTO menuDTO) {
        Connection con = getConnection();
        List<String> category = menuDAO.findDisCode(con);

        if(!category.contains(menuDTO.getDiscountCode())){                      // 중요하게 고려해야함
            return 0;
        }
        int result = menuDAO.giveNum(con, menuDTO);

        close(con);

        return result;
    }



}
