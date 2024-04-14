package jsonDaoSingleton;

import dao.DaoAdresse;
import jpaDto.E_Adresse;
import jpaDto.E_Bien;

import java.util.List;

public class JsonDaoSingletonAdresse extends JsonDaoSingleton<E_Adresse> implements DaoAdresse {
    @Override
    public int nombreBiens(E_Adresse adresse) {
        return 0;
    }

    @Override
    public List<E_Bien> biensACetteAdresse(E_Adresse adresse) {
        return null;
    }

    @Override
    public E_Adresse find(int id) {
        return null;
    }

    @Override
    public boolean deleteAll() {
        return false;
    }

    private JsonDaoSingletonAdresse() {
        super();
    }

    @Override
    public boolean create(E_Adresse obj) {
        return false;
    }

    @Override
    public E_Adresse find(Class<E_Adresse> c, int id) {
        return null;
    }

    @Override
    public List<E_Adresse> findAll(Class<E_Adresse> c) {
        return List.of();
    }

    @Override
    public boolean update(E_Adresse obj) {
        return false;
    }

    @Override
    public boolean delete(E_Adresse obj) {
        return false;
    }

    @Override
    public boolean deleteAll(Class<E_Adresse> c) {
        return false;
    }

    private static JsonDaoSingletonAdresse instance;
    public static JsonDaoSingletonAdresse getInstance() {
        if (instance == null) {
            instance = new JsonDaoSingletonAdresse();
        }
        return instance;
    }
}
