package day18.jdbc;

public class Main {
    public static void main(String[] args) {
        CourseOperator courseOperator = new CourseOperator();
        courseOperator.findByCNameLike("x");
        //courseOperator.findOrderByCName();
     // courseOperator.findByUserNameLikeOrderLimit("x",2,2);
        
    }
}
