package com.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {

		final ExecutorService executorService = Executors.newFixedThreadPool(4);

		Utils.olmIncoTxnTableDeleteAllTask();
		Utils.testTableDeleteAllTask();

		testInsertTask(executorService,10);
		olmIncoTxnInsertTask(executorService,10);

	}

	public static void testInsertTask(final ExecutorService executorService,final long recordCount) {

		final long start = System.currentTimeMillis();

		final TestInsertTask testInsertTask = new TestInsertTask(recordCount);

		final Future<String> testInsertTaskResult = (Future<String>) executorService.submit(testInsertTask);

		try {

			System.out.println(testInsertTaskResult.get());
		} catch (InterruptedException | ExecutionException e) {
			System.out.println("Error occured while executing the submitted task");
			e.printStackTrace();
		}

		executorService.shutdown();
		System.out.println("Records are inserted in Test table");
		System.out.println("Time Taken : " + (System.currentTimeMillis() - start));
	}

	public static void olmIncoTxnInsertTask(final ExecutorService executorService,final long recordCount) {

		final long start = System.currentTimeMillis();
		final OlmIncoTxnInsertTask olmIncoTxnInsertTask = new OlmIncoTxnInsertTask(recordCount);

		final Future<String> olmIncoTxnInsertTaskResult = (Future<String>) executorService.submit(olmIncoTxnInsertTask);

		try {
			System.out.println(olmIncoTxnInsertTaskResult.get());

		} catch (InterruptedException | ExecutionException e) {
			System.out.println("Error occured while executing the submitted task");
			e.printStackTrace();
		}

		executorService.shutdown();
		System.out.println("Records are inserted in OLM INCO TXN table");
		System.out.println("Time Taken : " + (System.currentTimeMillis() - start));
	}

}
