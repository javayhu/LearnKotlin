package com.tencent.kotlin.java;

public class StringUtilJava {

    public static String getFirstWord(String str) {
        int index = str.indexOf(" ");
        if (index < 0) {
            return str;
        } else {
            return str.substring(0, index);
        }
    }

}
