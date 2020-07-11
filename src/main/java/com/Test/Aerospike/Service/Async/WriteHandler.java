package com.Test.Aerospike.Service.Async;

import com.aerospike.client.AerospikeException;
import com.aerospike.client.Key;
import com.aerospike.client.listener.WriteListener;

public class WriteHandler implements WriteListener {

	// # Completion handler
	// # This class handles tasks to execute on completion.
	// # Either success or failure task.
	@Override
	public void onSuccess(Key key) {
		System.out.println("Written Successfully !!!");
	}

	@Override
	public void onFailure(AerospikeException exception) {
		System.out.println("Write operation failed !!!");
		exception.printStackTrace();
	}

}
