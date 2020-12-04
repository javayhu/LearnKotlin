package com.tencent.kotlin.java;

public class JavaNulls {

    public void validateCustomerJava(CustomerJava customer) throws Exception {
        if (null != customer) {
            if (null != customer.getName()) {
                if (customer.getName().startsWith("A")) {
                    throw new Exception("Names are not allowed to start with A");
                }
            }
        }
    }

}
