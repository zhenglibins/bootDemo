package com.example.test;

import java.util.concurrent.atomic.AtomicInteger;

public class volatileTest {

	public static void main(String[] args) throws InterruptedException {
		resource re = new resource();
		new Thread(new testRun(re,"线程1")).start();
		new Thread(new testRun(re,"线程2")).start();
		AtomicInteger ai = new AtomicInteger(1);
		re.setBool(true);
	}

}
class testRun implements Runnable{
	resource re;
	String name;
	public testRun(resource re,String name) {
		this.re = re;
		this.name = name;
	}

	public void run() {
		int time = 10;
		int count = 1;
		while(time>0){
			System.out.println("第"+count+"次"+name + "" + re.getBool());
			try {
				Thread.sleep(1000);
				time--;
				count++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class resource{
	public Boolean getBool() {
		return bool;
	}

	public void setBool(Boolean bool) {
		this.bool = bool;
	}

	private volatile  Boolean bool = false;

}
