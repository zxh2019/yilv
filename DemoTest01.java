package com.newjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 事务练习
 */
public class DemoTest01 {
    //"jdbc:mysql://localhost:3366/myschool", "root", "875072"
    public static final String URL = "jdbc:mysql://localhost:3366/myschool";
    public static final String USER = "root";
    public static final String PASSWD = "875072";

    public static void jdbcTransaction(int id) {
        Connection connection = null;
        PreparedStatement pstmUpdate = null;
        PreparedStatement pstmQuery = null;
        String updatesql = "update user set name = '国服韩信' where id= 1" ;
        String querysql = "select * from User";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWD);
            connection.setAutoCommit(false);

            pstmUpdate = connection.prepareStatement(updatesql);
            pstmQuery = connection.prepareStatement(querysql);

            pstmUpdate.executeUpdate();
            pstmQuery.executeQuery();

            connection.commit();
            connection.setAutoCommit(true);


            pstmUpdate.close();
            pstmQuery.close();
            connection.close();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
//                e1.printStackTrace();
            }
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmUpdate != null) {
                    pstmUpdate.close();
                }
                if (pstmQuery != null) {
                    pstmQuery.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        jdbcTransaction(1);
    }

}
