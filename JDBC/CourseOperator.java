package day18.jdbc;

import day10.CollectionTrain.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseOperator implements CourseOperatable{

    static Connection connection = JdbcUtil.getInstance().getConnection();
    static PreparedStatement preparedStatement = null;
    static ResultSet rs = null;
    static List<Course> courseList = new ArrayList<>();

    //按照名字模糊查询,查首字母为cname的所有记录
    @Override
    public void findByCNameLike(String cName) {
        String sql = "select * from course where cname like ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1,cName+"%");
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                Course course = new Course();
                course.setCno(rs.getInt(1));
                course.setCname(rs.getString(2));
                course.setCpno(rs.getInt(3));
                course.setCcredit(rs.getInt(4));
                System.out.println(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.getInstance().closeResource(rs);
            JdbcUtil.getInstance().closeResource(preparedStatement);
            JdbcUtil.getInstance().closeResource(connection);
        }
    }

    //根据ccredit进行降序
    @Override
    public void findOrderByCName() {
        String sql = "select * from course order by ccredit desc";

        try {
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                Course course = new Course();
                course.setCno(rs.getInt(1));
                course.setCname(rs.getString(2));
                course.setCpno(rs.getInt(3));
                course.setCcredit(rs.getInt(4));
                System.out.println(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.getInstance().closeResource(rs);
            JdbcUtil.getInstance().closeResource(preparedStatement);
            JdbcUtil.getInstance().closeResource(connection);
        }
    }

     //完成根据某个字段模糊查找并排序（升序），然后分页获取第二页数据的操作（每页显示2条）
    @Override
    public void findByUserNameLikeOrderLimit(String cName, int currPage, int pageSize) {
        String sql = "select * from course where cname like ? order by ccredit limit ?,?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1,cName+"%");   //模糊查询条件
            preparedStatement.setObject(2,(currPage - 1)*pageSize); //当前页的第一个数 =（当前页页数-1）*页码
            preparedStatement.setObject(3,pageSize);    //  页码

            rs = preparedStatement.executeQuery();
            while(rs.next()){
                Course course = new Course();
                 course.setCno(rs.getInt(1));
                 course.setCname(rs.getString(2));
                 course.setCpno(rs.getInt(3));
                 course.setCcredit(rs.getInt(4));
                System.out.println(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.getInstance().closeResource(rs);
            JdbcUtil.getInstance().closeResource(preparedStatement);
            JdbcUtil.getInstance().closeResource(connection);
        }

    }
}
