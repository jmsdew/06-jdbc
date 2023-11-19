package com.ohgiraffers.shop.service;

import com.ohgiraffers.shop.model.dao.MenuDAO;
import com.ohgiraffers.shop.model.dto.MenuDTO;

import java.sql.Connection;
import java.util.List;
import static com.ohgiraffers.shop.common.JDBCTemplate.*;
public class MenuService {
    private MenuDAO menuDAO;

    public MenuService(String url) {
        this.menuDAO = new MenuDAO(url);
    }

    public int registMenu(MenuDTO menuDTO) {
        Connection con = getConnection();






        int result = menuDAO.registMenu(con, menuDTO);

        close(con);

        return result;
    }
}
