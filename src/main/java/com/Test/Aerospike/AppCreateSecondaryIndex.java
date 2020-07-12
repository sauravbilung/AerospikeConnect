package com.Test.Aerospike;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.query.IndexType;
import com.aerospike.client.task.IndexTask;

public class AppCreateSecondaryIndex {

	public static void main(String[] args) {

		// Creating secondary index
		AerospikeClient client = new AerospikeClient(null, "172.17.0.2", 3000);
		IndexTask task = client.createIndex(null, "test", "myset", "mysetIndex", "first_name", IndexType.STRING);
		task.waitTillComplete();
		System.out.println(
				"Since the data is very small. The index creation will happen within 1 second which is also the default time for the task to get completed.The index creation should happen before one second. If this line is displayed with no exception thrown then the index creation is complete.");
		
		// # To drop index
		// client.dropIndex(null, "test", "myset", "mysetIndex");
		
		client.close();
		
	}

}
