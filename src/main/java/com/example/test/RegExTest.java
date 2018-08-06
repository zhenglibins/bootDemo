package com.example.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTest {
	public static void main(String args[]) {
		testOne();
	}
	
	public static void testOne() {
		String regex = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$";
		String str =  "linfen@xsoft.net";
		Pattern pattern = Pattern.compile(regex);
	    // ���Դ�Сд��д��
	    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(str);
	    // �����ַ������Ƿ���ƥ��������ʽ���ַ�/�ַ���
	    boolean rs = matcher.find();
	    System.out.println(rs);
	} 
}
