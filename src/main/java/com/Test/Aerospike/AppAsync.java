package com.Test.Aerospike;

import com.Test.Aerospike.Service.Async.AsynAerospikeService;
import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.async.EventLoops;
import com.aerospike.client.async.EventPolicy;
import com.aerospike.client.async.NioEventLoops;
import com.aerospike.client.policy.ClientPolicy;
import com.aerospike.client.policy.WritePolicy;

public class AppAsync {

	public static void main(String args[]) {
		// ######### Event loops for processing async commands ################

		// Event Policy, policy for handling events.
		EventPolicy eventPolicy = new EventPolicy();

		// # Direct NIO event loops
		// # Creating 4 Aerospike NIO direct event loops
		// # It is lightweight and slightly faster than Netty Event loops
		// # when not sharing event loops.
		EventLoops eventLoops = new NioEventLoops(eventPolicy, 4);

		// # Netty Event loops is other option.
		// # Netty allows their users to share their existing eventloops with
		// # the existing AerospikeClient to improve the performance.

		// ############# Asynchronous Connect ########################
		ClientPolicy clientPolicy = new ClientPolicy();
		clientPolicy.eventLoops = eventLoops;

		// # Host[] hosts=new Host[] {new Host("host1", 3000), new Host("host2", 3000)};
		// # AerospikeClient is thread safe and can be used concurrently.
		AerospikeClient client = new AerospikeClient(clientPolicy, "172.17.0.2", 3000);

		// ############ Initializing AsyncAerospike Service ##########
		AsynAerospikeService service = new AsynAerospikeService(client, eventLoops);

		// ############ Write a record ###############################
		/*
		 * WritePolicy policy = new WritePolicy(); policy.setTimeout(50); Key
		 * writeKey=new Key("test", "myset", "key3"); Bin[] bins= {new Bin("id", 3),new
		 * Bin("first_name", "Natasha"),new Bin("last_name", "Romanoff")};
		 * service.writeRecords(policy, writeKey, bins);
		 */

		// ########### Reading a record ############################
		Policy policy2 = new WritePolicy();
		policy2.setTimeout(50);
		

		// ########## Closing the connection and the resources #########
		client.close();
		eventLoops.close();
	}

}
