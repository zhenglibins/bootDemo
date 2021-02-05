package com.example.config;

/**
 * Created by lenovo on 2021/1/22.
 */
public class Test {
    public static void main(String[] args) {
        Plate<? extends Fruit> p = new Plate<Apple>(new GreenApple());
        Apple b = new RedApple();
        //p.set(b);
        Plate<Fruit> p2 = new Plate<>(new Apple());
        System.out.println(p2.getClass());
    }
}

class Food{
}
class Fruit extends  Food{}
class Meat extends  Food{}


class Apple extends Fruit{}
class Banana extends Fruit{}
class Pork extends Meat{}
class Beef extends Meat{}


class RedApple extends Apple{}
class GreenApple extends Apple{}

class Plate<T>{
    private T item;
    public Plate(T t){item=t;}
    public void set(T t){item=t;}
    public T get(){return item;}
}
