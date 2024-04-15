package jpaDaoSingleton;

import dao.DaoAdresse;
import jpaDto.E_Adresse;
import metier.Adresse;
import metier.Bien;

import java.util.ArrayList;
import java.util.List;

public class JpaDaoSingletonAdresse extends JpaDaoSingleton<E_Adresse> implements DaoAdresse {

    @Override
    public int nombreBiens(Adresse adresse) {
        JpaDaoSingletonBien jpaDaoSingletonBien = JpaDaoSingletonBien.getInstance();
        return jpaDaoSingletonBien.findByAdresse(adresse).size();
    }

    @Override
    public List<Bien> biensACetteAdresse(Adresse adresse) {
        JpaDaoSingletonBien jpaDaoSingletonBien = JpaDaoSingletonBien.getInstance();
        return jpaDaoSingletonBien.findByAdresse(adresse);
    }

    @Override
    public Adresse find(int id) {
        E_Adresse adresseEntity = super.findEntity(E_Adresse.class, id);
        if (adresseEntity == null) {
            return null;
        }
        return adresseEntity.getMetier();
    }

    @Override
    public boolean create(Adresse obj) {
        E_Adresse adresseEntity = (E_Adresse) JpaDaoEntityMapper.getEntityObject(obj);
        return super.createEntity(adresseEntity);
    }

    @Override
    public Adresse find(Class<Adresse> c, int id) {
        return this.find(id);
    }

    @Override
    public List<Adresse> findAll(Class<Adresse> c) {
        List<E_Adresse> listOfAdresses = super.findAllEntities(E_Adresse.class);
        List<Adresse> returnList = new ArrayList<>();
        for (E_Adresse adresse : listOfAdresses) {
            returnList.add(adresse.getMetier());
        }
        return returnList;
    }

    @Override
    public boolean update(Adresse obj) {
        E_Adresse adresseEntity = (E_Adresse) JpaDaoEntityMapper.getEntityObject(obj);
        return super.updateEntity(adresseEntity);
    }

    @Override
    public boolean delete(Adresse obj) {
        E_Adresse adresseEntity = (E_Adresse) JpaDaoEntityMapper.getEntityObject(obj);
        return super.deleteEntity(adresseEntity);
    }

    @Override
    public boolean deleteAll() {
        return super.deleteAllEntities(E_Adresse.class);
    }

    private JpaDaoSingletonAdresse() {
        super();
    }

    private static JpaDaoSingletonAdresse instance;
    public static JpaDaoSingletonAdresse getInstance() {
        if (instance == null) {
            instance = new JpaDaoSingletonAdresse();
        }
        return instance;
    }
}
