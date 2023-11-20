package com.ohgiraffers.restaurant.model.dao;

import com.ohgiraffers.restaurant.model.dto.MenuDTO;
import com.ohgiraffers.restaurant.model.vo.MenuVo;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static com.ohgiraffers.restaurant.common.JDBCTemplate.*;
public class MenuDAO {

    Properties prop =  new Properties();

    public MenuDAO(String url) {
        try {
            prop.loadFromXML(new FileInputStream(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<MenuVo> findAllMenu(Connection con){
        Statement stmt = null;
        ResultSet rset = null;
        List<MenuVo> rseultList = new ArrayList<>();

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(prop.getProperty("findAllMenu"));

            while(rset.next()){
                rseultList.add(new MenuVo(rset.getInt(1),
                        rset.getString(2),
                        rset.getInt(3),
                        rset.getString(4),
                        rset.getString(5)));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rset);
            close(stmt);
        }

        return rseultList;
    }


    /**
     * 카테고리 코드가 존재하는지 확인한다.
     * @param  con Connection
     * @return List<Integer>
     * */
    public List<String> findAllCategoryCode(Connection con) {
        Statement stmt = null;
        ResultSet rset = null;
        List<String> rseultList = new ArrayList<>();

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(prop.getProperty("findAllCategory"));

            while(rset.next()){
                rseultList.add(rset.getString(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rset);
            close(stmt);
        }

        return rseultList;
    }

    public int registMenu(Connection con, MenuDTO menuDTO) {
        PreparedStatement stmt = null;
        ResultSet rset = null;
        int result = 0;

        try {
            stmt = con.prepareStatement(prop.getProperty("insertMenu"));
            stmt.setString(1, menuDTO.getMenuName());
            stmt.setInt(2,menuDTO.getPrice());
            stmt.setString(3, menuDTO.getCategory());
            stmt.setString(4, menuDTO.getStatus());


            result = stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(stmt);
        }

        return result;

    }

    public int updateMenu(Connection con, MenuDTO menuDTO){
        PreparedStatement stmt = null;
        int result = 0;

        try {
            stmt = con.prepareStatement(prop.getProperty("updateMenu"));
            stmt.setString(1, menuDTO.getMenuName());
            stmt.setInt(2,menuDTO.getPrice());
            stmt.setString(3, menuDTO.getCategory());
            stmt.setString(4, menuDTO.getStatus());
            stmt.setString(5,menuDTO.getOldMenuName());

            result = stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(stmt);

        }
        return result;
    }
}
