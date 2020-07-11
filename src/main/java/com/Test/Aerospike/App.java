package com.Test.Aerospike;

import com.Test.Aerospike.Service.AerospikeService;
import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.policy.BatchPolicy;
import com.aerospike.client.policy.WritePolicy;
import com.aerospike.client.query.Filter;
import com.aerospike.client.query.Statement;

public class App {
	public static void main(String[] args) {

		// # The client first connects to a seed node, and then discovers the rest of
		// # the cluster.
		AerospikeClient client = new AerospikeClient("172.17.0.2", 3000);

		// # Initializing policy
		// # This policy specifies the re-transmission policy, timeout interval, record
		// # expiration, and what to do if the record already exists.
		WritePolicy policy = new WritePolicy();
		policy.setTimeout(50); // in milliseconds

		// # Initializing the Aerospike service class for running
		// # operations to aerospike
		AerospikeService service = new AerospikeService();

		// ############## writing a record ############################
		// # Key parameters (namespace,setName/tableName,keyValue/Identifier)
		// # Specifies which record in a table to point

		// Bin bin1 = new Bin("first_name", "Tony");
		// Bin bin2 = new Bin("last_name", "Stark");
		// Bin bin3 = new Bin("id", 3);
		// Bin[] bins = { bin1, bin2, bin3 };
		// Key writeKey = new Key("test", "myset", "key3");
		// service.writeRecord(client, policy, writeKey, bins);

		// ################# Deleting bin(s) of a record ###############
		// # below will remove bins/columns as per the key

		// Bin deleteBin1 = Bin.asNull("first_name");
		// Bin deleteBin2 = Bin.asNull("last_name");
		// Bin deleteBin3 = Bin.asNull("id");
		// Bin[] deleteBins= {deleteBin3};
		// service.deleteBins(client, policy, key, deleteBins);

		// ################ Deleting a record ##########################
		// service.deleteRecord(client, policy, key);

		// ################## Reading Records ##########################
		// # Reads all bins/columns
		// service.displayRecord(client, policy, key);

		// # Read specific bins of a record
		// String[] binsToDisplay= {"id","last_name"};
		// service.displayRecordWithSpecificBins(client, policy, key, binsToDisplay);

		// # Batch Reads
		// BatchPolicy with default configurations

		/*
		 * BatchPolicy batchPolicy = new BatchPolicy(); Key[] keys = new Key[3];
		 * 
		 * for (int i = 0; i < 3; i++) { keys[i] = new Key("test", "myset", "key" + (i +
		 * 1)); } service.batchDisplayRecords(client, batchPolicy, keys);
		 */

		// # Note : We can also perform multiple operations in a single transactions as
		// well
		// # Refer the docs.

		// ################## Querying Records ##################################
		// This is to query the database using secondary index.
		
		/*
		 * Statement stmt=new Statement(); stmt.setNamespace("test");
		 * stmt.setSetName("myset"); stmt.setBinNames("id","first_name","last_name");
		 * stmt.setFilter(Filter.equal("first_name", "Tony"));
		 * service.queryRecords(client, null, stmt);
		 */
		   
		   
		// ################## Closing the connection ############################
		client.close();

		System.out.println("Done !!!");
	}
}
