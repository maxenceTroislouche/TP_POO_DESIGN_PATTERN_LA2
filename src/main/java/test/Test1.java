package test;


import dao.*;
import jakarta.transaction.Transactional;
import metier.Adresse;

public class Test1 {
    @Transactional
    public static Adresse getAdresse(int id, PersistenceType type) {
        return DaoFactory.getDaoFactory(type).getDaoAdresse().find(id);
    }

    @Transactional
    public static int getNombreBiens(Adresse adresse, PersistenceType type) {
        return DaoFactory.getDaoFactory(type).getDaoAdresse().nombreBiens(adresse);
    }

    @Transactional
    public static boolean createAdresse(Adresse adresse, PersistenceType type) {
        return DaoFactory.getDaoFactory(type).getDaoAdresse().create(adresse);
    }

    @Transactional
    public static boolean updateAdresse(Adresse adresse, PersistenceType type) {
        return DaoFactory.getDaoFactory(type).getDaoAdresse().update(adresse);
    }

    public static void main(String[] args) {
        // Recherche d'une adresse
        Adresse adresseJPA = getAdresse(5, PersistenceType.JPA);
        Adresse adresseJSON = getAdresse(5, PersistenceType.JSON);

        System.out.println("Adresse JPA : "+adresseJPA);
        System.out.println("Adresse JSON : "+adresseJSON);

        // Nombre de biens à cette adresse
        System.out.println("Nombre de biens à l'adresse 5 JPA : " + getNombreBiens(adresseJPA, PersistenceType.JPA));
        System.out.println("Nombre de biens à l'adresse 5 JSON : " + getNombreBiens(adresseJSON, PersistenceType.JSON));

        // Création d'une nouvelle adresse
        Adresse nouvelleAdresse = new Adresse(6, "rue", "Jean Souvraz", "62300", "Lille");

        createAdresse(nouvelleAdresse, PersistenceType.JPA);
        createAdresse(nouvelleAdresse, PersistenceType.JSON);

        System.out.println("Adresse créée JPA : " + getAdresse(6, PersistenceType.JPA));
        System.out.println("Adresse créée JSON : " + getAdresse(6, PersistenceType.JSON));

        // Modification d'une adresse
        nouvelleAdresse.setVille("Lens");
        updateAdresse(nouvelleAdresse, PersistenceType.JPA);
        updateAdresse(nouvelleAdresse, PersistenceType.JSON);

        System.out.println("Adresse modifiée JPA : " + getAdresse(6, PersistenceType.JPA));
        System.out.println("Adresse modifiée JSON : " + getAdresse(6, PersistenceType.JSON));
    }
}
