package com.train.week5.day2.homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * .根据昨天练习的表，完成名称或其他字段模糊查找
 * ​       方法名，如：findByUserNameLike(String userName)
 * 完成根据某个字段模糊查找并排序（升序），然后分页获取第二页数据的操作（每页显示2条）
 * 方法名，如：findByUserNameLikeOrderLimit(String userName，int currPage, int pageSize)
 * userName:用户名
 * currPage:当前页
 * pageSize:每页显示的数量
 */

/**
 * .根据昨天练习的表，完成根据某个字段进行排序（降序）的操作
 * ​                 方法名，如：findOrderByUserName()
 */
public class LikeTest {
    static Connection connecton = JdbcUtil.getInstance().getConnection();
    static PreparedStatement preparedStatement = null;


    public static void main(String[] args) {
        //findByHeroNameLike("弈");
        //findOrderBySno();
        findByHeroNameLikeOrderLimit("火",2,2);

    }

    public static void findByHeroNameLike(String nameLike) {
        ResultSet resultSet = null;
        List<Hero> listHero = new ArrayList<>();
        //String sql="select * from hero where sname like"+" '%"+nameLike+"%'";
        String sql1 = "select * from hero where sname like ?";
        try {
            preparedStatement = connecton.prepareStatement(sql1);
            System.out.println(sql1);
            preparedStatement.setObject(1, "%" + nameLike + "%");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Hero hero = new Hero();
                hero.setId(resultSet.getInt(1));
                hero.setSno(resultSet.getString(2));
                hero.setSname(resultSet.getString(3));
                hero.setSsex(resultSet.getString(4));
                hero.setSage(resultSet.getInt(5));
                listHero.add(hero);
                //直接输出，
               // System.out.println(hero.toString());
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(resultSet);
            JdbcUtil.getInstance().closeResource(preparedStatement);
            JdbcUtil.getInstance().closeResource(connecton);

        }

    }

    public static void findOrderBySno() {
        ResultSet resultSet = null;
        List<Hero> listHero = new ArrayList<>();
        String sql1 = "select * from hero order by sno";
        try {
            preparedStatement = connecton.prepareStatement(sql1);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Hero hero = new Hero();
                hero.setId(resultSet.getInt(1));
                hero.setSno(resultSet.getString(2));
                hero.setSname(resultSet.getString(3));
                hero.setSsex(resultSet.getString(4));
                hero.setSage(resultSet.getInt(5));
                listHero.add(hero);
                //直接输出，用于测试
                //System.out.println(hero.toString());
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(resultSet);
            JdbcUtil.getInstance().closeResource(preparedStatement);
            JdbcUtil.getInstance().closeResource(connecton);
        }
    }

    public static void findByHeroNameLikeOrderLimit(String userName,int currPage, int pageSize){
        ResultSet resultSet = null;
        List<Hero> listHero = new ArrayList<>();
        //String aa="select * from hero where sname like '火' order by sno  limit (currPage-1)*pageSize,currPage*pageSize";
        String sql="select * from hero where sname like ? order by sno limit ?,?";
        try {
            preparedStatement = connecton.prepareStatement(sql);
            preparedStatement.setObject(1,"%"+userName+"%");
            preparedStatement.setObject(2, (currPage-1)*pageSize);
            preparedStatement.setObject(3, currPage*pageSize);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Hero hero = new Hero();
                hero.setId(resultSet.getInt(1));
                hero.setSno(resultSet.getString(2));
                hero.setSname(resultSet.getString(3));
                hero.setSsex(resultSet.getString(4));
                hero.setSage(resultSet.getInt(5));
                listHero.add(hero);
                //直接输出，
                 System.out.println(hero.toString());
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(resultSet);
            JdbcUtil.getInstance().closeResource(preparedStatement);
            JdbcUtil.getInstance().closeResource(connecton);

        }
    }

}