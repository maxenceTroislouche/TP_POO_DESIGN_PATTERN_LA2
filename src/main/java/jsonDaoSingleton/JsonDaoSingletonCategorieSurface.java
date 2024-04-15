package jsonDaoSingleton;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import dao.DaoCategorieSurface;
import jpaDto.E_CategorieBien;
import jsonDto.CategorieBienDocument;
import metier.CategorieBien;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class JsonDaoSingletonCategorieSurface extends JsonDaoSingleton<E_CategorieBien> implements DaoCategorieSurface {

    private MongoCollection<Document> getCollection() {
        return this.database.getCollection("categorie_bien");
    }

    @Override
    public CategorieBien findLibCategorieSurface(String lib) {
        MongoCollection<Document> collection = this.getCollection();

        CategorieBienDocument categorieBienDocument = (CategorieBienDocument) collection.find(Filters.eq("lib", lib)).first();
        if (categorieBienDocument == null) {
            return null;
        }
        return categorieBienDocument.getMetier();
    }

    @Override
    public CategorieBien find(int id) {
        MongoCollection<Document> collection = this.getCollection();
        CategorieBienDocument categorieBienDocument = (CategorieBienDocument) collection.find(Filters.eq("id", id)).first();
        if (categorieBienDocument == null) {
            return null;
        }
        return categorieBienDocument.getMetier();
    }

    @Override
    public boolean create(CategorieBien obj) {
        MongoCollection<Document> collection = this.getCollection();
        collection.insertOne(new CategorieBienDocument(obj));
        return true;
    }

    @Override
    public CategorieBien find(Class<CategorieBien> c, int id) {
        return this.find(id);
    }

    @Override
    public List<CategorieBien> findAll(Class<CategorieBien> c) {
        MongoCollection<Document> collection = this.getCollection();
        List<CategorieBien> returnList = new ArrayList<>();
        for (Document document : collection.find()) {
            returnList.add(((CategorieBienDocument) document).getMetier());
        }
        return returnList;
    }

    @Override
    public boolean update(CategorieBien obj) {
        MongoCollection<Document> collection = this.getCollection();
        collection.replaceOne(Filters.eq("id", obj.getId()), new CategorieBienDocument(obj));
        return true;
    }

    @Override
    public boolean delete(CategorieBien obj) {
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


    private JsonDaoSingletonCategorieSurface() {
        super();
    }

    private static JsonDaoSingletonCategorieSurface instance;
    public static JsonDaoSingletonCategorieSurface getInstance() {
        if (instance == null) {
            instance = new JsonDaoSingletonCategorieSurface();
        }
        return instance;
    }
}
