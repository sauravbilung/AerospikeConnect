package com.Test.Aerospike.Service.Async;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.async.EventLoop;
import com.aerospike.client.async.EventLoops;
import com.aerospike.client.policy.Policy;
import com.aerospike.client.policy.WritePolicy;

// # AerospikeClient provides asynchronous methods that take in 
// # an event loop and a listener callback as extra arguments. 
// # Asynchronous methods register the command with an event loop 
// # and return. The event loop thread will process
// # the command and send the results to the listener.

public class AsynAerospikeService {

	AerospikeClient client;
	WriteHandler listener=new WriteHandler();
	ReadHandler listener2=new ReadHandler();
	EventLoops eventLoops;
	EventLoop eventLoop;

	public AsynAerospikeService(AerospikeClient client,EventLoops loops) {
		super();
		this.client = client;
		eventLoops=loops;
		eventLoop=eventLoops.next();
	}

	public void writeRecord(WritePolicy policy, Key key, Bin[] bins) {
		client.put(eventLoop, listener, policy, key, bins);
	}

	public void readRecord(Policy policy,Key key) {
		client.get(eventLoop, listener2, policy, key);		
	}
}
