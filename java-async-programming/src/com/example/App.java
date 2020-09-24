package com.example;

import java.util.Scanner;

/*
 * 
 *  s/w tasks
 *  
 *  	-> computation
 *      -> io
 * 
 */

public class App {

	public static void computation() {
		Thread thread = Thread.currentThread();
		System.out.println(thread + " intiated computation");
		while (true) {
			// ..
		}
		// System.out.println(thread + " completed computation");
	}

	public static void io() {
		// read/write file-system/db/ NW calls
		Thread thread = Thread.currentThread();
		System.out.println(thread + " intiated io");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name?");
		String name = scanner.nextLine();
		System.out.println("Hello " + name);
	}

	public static void main(String[] args) {

		Thread thread = Thread.currentThread();
		System.out.println(thread + " started execution");

		io();
		computation();

	}

}
