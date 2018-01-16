package com.Mr.Wang.day01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class demo2 {
    @Test
    public void testassert(){
        int a = 5;
        int b = 5;
        Assert.assertEquals(a,b);

    }
}
