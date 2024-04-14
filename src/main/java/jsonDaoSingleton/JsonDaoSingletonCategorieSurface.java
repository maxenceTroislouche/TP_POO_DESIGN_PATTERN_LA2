package jsonDaoSingleton;

import dao.DaoCategorieSurface;
import jakarta.persistence.TypedQuery;
import jpaDto.E_CategorieBien;

import java.util.List;

public class JsonDaoSingletonCategorieSurface extends JsonDaoSingleton<E_CategorieBien> implements DaoCategorieSurface {
    @Override
    public E_CategorieBien findLibCategorieSurface(String lib) {
        return null;
    }

    @Override
    public E_CategorieBien find(int id) {
        return null;
    }

    @Override
    public boolean deleteAll() {
        return false;
    }

    @Override
    public void close() {

    }

    private JsonDaoSingletonCategorieSurface() {
        super();
    }

    @Override
    public boolean create(E_CategorieBien obj) {
        return false;
    }

    @Override
    public E_CategorieBien find(Class<E_CategorieBien> c, int id) {
        return null;
    }

    @Override
    public List<E_CategorieBien> findAll(Class<E_CategorieBien> c) {
        return List.of();
    }

    @Override
    public boolean update(E_CategorieBien obj) {
        return false;
    }

    @Override
    public boolean delete(E_CategorieBien obj) {
        return false;
    }

    @Override
    public boolean deleteAll(Class<E_CategorieBien> c) {
        return false;
    }

    private static JsonDaoSingletonCategorieSurface instance;
    public static JsonDaoSingletonCategorieSurface getInstance() {
        if (instance == null) {
            instance = new JsonDaoSingletonCategorieSurface();
        }
        return instance;
    }
}
