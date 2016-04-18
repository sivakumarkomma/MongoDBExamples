package com.sample.mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class InsertRecordsExample {
	
	public static void main( String args[] ) {
		
	      try{   
			
	         // To connect to mongodb server
	         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
				
	         // Now connect to your databases
	         DB db = mongoClient.getDB( "test" );
	         System.out.println("Connect to database successfully");
				
	              
	         DBCollection coll = db.getCollection("mycol");
	         System.out.println("Collection mycol selected successfully");
				
	         BasicDBObject doc = new BasicDBObject("title", "MongoDB").
	            append("description", "database").
	            append("likes", 100).
	            append("url", "http://www.tutorialspoint.com/mongodb/").
	            append("by", "tutorials point");
					
	         coll.insert(doc);
	         System.out.println("Document inserted successfully");
	      }catch(Exception e){
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      }
	   }

}
