package day13.add.delete.update.select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        StudentOperator so=new StudentOperator();
//        so.selectAll();

//        Student student=new Student();
//        student.setsNo("104");
//        student.setsName("xiaoz");
//        student.setsSex("M");
//        student.setClz("99999");
//        int x=so.insertMethod(student);
//        System.out.println(x);
        System.out.println(so.deleteMethod("101"));

    }
}
