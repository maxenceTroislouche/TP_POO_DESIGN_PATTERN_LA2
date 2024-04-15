package jsonDaoSingleton;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import dao.DaoBien;
import jpaDto.E_Bien;
import jsonDto.BienDocument;
import metier.Adresse;
import metier.Bien;
import org.bson.Document;
import org.bson.conversions.Bson;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

public class JsonDaoSingletonBien extends JsonDaoSingleton<E_Bien> implements DaoBien {

    private MongoCollection<Document> getCollection() {
        return this.database.getCollection("bien");
    }

    @Override
    public Bien find(int id) {
        MongoCollection<Document> collection = this.getCollection();

        BienDocument documentBien = (BienDocument) collection.find(Filters.eq("id", id)).first();
        if (documentBien == null) {
            return null;
        }
        return documentBien.getMetier();    }

    @Override
    public List<Bien> findByAdresse(Adresse adresse) {
        MongoCollection<Document> collection = this.getCollection();
        Bson filter = Filters.eq("adresse.id", adresse.getId());
        FindIterable<Document> documentsBien = collection.find(filter);

        List<Bien> returnList = new ArrayList<>();
        for (Document documentBien : documentsBien) {
            returnList.add((new BienDocument(documentBien)).getMetier());
        }

        return returnList;
    }

    @Override
    public boolean create(Bien obj) {
        MongoCollection<Document> collection = this.getCollection();
        collection.insertOne(new BienDocument(obj));
        return true;
    }

    @Override
    public Bien find(Class<Bien> c, int id) {
        return this.find(id);
    }

    @Override
    public List<Bien> findAll(Class<Bien> c) {
        MongoCollection<Document> collection = this.getCollection();

        FindIterable<Document> documentsBiens = collection.find();

        List<Bien> returnList = new ArrayList<>();
        for (Document documentBien : documentsBiens) {
            returnList.add(((BienDocument) documentBien).getMetier());
        }

        return returnList;
    }

    @Override
    public boolean update(Bien obj) {
        MongoCollection<Document> collection = this.getCollection();
        collection.replaceOne(Filters.eq("id", obj.getId()), new BienDocument(obj));
        return true;
    }

    @Override
    public boolean delete(Bien obj) {
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

    private JsonDaoSingletonBien() {
        super();
    }

    private static JsonDaoSingletonBien instance;
    public static JsonDaoSingletonBien getInstance() {
        if (instance == null) {
            instance = new JsonDaoSingletonBien();
        }
        return instance;
    }
}
