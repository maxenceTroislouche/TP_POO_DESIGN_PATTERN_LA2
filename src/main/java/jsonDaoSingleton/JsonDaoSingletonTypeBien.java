package jsonDaoSingleton;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import dao.DaoTypeBien;
import jpaDto.E_TypeBien;
import jsonDto.TypeBienDocument;
import metier.TypeBien;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class JsonDaoSingletonTypeBien extends JsonDaoSingleton<E_TypeBien> implements DaoTypeBien {

    private MongoCollection<Document> getCollection() {
        return this.database.getCollection("type_bien");
    }

    @Override
    public TypeBien findLibTypeBien(String lib) {
        MongoCollection<Document> collection = this.getCollection();
        TypeBienDocument typeBienDocument = (TypeBienDocument) collection.find(Filters.eq("lib", lib)).first();

        if (typeBienDocument == null) {
            return null;
        }
        return typeBienDocument.getMetier();
    }

    @Override
    public TypeBien find(int id) {
        MongoCollection<Document> collection = this.getCollection();
        TypeBienDocument typeBienDocument = (TypeBienDocument) collection.find(Filters.eq("id", id)).first();

        if (typeBienDocument == null) {
            return null;
        }
        return typeBienDocument.getMetier();
    }

    @Override
    public boolean create(TypeBien obj) {
        MongoCollection<Document> collection = this.getCollection();
        collection.insertOne(new TypeBienDocument(obj));
        return true;
    }

    @Override
    public TypeBien find(Class<TypeBien> c, int id) {
        return this.find(id);
    }

    @Override
    public List<TypeBien> findAll(Class<TypeBien> c) {
        MongoCollection<Document> collection = this.getCollection();
        List<TypeBien> returnList = new ArrayList<>();
        for (Document document : collection.find()) {
            returnList.add(((TypeBienDocument) document).getMetier());
        }
        return returnList;
    }

    @Override
    public boolean update(TypeBien obj) {
        MongoCollection<Document> collection = this.getCollection();
        collection.replaceOne(Filters.eq("id", obj.getId()), new TypeBienDocument(obj));
        return true;
    }

    @Override
    public boolean delete(TypeBien obj) {
        MongoCollection<Document> collection = this.getCollection();
        collection.deleteOne(Filters.eq("id", obj.getId()));
        return true;
    }

    @Override
    public boolean deleteAll() {
        MongoCollection<Document> collection = this.getCollection();
        collection.deleteMany(new Document());
        return true;
    }

    private JsonDaoSingletonTypeBien() {
        super();
    }

    private static JsonDaoSingletonTypeBien instance;
    public static JsonDaoSingletonTypeBien getInstance() {
        if (instance == null) {
            instance = new JsonDaoSingletonTypeBien();
        }
        return instance;
    }

}

