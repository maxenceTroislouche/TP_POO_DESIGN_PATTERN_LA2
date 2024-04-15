package jpaDaoSingleton;

import dao.DaoCategorieSurface;
import jakarta.persistence.TypedQuery;
import jpaDto.E_CategorieBien;
import metier.CategorieBien;

import java.util.ArrayList;
import java.util.List;

public class JpaDaoSingletonCategorieSurface extends JpaDaoSingleton<E_CategorieBien> implements DaoCategorieSurface {
    @Override
    public CategorieBien findLibCategorieSurface(String lib) {
        try {
            this.entityTransaction.begin();
            String queryString = "SELECT e FROM E_CategorieBien e WHERE e.lib = :lib";
            TypedQuery<E_CategorieBien> query = super.entityManager.createQuery(queryString, E_CategorieBien.class);
            query.setParameter("lib", lib);
            CategorieBien returnVal = query.getSingleResult().getMetier();
            this.entityTransaction.commit();
            return returnVal;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public CategorieBien find(int id) {
        E_CategorieBien categorieBienEntity = super.findEntity(E_CategorieBien.class, id);
        return categorieBienEntity.getMetier();
    }

    @Override
    public boolean create(CategorieBien obj) {
        E_CategorieBien categorieBienEntity = (E_CategorieBien) JpaDaoEntityMapper.getEntityObject(obj);
        return super.createEntity(categorieBienEntity);
    }

    @Override
    public CategorieBien find(Class<CategorieBien> c, int id) {
        return this.find(id);
    }

    @Override
    public List<CategorieBien> findAll(Class<CategorieBien> c) {
        try {
            this.entityTransaction.begin();
            String queryString = "SELECT e FROM E_CategorieBien e";
            TypedQuery<E_CategorieBien> query = super.entityManager.createQuery(queryString, E_CategorieBien.class);
            List<E_CategorieBien> listOfCategorieBienEntities = query.getResultList();
            List<CategorieBien> returnList = new ArrayList<>();

            for (E_CategorieBien categorieBienEntity : listOfCategorieBienEntities) {
                returnList.add(categorieBienEntity.getMetier());
            }

            this.entityTransaction.commit();
            return returnList;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public boolean update(CategorieBien obj) {
        E_CategorieBien categorieBienEntity = (E_CategorieBien) JpaDaoEntityMapper.getEntityObject(obj);
        return super.updateEntity(categorieBienEntity);
    }

    @Override
    public boolean delete(CategorieBien obj) {
        E_CategorieBien categorieBienEntity = (E_CategorieBien) JpaDaoEntityMapper.getEntityObject(obj);
        return super.deleteEntity(categorieBienEntity);
    }

    @Override
    public boolean deleteAll() {
        return super.deleteAllEntities(E_CategorieBien.class);
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
