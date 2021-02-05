package com.example.test;

import java.lang.ref.SoftReference;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.*;

//class resource{
//	public static int i = 0;
//}

public class test {

	public static void main(String[] args) {

	}

	static final int tableSizeFor(int cap) {
		int n = cap - 1;

		List<Integer> list = new ArrayList<>();
		list.add(n);
		n |= n >>> 1;
		list.add(n);
		n |= n >>> 2;
		list.add(n);
		n |= n >>> 4;
		list.add(n);
		n |= n >>> 8;
		list.add(n);
		n |= n >>> 16;
		list.add(n);
		System.out.println(list);
		return (n < 0) ? 1 :  n + 1;
	}
	public static void testSoftRefre(){
		System.out.println("开始");
		String a = "111";
		SoftReference<String> sr =  new SoftReference<String>(a );
		a = null;
		if(sr != null){
			a = sr.get();
		}else{
			a = new String("111");
			sr = new SoftReference<String>(a);
		}
		System.out.println("结束");
	}
	public static void testss(){
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Callable<String> callable = new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("执行");
				return "123";
			}
		};
		Future<String> f = executorService.submit(callable);
		executorService.submit(callable);
		try {
			System.out.println(f.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		executorService.shutdown();
	}
}
