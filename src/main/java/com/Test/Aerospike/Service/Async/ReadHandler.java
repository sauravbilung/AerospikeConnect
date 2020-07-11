package com.Test.Aerospike.Service.Async;

import com.aerospike.client.AerospikeException;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import com.aerospike.client.listener.RecordListener;

public class ReadHandler implements RecordListener{

	@Override
	public void onSuccess(Key key, Record record) {
		System.out.println("Read successfull !!!");		
	}

	@Override
	public void onFailure(AerospikeException exception) {
		System.out.println("Read failure !!!");
		exception.printStackTrace();		
	}

}
