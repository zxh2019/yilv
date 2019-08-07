package com.train.week5.day2.homework;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 事务练习
 * 两张卡转账问题
 * 本账户中余额减少，转入账户中余额增加相应数量
 */
public class AffairTest {
    //转出用户
   static Account account = new Account(1, "00001", "张三", "123456", 1000);
    //转入用户
    static Account account1 = new Account(2, "00002", "李四", "111111", 5000);
    public static void main(String[] args) {
        transferOut(200);
    }

    public static void transferOut(double transferMoney) {
        Connection connection = JdbcUtil.getInstance().getConnection();
        PreparedStatement preparedStatement = null;



        try {
            //需要手动调用commit，所以把自动掉用设为false
            connection.setAutoCommit(false);
            //String sql = "update account set balance=balance-" + transferMoney + " where accountno=" + account.getAccoutNo();
            //String sql="update account set balance=balance - ?  where accountno=?";
            String sql = "update account set balance = balance - ? where accountno = ?";
            //String sql = "update account set balance=? where accountno=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, transferMoney);
            preparedStatement.setObject(2, account.getAccoutNo());
            int result = preparedStatement.executeUpdate();
            System.out.println(result);
            //回滚测试
           // connection.rollback();


            //String sql1="update account set balance=balance+" + transferMoney + " where accountno=" + account1.getAccoutNo();
            String sql1 = "update account set balance = balance +? where accountno = ?";
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setObject(1, transferMoney);
            preparedStatement.setObject(2, account1.getAccoutNo());
            int result1 = preparedStatement.executeUpdate();
            System.out.println(result1);
            //回滚测试
            //connection.rollback();
            //手动提交
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(preparedStatement);
            JdbcUtil.getInstance().closeResource(connection);
        }

    }
}
