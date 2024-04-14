package jsonDaoSingleton;

import dao.DaoTypeBien;
import jakarta.persistence.TypedQuery;
import jpaDto.E_TypeBien;

import java.util.List;

public class JsonDaoSingletonTypeBien extends JsonDaoSingleton<E_TypeBien> implements DaoTypeBien {

    @Override
    public boolean deleteAll() {
        return false;
    }

    @Override
    public E_TypeBien findLibTypeBien(String lib) {
        return null;
    }

    @Override
    public E_TypeBien find(int id) {
        return null;
    }

    private JsonDaoSingletonTypeBien() {
        super();
    }

    @Override
    public boolean create(E_TypeBien obj) {
        return false;
    }

    @Override
    public E_TypeBien find(Class<E_TypeBien> c, int id) {
        return null;
    }

    @Override
    public List<E_TypeBien> findAll(Class<E_TypeBien> c) {
        return List.of();
    }

    @Override
    public boolean update(E_TypeBien obj) {
        return false;
    }

    @Override
    public boolean delete(E_TypeBien obj) {
        return false;
    }

    @Override
    public boolean deleteAll(Class<E_TypeBien> c) {
        return false;
    }

    private static JsonDaoSingletonTypeBien instance;
    public static JsonDaoSingletonTypeBien getInstance() {
        if (instance == null) {
            instance = new JsonDaoSingletonTypeBien();
        }
        return instance;
    }
}

