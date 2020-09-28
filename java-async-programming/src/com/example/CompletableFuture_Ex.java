package com.example;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CompletableFuture_Ex {

	public static String getEmployee(int id) {
		System.out.println(Thread.currentThread()+" => "+id);
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "EMP-" + id;
	}

	public static void main(String[] args) throws Exception {


		List<Integer> employeeIds = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		for (Integer employeeId : employeeIds) {
			
			CompletableFuture
			.supplyAsync(()->getEmployee(employeeId))
			.thenApplyAsync(emp->"TAX-RATE + "+emp)
			.thenApplyAsync(emp_tax_rate->"TAX + "+emp_tax_rate)
			.thenAcceptAsync(message->System.out.println("Email + "+message));

		}
		
		
		TimeUnit.SECONDS.sleep(50);

	}

}
