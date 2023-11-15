package com.ohgiraffers.section01.connection;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Application03 {
    public static void main(String[] args){

        Properties prop = new Properties();
        Connection con = null;

        try {
            prop.load(new FileReader("src/main/java/com/ohgiraffers/config/connection-info.properties"));
            String driver = prop.getProperty("driver");    // key값을 받아와 밸류값을 넣어줌
            String url = prop.getProperty("url"); //DB접속 경로
            String user = prop.getProperty("user"); // DB 아이디
            String password = prop.getProperty("password"); // DB id 비밀번호

            // drivermanager.getconnection은 매개변수로 url user(db-id) password(id비밀번호)를 전달해주면
            // 연결하려고 하는 driver를 찾아서 해당 db서버의 데이터베이스에 연결하는 메서드이다.
                con = DriverManager.getConnection(url,user,password);
                System.out.println(con);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                con.close();
                // connection은 마지막에 꼭 닫아줘야함
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
