package com.ysh.mycompare;

import com.ysh.pojo.User;

/**
 * 自定义比较器
 *
 * @author Anonymous
 * @date 2019-10-14 9:32
 */
public interface MyCompare {
    /**
     * 自定义比较器方法，比较两个User类对象
     * @param u1 管理员输入的数据
     * @param u2 数据库里的数据
     * @return 满足条件返回true，不满足返回false
     */
    boolean compare(User u1, User u2);
}
