package jsonDaoSingleton;

import com.mongodb.client.MongoCollection;
import dao.DaoAdresse;
import jpaDto.E_Adresse;
import jsonDto.AdresseDocument;
import metier.Adresse;
import metier.Bien;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class JsonDaoSingletonAdresse extends JsonDaoSingleton<E_Adresse> implements DaoAdresse {

    private MongoCollection<Document> getCollection() {
        return this.database.getCollection("adresse");
    }

    private JsonDaoSingletonAdresse() {
        super();
    }

    private static JsonDaoSingletonAdresse instance;
    public static JsonDaoSingletonAdresse getInstance() {
        if (instance == null) {
            instance = new JsonDaoSingletonAdresse();
        }
        return instance;
    }

    @Override
    public int nombreBiens(Adresse adresse) {
        return JsonDaoSingletonBien.getInstance().findByAdresse(adresse).size();
    }

    @Override
    public List<Bien> biensACetteAdresse(Adresse adresse) {
        return JsonDaoSingletonBien.getInstance().findByAdresse(adresse);
    }

    @Override
    public Adresse find(int id) {
        MongoCollection<Document> collection = this.getCollection();
        Document filter = new Document("id", id);

        AdresseDocument documentAdresse = new AdresseDocument(collection.find(filter).first());
        if (documentAdresse == null) {
            return null;
        }
        return documentAdresse.getMetier();
    }

    @Override
    public boolean create(Adresse obj) {
        MongoCollection<Document> collection = this.getCollection();

        AdresseDocument documentAdresse = new AdresseDocument(obj);
        collection.insertOne(documentAdresse);
        return true;
    }

    @Override
    public Adresse find(Class<Adresse> c, int id) {
        return this.find(id);
    }

    @Override
    public List<Adresse> findAll(Class<Adresse> c) {
        MongoCollection<Document> collection = this.getCollection();

        List<Adresse> listOfAdresses = new ArrayList<>();

        collection.find().forEach((Document document) -> {
            AdresseDocument adresseDocument = (AdresseDocument) document;
            Adresse adresse = adresseDocument.getMetier();
            listOfAdresses.add(adresse);
        });

        return listOfAdresses;
    }

    @Override
    public boolean update(Adresse obj) {
        MongoCollection<Document> collection = this.getCollection();
        AdresseDocument documentAdresse = new AdresseDocument(obj);
        collection.replaceOne(new Document("id", obj.getId()), documentAdresse);
        return true;
    }

    @Override
    public boolean delete(Adresse obj) {
        MongoCollection<Document> collection = this.getCollection();
        collection.deleteOne(new Document("id", obj.getId()));
        return true;
    }

    @Override
    public boolean deleteAll() {
        MongoCollection<Document> collection = this.getCollection();
        collection.deleteMany(new Document());
        return true;
    }

}
