package com.example.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

	public static void main(String[] args) {
		
		CyclicBarrier ba = new CyclicBarrier(2,new stak2());
		new Thread(new stak(ba)) .start();
		new Thread(new stak(ba)) .start();
		new Thread(new stak(ba)) .start();
	}

}
class stak implements Runnable{
	private CyclicBarrier ba;
	
	public stak(CyclicBarrier ba) {
		super();
		this.ba = ba;
	}

	@Override
	public void run() {
		try {
			
			Thread.sleep(1000);
			System.out.println("renwu�߳�");
			ba.await();
			System.out.println("ִ��դ���̺߳����ж�");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

class stak2 implements Runnable{
	

	@Override
	public void run() {
		System.out.println("�ص��߳�");
		
	}
	
}