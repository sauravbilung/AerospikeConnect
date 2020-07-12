# AerospikeConnect(Synchronous and Asynchronous ways)
Learning project on Aerospike NoSQL database explaining how to read and write records Synchronously and Asynchronously.

Prerequisites :
1) A Java IDE
2) Maven (any latest version)
3) jdk 1.8 
4) Aerospike server

For installing Aerospike refer [here.](https://www.aerospike.com/docs/operations/install/)
For quickly testing out the project by running Aerospike server in a docker container follow the below steps: 

<b> Steps for running Aerospike instance running in a docker container :</b>
1) Run the command : ```docker run -d --name aerospike -p 3000:3000 -p 3001:3001 -p 3002:3002 -p 3003:3003 aerospike```
2) To start the AQL(Aerospike Query Langague) tool, run the command :
```docker run -it aerospike/aerospike-tools aql -h  $(docker inspect -f '{{.NetworkSettings.IPAddress }}' aerospike)```
3) For restarting the Aerospike server in docker container after you exit it : ```docker start aerospike``` and then step 2.

<b> Steps for running the project </b>
1) Import the project in the IDE of choice.
2) ```com.Test.Aerospike``` package has the driver classes. ```App.java``` and ```AppAsnyc.java``` classes in this package executes the project Synchronously and Asynchronously.Also, ```AppCreateSecondaryIndex``` class in the same package is used for creating secondary index.
3) ```com.Test.Aerospike.Service``` package has the logic which executes the processes in both ways.
4) Driver classes have the methods commented out. Uncomment what you need and comment what you don't.
4) Run the project.


