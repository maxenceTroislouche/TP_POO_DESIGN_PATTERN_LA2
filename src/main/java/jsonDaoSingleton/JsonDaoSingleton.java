package jsonDaoSingleton;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import dao.Dao;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public abstract class JsonDaoSingleton<T> implements Dao<T> {
    protected MongoClient mongoClient;
    protected MongoDatabase database;

    protected JsonDaoSingleton() {
        this.mongoClient = MongoClients.create(new ConnectionString("mongodb://maxence:test@localhost:27017"));
        this.database = mongoClient.getDatabase("test");
    }

    public abstract boolean create(T obj);
    public abstract T find(Class<T> c, int id);
    public abstract List<T> findAll(Class<T> c);
    public abstract boolean update(T obj);
    public abstract boolean delete(T obj);
    public abstract boolean deleteAll(Class<T> c);

    public void close() {
        this.mongoClient.close();
    }
}




