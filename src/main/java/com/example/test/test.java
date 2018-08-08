package com.example.test;

public class test {

	public static void main(String[] args) {
		String nickName = "你好啊";
		nickName = (nickName != null && nickName.length() > 3) ? "****" + nickName.substring(nickName.length()-3): nickName ;
		System.out.println(nickName);
	}

}
