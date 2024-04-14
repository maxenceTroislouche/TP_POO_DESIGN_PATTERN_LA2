package jsonDaoSingleton;

import dao.DaoBien;
import jpaDto.E_Adresse;
import jpaDto.E_Bien;

import java.util.ArrayList;
import java.util.List;

public class JsonDaoSingletonBien extends JsonDaoSingleton<E_Bien> implements DaoBien {
    @Override
    public E_Bien find(int id) {
        return null;
    }

    @Override
    public List<E_Bien> findByAdresse(E_Adresse adresse) {
        return null;
    }

    @Override
    public boolean deleteAll() {
        return false;
    }

    @Override
    public void close() {

    }

    private JsonDaoSingletonBien() {
        super();
    }

    @Override
    public boolean create(E_Bien obj) {
        return false;
    }

    @Override
    public E_Bien find(Class<E_Bien> c, int id) {
        return null;
    }

    @Override
    public List<E_Bien> findAll(Class<E_Bien> c) {
        return List.of();
    }

    @Override
    public boolean update(E_Bien obj) {
        return false;
    }

    @Override
    public boolean delete(E_Bien obj) {
        return false;
    }

    @Override
    public boolean deleteAll(Class<E_Bien> c) {
        return false;
    }

    private static JsonDaoSingletonBien instance;
    public static JsonDaoSingletonBien getInstance() {
        if (instance == null) {
            instance = new JsonDaoSingletonBien();
        }
        return instance;
    }
}
