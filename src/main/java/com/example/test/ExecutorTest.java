package com.example.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorTest {

	public static void main(String[] args) {
		
		submitTest();
	}
	
	public static void executeTest() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();  
		 
		executorService.execute(new Runnable() {  
		    public void run() {  
		        System.out.println("Asynchronous task");  
		    }  
		});  
		 
		executorService.shutdown();
	}
	public static void submitTest() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();  

			Future f = executorService.submit(new Runnable() {
				public void run() {
					System.out.println("Asynchronous task");
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		try {
			System.out.println(f.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executorService.shutdown();
	}

}
