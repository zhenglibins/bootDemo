package com.example.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Callable;

public class test {

	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime ldt = LocalDateTime.of(2018,8,14,23,59,59);
		LocalDateTime templdt = ldt.truncatedTo(ChronoUnit.DAYS);
		System.out.println(ldt);
		System.out.println(templdt);
		System.out.println(templdt.isAfter(LocalDateTime.now()));

	}

}
