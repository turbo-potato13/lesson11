package com.vtb.kortunov.lesson11;

import com.vtb.kortunov.lesson11.annotation.AfterSuite;
import com.vtb.kortunov.lesson11.annotation.BeforeSuite;
import com.vtb.kortunov.lesson11.annotation.Test;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

public class StartClass {

    public static void start(Class<?> testClass) throws Exception {
        Method[] methods = testClass.getMethods();
        int i = 0;
        Map<Integer, Method> testMethods = new TreeMap<>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                method.invoke(null);
                i++;
                if (i > 1) {
                    throw new RuntimeException();
                }
            }
        }
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                testMethods.put(method.getAnnotation(Test.class).priority(), method);
            }
        }
        for (Integer key : testMethods.keySet()) {
            testMethods.get(key).invoke(null);
        }
        i = 0;
        for (Method method : methods) {
            if (method.isAnnotationPresent(AfterSuite.class)) {
                method.invoke(null);
                i++;
                if (i > 1) {
                    throw new RuntimeException();
                }
            }
        }
    }
}
