package com.tencent.kotlin.java;

public class SingletonJava {

    private SingletonJava() {
        System.out.println("SingletonJava object init");
    }

    private static class SingletonHolder {
        static SingletonJava INSTANCE = new SingletonJava();
    }

    public static SingletonJava getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private String property;

    public void init() {
        System.out.println("SingletonJava call init");
    }

}

class TestSingletonJava {

    public void testSingletonJava() {
        SingletonJava.getInstance().init();
        SingletonJava.getInstance().init();
    }

}
