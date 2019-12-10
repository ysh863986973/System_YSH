package com.ysh.mycompare.impl;

import com.ysh.mycompare.MyCompare;
import com.ysh.pojo.User;

public class EndAge implements MyCompare {
    @Override
    public boolean compare(User u1, User u2) {
        return u1.getAge() > u2.getAge();
    }
}
