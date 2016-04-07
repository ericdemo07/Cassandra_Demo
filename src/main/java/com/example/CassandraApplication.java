package com.example;



import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.policies.DCAwareRoundRobinPolicy;
import com.datastax.driver.core.policies.DefaultRetryPolicy;
import com.datastax.driver.core.policies.TokenAwarePolicy;

public class CassandraApplication 
{
	public static void main(String[] args) 
	{
		Cluster cluster;
		Session session;
		
		// Connect to the cluster and keyspace "demo"
		cluster = Cluster
				.builder()
				.addContactPoint("127.0.0.1")
				.withRetryPolicy(DefaultRetryPolicy.INSTANCE)
				.build();	
		session = cluster.connect("a");
		System.out.println("Cluster Name :"+cluster.getClusterName()+"   "+cluster.isClosed());
		//session = cluster.newSession();
		System.out.println("Session :"+session.getState()+"   "+session.isClosed());
		
		String cqlStatementC = "INSERT INTO exampkeyspace.users (username, password) " + 
                "VALUES ('Serenity', 'fa3dfQefx')";
		// Insert one record into the users table
		session.execute(cqlStatementC); // interchangeable, put any of the statements u wish.
	}
}
