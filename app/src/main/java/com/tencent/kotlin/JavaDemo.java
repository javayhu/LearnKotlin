package com.tencent.kotlin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class JavaDemo {

    //演示data class
    private int id;
    private String name;

    //region Kotlin-Java Interoperability
    public static void testCallKotlinFromJava() {
        KotlinDemo kotlinDemo = new KotlinDemo(1, "kotlin");
        int id = kotlinDemo.getId();
        String name = kotlinDemo.getName();

        //调用静态方法或属性
        KotlinDemo.Companion.getTAG();
        KotlinDemo.Companion.testStaticFunction();
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

