package jsonDaoSingleton;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public abstract class JsonDaoSingleton<T> {
    protected MongoClient mongoClient;
    protected MongoDatabase database;

    protected JsonDaoSingleton() {
        this.mongoClient = MongoClients.create(new ConnectionString("mongodb://maxence:test@localhost:27017"));
        this.database = mongoClient.getDatabase("test");
    }

    public void close() {
        this.mongoClient.close();
    }
}
