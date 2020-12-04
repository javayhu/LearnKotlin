package com.tencent.kotlin.java;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.tencent.kotlin.kotlin.KotlinDemo;

public class JavaDemo {

    //演示data class
    private int id;
    private String name;

    //region Kotlin-Java Interoperability
    public static void testCallKotlinFromJava() {
        //1、创建KotlinDemo对象，如果没有用@JvmOverloads标识那么创建对象需要传入所有的构造方法参数
        KotlinDemo kotlinDemo1 = new KotlinDemo(1);
        KotlinDemo kotlinDemo2 = new KotlinDemo(2, "java");

        //2、调用静态方法，没有用@JvmStatic修饰方法的话就只能通过伴生对象Companion来调用
        KotlinDemo.testStaticFunction();
        KotlinDemo.Companion.testNonStaticFunction();

        //3、调用类的属性方法getter/setter，没有用@JvmField修饰id属性的话就需要调用getId和setId方法
        KotlinDemo kotlinDemo = new KotlinDemo(3, "php");
        //int id = kotlinDemo.getId();
        //kotlinDemo.setId(4);
        int id = kotlinDemo.id;
        kotlinDemo.id = 4;
    }

    public void testParamNullableFunction(@Nullable String newName) {
        //do nothing
    }

    public void testParamNotNullFunction(@NonNull String newName) {
        //do nothing
    }

    public static void testStaticFunction() {
        //do nothing
    }
    //endregion

    public JavaDemo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

