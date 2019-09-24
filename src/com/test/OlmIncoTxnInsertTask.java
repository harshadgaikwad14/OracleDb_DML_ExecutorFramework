package com.test;

import java.util.concurrent.Callable;

public class OlmIncoTxnInsertTask implements Callable<String> {

	private long numberOfExeuction;

	public OlmIncoTxnInsertTask(final long numberOfExeuction) {
		super();
		this.numberOfExeuction = numberOfExeuction;
	}

	@Override
	public String call() throws Exception {

		for (int i = 1; i <= numberOfExeuction; i++) {

			Utils.olmIncoTxnTableInsertTask(1, Thread.currentThread().getName());
		}

		return "******* OlmIncoTxnInsertTask Is Done *******";

	}

}
