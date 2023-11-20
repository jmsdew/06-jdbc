package com.ohgiraffers.shop.model.dao;

import com.ohgiraffers.shop.model.dto.MenuDTO;
import com.ohgiraffers.shop.model.vo.MenuVo;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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

    public List<MenuVo> findOrder(Connection con){
        Statement stmt = null;
        ResultSet rset = null;
        List<MenuVo> resultList = new ArrayList<>();

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(prop.getProperty("findOrder"));

            while(rset.next()){
                resultList.add(new MenuVo(rset.getString(1),
                                    rset.getString(2),
                                    rset.getString(3)));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rset);
            close(stmt);
        }
        return resultList;
    }

    public List<String> findDisCode(Connection con) {
        Statement stmt = null;
        ResultSet rset = null;
        List<String> resultList = new ArrayList<>();

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(prop.getProperty("findDisCode"));

            while (rset.next()){
                resultList.add(rset.getString(1));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(stmt);
            close(rset);
        }

        return resultList;

    }

    public int giveNum(Connection con, MenuDTO menuDTO){
        PreparedStatement stmt = null;
        int result = 0;

        try {
            stmt = con.prepareStatement(prop.getProperty("updatePrice"));
            stmt.setInt(1, menuDTO.getDiscountMoney());
            stmt.setString(2, menuDTO.getDiscountCode());

            result = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(stmt);
        }
        return result;
    }

    public int registOrder(Connection con, MenuDTO menuDTO){
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        int result = 0;

        try {
            pstmt = con.prepareStatement(prop.getProperty("insertOrder"));
            pstmt.setString(1,menuDTO.getOrderCode());
            pstmt.setString(2,menuDTO.getUserCode());
            pstmt.setString(3, menuDTO.getDiscountCode());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstmt);
        }
        return result;

    }
}
