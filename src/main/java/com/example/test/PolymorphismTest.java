package com.example.test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by lenovo on 2018/7/24.
 */
public class PolymorphismTest {
    public void say(){
        System.out.println("hello");
    }

    public int say(int i){
        System.out.println("hello" + i);
        HashMap map;
        ArrayList al;
        return i;
    }

    public static void main(String args[]){
        new PolymorphismTest().say();
        new PolymorphismTest().say(10);
    }
}
