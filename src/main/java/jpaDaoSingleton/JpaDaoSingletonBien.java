package jpaDaoSingleton;

import dao.DaoBien;
import jpaDto.E_Adresse;
import jpaDto.E_Bien;
import metier.Adresse;
import metier.Bien;

import java.util.ArrayList;
import java.util.List;

public class JpaDaoSingletonBien extends JpaDaoSingleton<E_Bien> implements DaoBien {
    @Override
    public Bien find(int id) {
        E_Bien bienEntity = super.findEntity(E_Bien.class, id);
        return bienEntity.getMetier();
    }

    @Override
    public List<Bien> findByAdresse(Adresse adresse) {
        try {
            this.entityTransaction.begin();
            E_Adresse adresseEntity = (E_Adresse) JpaDaoEntityMapper.getEntityObject(adresse);

            String queryString = "SELECT b FROM E_Bien b WHERE b.adresse = :adresse";

            List<E_Bien> biens = super.entityManager.createQuery(queryString, E_Bien.class)
                    .setParameter("adresse", adresseEntity)
                    .getResultList();

            System.out.println("Liste des entités bien");
            System.out.println(biens);

            List<Bien> returnList = new ArrayList<>();
            for (E_Bien bien : biens) {
                System.out.println(bien.getMetier());
                returnList.add(bien.getMetier());
            }

            System.out.println("Liste des biens");
            System.out.println(returnList);

            this.entityTransaction.commit();

            return returnList;
        } catch (Exception e) {
            System.out.println("Erreur lors de la recherche des biens par adresse");
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public boolean create(Bien obj) {
        E_Bien bienEntity = (E_Bien) JpaDaoEntityMapper.getEntityObject(obj);
        return super.createEntity(bienEntity);
    }

    @Override
    public Bien find(Class<Bien> c, int id) {
        return this.find(id);
    }

    @Override
    public List<Bien> findAll(Class<Bien> c) {
        List<E_Bien> listOfBiens = super.findAllEntities(E_Bien.class);
        List<Bien> returnList = new ArrayList<>();
        for (E_Bien bien : listOfBiens) {
            returnList.add(bien.getMetier());
        }
        return returnList;
    }

    @Override
    public boolean update(Bien obj) {
        E_Bien bienEntity = (E_Bien) JpaDaoEntityMapper.getEntityObject(obj);
        return super.updateEntity(bienEntity);
    }

    @Override
    public boolean delete(Bien obj) {
        E_Bien bienEntity = (E_Bien) JpaDaoEntityMapper.getEntityObject(obj);
        return super.deleteEntity(bienEntity);
    }

    @Override
    public boolean deleteAll() {
        return super.deleteAllEntities(E_Bien.class);
    }

    private JpaDaoSingletonBien() {
        super();
    }

    private static JpaDaoSingletonBien instance;
    public static JpaDaoSingletonBien getInstance() {
        if (instance == null) {
            instance = new JpaDaoSingletonBien();
        }
        return instance;
    }
}
