package com.fssa.freshstocks;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {

	public static void main(String[] args) {
        // welcome message
        System.out.println("Welcome to freshstocks Trading Website!");

        // current time
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(new Date());
        System.out.println("Current Time: " + currentTime);
	}
}