package com.ohgiraffers.section01;

import com.ohgiraffers.model.dto.Employee2DTO;
import com.ohgiraffers.model.dto.EmployeeDTO;
import com.ohgiraffers.section01.service.App4Service;

import static com.ohgiraffers.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;

public class Application04 {
    public static void main(String[] args){

        /*
        * 객체(object)는 사전적인 정의로 실제 존재하는 것을 말한다.
        *
        * 개체 - 생물학에서의 개체는 하나의 생물체를 뜻한다.
        * 사람 김연아 = new 사람();
        *
        *
        * 아래의 정답 중 개체를 골라주세요
        * 1.쥐
        * 2.미키마우스
        * 3.제리
        * 4.사람
        * 5.손연재
        * 장답 2 3 5
        *
        * */

        /* 200
         * 선동일
         * 621235-1985634
         * sun_di@greedy.com
         * 01099546325
         * D9
         * J1
         * S1
         * 8000000
         * 0.3
         * 1990-02-06
         * N
         * */
        
        // 기본 생성시
        Employee2DTO nonBuilder = new Employee2DTO();
        nonBuilder.setEmpId("200");
        nonBuilder.setEmpName("선동일");
        
        // 빌더를 이용하면 일부분만 넣으면서 확인도 가능하고 일부분을 넣을 때마다 생성자를 만들지 않아도 된다.
        EmployeeDTO builderEmp = new EmployeeDTO()
                    .setEmpNo("621235-1985634")     
                    .setName("선동일")
                    .setEmpId("200")
                    .setJobCode("J1");


        System.out.println(builderEmp);
        Connection con = getConnection();
        App4Service service = new App4Service();
        Statement stmt = null;
        ResultSet rset = null;

        Scanner scr = new Scanner(System.in);
        System.out.println("조회할 사번을 입력해주세요 : ");
        String empId = scr.nextLine();

        String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = '" +empId+"'";
        EmployeeDTO emp = null;

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            if(rset.next()){
                        emp = new EmployeeDTO()
                        .setEmpNo(rset.getString("EMP_NO"))
                        .setEmpId(rset.getString("EMP_ID"))
                        .setName(rset.getString("EMP_NAME"))
                        .setEmail(rset.getString("EMAIL"))
                        .setPhone(rset.getString("PHONE"));
            }

            service.printEmployee(emp);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(con);
            close(rset);
            close(stmt);

        }

    }
}
