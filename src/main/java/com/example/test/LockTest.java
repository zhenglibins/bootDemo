package com.example.test;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

public class LockTest {
	public static Unsafe unsafe= null;
	static{
		unsafe = getUnsafeInstance();
	}
	public static void main(String args[]) {
		AtomicInteger ai = new AtomicInteger(1);
		ai.getAndIncrement();
		AtomicInteger a2 = new AtomicInteger(1);
		Long l = 0l;
		try {
			l = unsafe.objectFieldOffset(AtomicInteger.class.getDeclaredField("value"));

			System.out.println(l);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}

	}

	public static Unsafe getUnsafeInstance(){
		Field f = null;
		try {
			f = Unsafe.class.getDeclaredField("theUnsafe");
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		f.setAccessible(true);
		Unsafe unsafe = null;
		try {
			unsafe = (Unsafe) f.get(null);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return unsafe;
	}
}
