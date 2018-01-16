package com.Mr.Wang.day01;

import org.testng.annotations.*;

public class demo1 {
    @Test
    public void testcase2(){
        System.out.println("第三行运行");
    }

    @BeforeTest
    public void testcase1(){
        System.out.println("第一行运行");

    }

    @BeforeMethod
    public void testcase3(){
        System.out.println("第二行运行");

    }

    @AfterMethod
     public void testcase4(){
        System.out.println("第四行运行");

    }

    @AfterTest
     public void testcase5(){
         System.out.println("最后运行");
    }

    }

