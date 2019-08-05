package day13.add.delete.update.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClz {
    // 构造器私有，创建单例
    private ConnectionClz(){

    }
    // 恶汉模式，直接定义好
    static ConnectionClz connectionClz=new ConnectionClz();
    // 获取单例方法
    public static ConnectionClz getIntense(){
        return connectionClz;
    }
    // 建立连接方法
    static Connection connection=null;
    public Connection getConnectionClz(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/zhu","root","666666");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
