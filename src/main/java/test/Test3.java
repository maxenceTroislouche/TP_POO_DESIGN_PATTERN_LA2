package test;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import jpaDto.E_TypeBien;
import org.bson.Document;

public class Test3 {
    public static void main(String[] args) {
        System.out.println("Test3");

        E_TypeBien type = new E_TypeBien();
        type.setLib("Maison");

        MongoClient mongoClient = MongoClients.create(new ConnectionString("mongodb://maxence:test@localhost:27017"));
        MongoDatabase database = mongoClient.getDatabase("test");

        MongoCollection<Document> collection = database.getCollection("typeBien");
        collection.insertOne(new Document("lib", type.getLib()).append("id", type.getId()));

        collection.find(new Document("id", type.getId())).forEach(System.out::println);
    }
}
