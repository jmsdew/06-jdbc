package com.ohgiraffers.understand;


import static com.ohgiraffers.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Application01 {
    public static void main(String[] args) {

        Connection con = getConnection();             // 연결
        Statement stmt = null;                        // SQL 구문을 실행하는 역할
        Statement stmt1 = null;
        ResultSet rset = null;                       // SELECT의 결과를 저장하는 객체
        ResultSet rset1 = null;

        try {
            stmt = con.createStatement();
            stmt1 = con.createStatement();

            rset = stmt.executeQuery("SELECT *,MAX(SALARY) FROM EMPLOYEE");
            rset1 = stmt1.executeQuery("SELECT * FROM EMPLOYEE A JOIN JOB B ON A.JOB_CODE = B.JOB_CODE WHERE A.EMP_NAME='선동일'");

            while (rset.next()) {
                System.out.println(rset.getString("EMP_ID") + " " + rset.getString("EMP_NAME") + " "
                        + rset.getString("PHONE")+" " + rset.getString("SALARY")+"원");
            }
            while (rset1.next()) {
                System.out.println(rset1.getString("EMP_ID") + " " + rset1.getString("EMP_NAME") + " "
                        + rset1.getString("PHONE") + " " + rset1.getString("JOB_NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();


        }finally {
            close(con);
            close(rset);
            close(rset1);
            close(stmt);
            close(stmt1);
        }
    }
}

