package com.ohgiraffers.section03;

import java.sql.Connection;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.*;
public class Application01 {
    public static void main(String[] args){
        /*transaction*/

        Connection con = getConnection();

        try {
            con.setAutoCommit(false);
/*            if(result <0){                     -- 가능
                con.rollback();
            }*/  

            con.commit();     // 쿼리 정상작동시 마지막으로 커밋
            System.out.println("autoCommit의 현재 값 : " +con.getAutoCommit());
        } catch (SQLException e) {
            try {
                con.rollback();  // 오류시 롤백
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }
}
