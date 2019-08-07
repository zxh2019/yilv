package day18.jdbc;

import java.util.List;

public interface CourseOperatable {


    /**
     * 根据名称模糊查找
     * @param cName
     */
     void findByCNameLike(String cName);

    /**
     * 根据ccredit进行降序的操作
     */
     void findOrderByCName();

    /**
     *完成根据某个字段模糊查找并排序（升序），然后分页获取第二页数据的操作（每页显示2条）
     * @param cName
     * @param currPage
     * @param pageSize
     */
    void findByUserNameLikeOrderLimit(String cName, int currPage, int pageSize);


}
