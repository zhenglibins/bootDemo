package com.example.test;

public class test {

	public static void main(String[] args) {
		try {
			String s = null;
			s.toString();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
