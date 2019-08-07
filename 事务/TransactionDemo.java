package day18.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDemo {
    public static void main(String[] args) throws SQLException {
        Connection connection = JdbcUtil.getInstance().getConnection();
        // 关闭自动提交
        connection.setAutoCommit(false);

        String sql = "insert into course values(null,'xdd',11,23)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeQuery();

        String sql2 = "update course set cname='xzz' where cname='xdd'";
        preparedStatement = connection.prepareStatement(sql2);
        preparedStatement.executeQuery();

        //提交
        connection.commit();

        preparedStatement.close();
        connection.close();

    }
}
