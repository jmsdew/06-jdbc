package com.ohgiraffers.shop.model.dao;

import com.ohgiraffers.shop.model.dto.MenuDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.shop.common.JDBCTemplate.*;
public class MenuDAO {
    Properties prop =  new Properties();

    public MenuDAO(String url) {
        try {
            prop.loadFromXML(new FileInputStream(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int registMenu(Connection con, MenuDTO menuDTO) {
        PreparedStatement stmt = null;
        ResultSet rset = null;
        int result = 0;

        try {
            stmt = con.prepareStatement(prop.getProperty("insertMenu"));
            stmt.setString(1, menuDTO.getOrderCode());
            stmt.setString(2, menuDTO.getUserCode());
            stmt.setString(3, menuDTO.getDiscountCode());


            result = stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(stmt);
        }

        return result;

    }
}
