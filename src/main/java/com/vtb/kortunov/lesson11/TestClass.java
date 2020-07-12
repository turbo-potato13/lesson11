package com.vtb.kortunov.lesson11;

import com.vtb.kortunov.lesson11.annotation.AfterSuite;
import com.vtb.kortunov.lesson11.annotation.BeforeSuite;
import com.vtb.kortunov.lesson11.annotation.Test;

public class TestClass {

    @BeforeSuite
    public static void firstMethod() {
        System.out.println("First Method");
    }

    @Test(priority = 1)
    public static void secondMethod() {
        System.out.println("Second Method");
    }

    @Test(priority = 3)
    public static void thirdMethod() {
        System.out.println("Third Method");
    }

    @Test(priority = 2)
    public static void fourthMethod() {
        System.out.println("Fourth Method");
    }

    @AfterSuite
    public static void fifthMethod() {
        System.out.println("Fifth Method");
    }
}
