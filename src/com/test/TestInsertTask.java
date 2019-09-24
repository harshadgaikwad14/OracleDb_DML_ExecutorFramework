package com.test;

import java.util.concurrent.Callable;

public class TestInsertTask implements Callable<String> {

	private long numberOfExeuction;

	public TestInsertTask(final long numberOfExeuction) {
		super();
		this.numberOfExeuction = numberOfExeuction;
	}

	@Override
	public String call() throws Exception {

		for (int i = 1; i <= numberOfExeuction; i++) {

			Utils.testTableInsertTask(i,Thread.currentThread().getName());
		}

		return "******* TestInsertTask Is Done *******";

	}

}
