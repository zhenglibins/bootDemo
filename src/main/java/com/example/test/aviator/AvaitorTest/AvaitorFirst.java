package com.example.test.aviator.AvaitorTest;

import com.googlecode.aviator.AviatorEvaluator;

public class AvaitorFirst {
    public static void main(String[] args) {
        Long result = (Long) AviatorEvaluator.execute("1+2+3+4+5+6");

        System.out.println(result);
    }
}
