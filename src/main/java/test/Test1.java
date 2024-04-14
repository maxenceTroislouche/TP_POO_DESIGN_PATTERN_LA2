package test;


import dao.DaoAdresse;
import dao.DaoBien;
import dao.DaoCategorieSurface;
import dao.DaoTypeBien;
import jpaDao.JpaDaoAdresse;
import jpaDao.JpaDaoBien;
import jpaDao.JpaDaoCategorieSurface;
import jpaDao.JpaDaoTypeBien;
import jpaDto.E_Adresse;
import jpaDto.E_Bien;
import jpaDto.E_CategorieBien;
import jpaDto.E_TypeBien;

public class Test1 {
    public static void main(String[] args) {
        DaoAdresse adresseManager = new JpaDaoAdresse();
        E_Adresse chezMoi = adresseManager.find(5);
        if (chezMoi != null)
            System.out.println("Chez moi : "+chezMoi.toString()+" il y a "+adresseManager.nombreBiens(chezMoi));
        else
            System.out.println("Flute, adresse non trouvée !");

        // recherche des biens à cette adresse
        System.out.println("les biens de l'adresse N°1 : "+adresseManager.biensACetteAdresse(adresseManager.find(1)).toString());
        System.out.println("les biens de l'adresse N°5 : "+adresseManager.biensACetteAdresse(adresseManager.find(5)).toString());

        // Création d'un nouveau Bien
        DaoTypeBien typeBienManager = new JpaDaoTypeBien();
        E_TypeBien appartement = typeBienManager.findLibTypeBien("APPARTEMENT");

        DaoCategorieSurface categorieSurfaceManager = new JpaDaoCategorieSurface();
        E_CategorieBien studio = categorieSurfaceManager.findLibCategorieSurface("STUDIO");

        E_Bien chezToi = new E_Bien();
        chezToi.setType(appartement);
        chezToi.setAdresse(chezMoi);
        chezToi.setCategorie(studio);
        chezToi.setSurfaceHabitable(30.0f);

        DaoBien BienManager = new JpaDaoBien();
        BienManager.create(chezToi);
        System.out.println(chezToi);

        DaoBien BienManager2 = new JpaDaoBien();
        E_Bien unLogement = new E_Bien();
        unLogement.setType(appartement);
        unLogement.setAdresse(chezMoi);
        unLogement.setSurfaceHabitable(100.0f);

        BienManager.create(unLogement);
        BienManager2.create(unLogement);

        System.out.println("Nombre de  biens en base BienManager : "+BienManager.findAll(E_Bien.class).size());
        System.out.println("Nombre de  biens en base BienManager2: "+BienManager2.findAll(E_Bien.class).size());
    }
}
