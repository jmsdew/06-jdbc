package com.ohgiraffers.common;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplate {

    public static Connection getConnection(){
        Connection con = null;

        Properties prop = new Properties();

        try {
            prop.load(new FileReader("src/main/java/com/ohgiraffers/config/connection-info.properties"));   // filenotfound 이줄만
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            // io  위 세줄 전체
            con = DriverManager.getConnection(url,prop);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();          // io 안에 filenotfound가 있음 에러를 세분화해야함.
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;

    }

    public static void close(Connection con){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(Statement stmt){
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rset){
        try {
            rset.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
