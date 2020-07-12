package com.Test.Aerospike.Service;

import java.util.Optional;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import com.aerospike.client.policy.BatchPolicy;
import com.aerospike.client.policy.QueryPolicy;
import com.aerospike.client.policy.WritePolicy;
import com.aerospike.client.query.RecordSet;
import com.aerospike.client.query.Statement;

public class AerospikeService {

	public void writeRecord(AerospikeClient client, WritePolicy policy, Key key, Bin[] bins) {

		// # NameSpace : Schema/Database/Top-Level-container
		// # Set: table
		// # Records: a Row or an entry
		// # bin : column

		client.put(policy, key, bins);
		// # or like this: client.put(policy, key, "binName1","binName2",...);
	}

	public void deleteBins(AerospikeClient client, WritePolicy policy, Key key, Bin[] bins) {

		// # below will remove bins/columns as per the key
		client.put(policy, key, bins);
	}

	public void deleteRecord(AerospikeClient client, WritePolicy policy, Key key) {
		client.delete(policy, key);
	}

	public void displayRecord(AerospikeClient client, WritePolicy policy, Key key) {

		Record record = client.get(policy, key);
		System.out.println("ID : " + record.getInt("id") + ", first_name : " + record.getString("first_name")
				+ ", last_name : " + record.getString("last_name"));

	}

	public void displayRecordWithSpecificBins(AerospikeClient client, WritePolicy policy, Key key, String[] binNames) {

		Record record = client.get(policy, key, binNames);
		int totalBins = binNames.length;

		for (int i = 0; i < totalBins; i++) {
			// # note record.getString("bin_name") will return only string
			// # for other data type it will throw error. Hence record.getValue() is used
			System.out.println(binNames[i] + " : " + record.getValue(binNames[i]));
		}
	}

	public void batchDisplayRecords(AerospikeClient client, BatchPolicy policy, Key[] keys) {
		// # batch processing of records
		Record[] records = client.get(policy, keys);

		for (Record record : records) {
			System.out.println(record.getLong("id") + "\t" + record.getString("first_name") + "\t"
					+ record.getString("last_name"));
		}
	}

	public void queryRecords(AerospikeClient client, QueryPolicy policy, Statement statement) {
		// This to query the records using secondary indexes.

		boolean b = false;// boolean just to check if any record is fetched or not.
		RecordSet rs = client.query(policy, statement);
		try {
			while (rs.next()) {
				b = true;
				Key key = rs.getKey();
				Record record = rs.getRecord();
				System.out.println(record.getLong("id") + "\t" + record.getString("first_name") + "\t"
						+ record.getString("last_name"));
			}

			if (!b) {
				System.out.println("Not Found !!!");
			}
		} finally {
			rs.close();
		}
	}

}
