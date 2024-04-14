package jpaDaoSingleton;

import dao.DaoCategorieSurface;
import jakarta.persistence.TypedQuery;
import jpaDto.E_CategorieBien;

public class JpaDaoSingletonCategorieSurface extends JpaDaoSingleton<E_CategorieBien> implements DaoCategorieSurface {
    @Override
    public E_CategorieBien findLibCategorieSurface(String lib) {
        String queryString = "SELECT e FROM E_CategorieBien e WHERE e.lib = :lib";
        TypedQuery<E_CategorieBien> query = super.entityManager.createQuery(queryString, E_CategorieBien.class);
        query.setParameter("lib", lib);
        return query.getSingleResult();
    }

    @Override
    public E_CategorieBien find(int id) {
        return super.find(E_CategorieBien.class, id);
    }

    @Override
    public boolean deleteAll() {
        return super.deleteAll(E_CategorieBien.class);
    }

    private JpaDaoSingletonCategorieSurface() {
        super();
    }

    private static JpaDaoSingletonCategorieSurface instance;
    public static JpaDaoSingletonCategorieSurface getInstance() {
        if (instance == null) {
            instance = new JpaDaoSingletonCategorieSurface();
        }
        return instance;
    }
}
