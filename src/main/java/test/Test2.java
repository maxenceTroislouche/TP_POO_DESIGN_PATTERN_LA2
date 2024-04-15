package test;

import dao.DaoAdresse;
import dao.DaoBien;
import dao.DaoFactory;
import dao.PersistenceType;
import metier.Adresse;
import metier.Bien;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        DaoAdresse daoAdresseJPA = DaoFactory.getDaoFactory(PersistenceType.JPA).getDaoAdresse();
        DaoBien daoBienJPA = DaoFactory.getDaoFactory(PersistenceType.JPA).getDaoBien();

        DaoAdresse daoAdresseJSON = DaoFactory.getDaoFactory(PersistenceType.JSON).getDaoAdresse();
        DaoBien daoBienJSON = DaoFactory.getDaoFactory(PersistenceType.JSON).getDaoBien();

        System.out.println("Suppression des données JSON");
        daoAdresseJSON.deleteAll();
        daoBienJSON.deleteAll();

        // Récupérer l'adresse avec l'id 5
        System.out.println("Adresse avec l'id 5");
        Adresse adresse = daoAdresseJPA.find(5);
        daoAdresseJSON.create(adresse);

        System.out.println(adresse);
        System.out.println("Ajout des biens!");
        List<Bien> biens = daoBienJPA.findByAdresse(adresse);
        System.out.println(biens);
        for (Bien bien : biens) {
            daoBienJSON.create(bien);
        }
    }
}
