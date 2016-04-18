package com.sample.mongodb;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class UpdateRecordExample {

	public static void main(String args[]) {

		try {

			// To connect to mongodb server
			MongoClient mongoClient = new MongoClient("localhost", 27017);

			// Now connect to your databases
			DB db = mongoClient.getDB("test");
			System.out.println("Connect to database successfully");

			DBCollection coll = db.getCollection("mycol");
			ObjectId objId = new ObjectId("57123329b01c7da49d3f87b7");
			DBObject dbObject = coll.findOne(new BasicDBObject().append("_id", objId));
			System.out.println("dbObject :"+dbObject );
			System.out.println("Collection mycol selected successfully");

			BasicDBObject newDocument = new BasicDBObject().append("$set",
					new BasicDBObject().append("likes", "8000"));

			coll.update(dbObject,
					newDocument);

		DBCursor cursor = coll.find();

		/*	while (cursor.hasNext()) {
				DBObject updateDocument = cursor.next();
				System.out.println("updateDocument :" + updateDocument);
				updateDocument.put("likes", "200");
				coll.update(updateDocument, updateDocument);
			}

			System.out.println("Document updated successfully");*/
			cursor = coll.find();

			int i = 1;

			while (cursor.hasNext()) {
				System.out.println("Updated Document: " + i);
				System.out.println(cursor.next());
				i++;
			}

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

}
