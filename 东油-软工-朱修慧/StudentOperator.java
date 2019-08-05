package day13.add.delete.update.select;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class StudentOperator implements IStudent {
    Connection connection=ConnectionClz.getIntense().getConnectionClz();
    Statement statement=null;
    ResultSet rs=null;
    static int count=0;

    //  查询方法
    @Override
    public List<Student> selectAll() {
        try {
            statement=connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql="select * from student";
        try {
            rs=statement.executeQuery(sql);
            while(rs.next()){
                Student student=new Student();
                student.setsNo(rs.getString(1));
                student.setsName(rs.getString(2));
                student.setsSex(rs.getString(3));
                student.setClz(rs.getString(4));
                System.out.println(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(rs);
            closeAll(statement);
            closeAll(connection);
        }

        return null;
    }

    // 修改方法

    public int updateMethod(Student student){
        try {
            statement = connection.createStatement();
            StringBuffer sb=new StringBuffer();
            sb.append("update student set sname='");
            sb.append(student.getsName());
            sb.append("',");


            sb.append("ssex='");
            sb.append(student.getsSex());
            sb.append("',");

            sb.append("class='");
            sb.append(student.getClz());
            sb.append("'");
            sb.append("where sno='");
            sb.append(student.getsNo());
            sb.append("';");
            count=statement.executeUpdate(sb.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(statement);
            closeAll(connection);
        }
        return count;
    }

    //  添加方法
    public int insertMethod(Student student){
        try {
            statement = connection.createStatement();
            StringBuffer sb=new StringBuffer();
            sb.append("insert into student  values( sno='");
            sb.append(student.getsNo());
            sb.append("',");

            sb.append("sname='");
            sb.append(student.getsName());
            sb.append("',");

            sb.append("ssex='");
            sb.append(student.getsSex());
            sb.append("',");

            sb.append("class='");
            sb.append(student.getClz());
            sb.append("');");
            System.out.println(sb);
            count=statement.executeUpdate(sb.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(statement);
            closeAll(connection);
        }
        return count;
    }

    // 删除方法
    public int deleteMethod(String sno){
        try {
            statement = connection.createStatement();
            StringBuffer sb=new StringBuffer();
            sb.append("delete from student where sno='");
            sb.append(sno);
            sb.append("';");
            System.out.println(sb);
            count=statement.executeUpdate(sb.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(statement);
            closeAll(connection);
        }
        return count;
    }


    public static void closeAll(AutoCloseable ac){
        try {
            ac.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
