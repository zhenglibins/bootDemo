package com.example.test;

public class testFinal {
    public static void main(String[] args) {
        Fruit f = new Apple();
        f.shengzhang("硝酸铵");
    }
}

class Fruit{
    public String name;
    public  final void shengzhang(){
        System.out.println(this.getClass().getName()+"生长");
    }

    public  final void shengzhang(final String  feiliao){
        System.out.println("加肥料" + feiliao + this.getClass().getName()+"生长");
    }

}
class Apple extends Fruit{
//    public void shengzhang(){
//        System.out.println(this.getClass().getName()+"生长");
//    }
}