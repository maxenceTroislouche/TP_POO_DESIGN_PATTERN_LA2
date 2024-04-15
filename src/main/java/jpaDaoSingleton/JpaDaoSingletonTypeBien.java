package jpaDaoSingleton;

import dao.DaoTypeBien;
import jakarta.persistence.TypedQuery;
import jpaDto.E_CategorieBien;
import jpaDto.E_TypeBien;
import metier.CategorieBien;
import metier.TypeBien;

import java.util.List;

public class JpaDaoSingletonTypeBien extends JpaDaoSingleton<E_TypeBien> implements DaoTypeBien {
    @Override
    public TypeBien findLibTypeBien(String lib) {
        try {
            this.entityTransaction.begin();
            String queryString = "SELECT e FROM E_TypeBien e WHERE e.lib = :lib";
            TypedQuery<E_TypeBien> query = super.entityManager.createQuery(queryString, E_TypeBien.class);
            query.setParameter("lib", lib);
            TypeBien returnVal = query.getSingleResult().getMetier();
            this.entityTransaction.commit();
            return returnVal;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public TypeBien find(int id) {
        E_TypeBien typeBienEntity = super.findEntity(E_TypeBien.class, id);
        return typeBienEntity.getMetier();
    }

    @Override
    public boolean create(TypeBien obj) {
        E_TypeBien typeBienEntity = (E_TypeBien) JpaDaoEntityMapper.getEntityObject(obj);
        return super.createEntity(typeBienEntity);
    }

    @Override
    public TypeBien find(Class<TypeBien> c, int id) {
        return this.find(id);
    }

    @Override
    public List<TypeBien> findAll(Class<TypeBien> c) {
        try {
            this.entityTransaction.begin();
            String queryString = "SELECT e FROM E_TypeBien e";
            TypedQuery<E_TypeBien> query = super.entityManager.createQuery(queryString, E_TypeBien.class);
            List<E_TypeBien> listOfTypeBienEntities = query.getResultList();
            List<TypeBien> returnList = new java.util.ArrayList<>();

            for (E_TypeBien typeBienEntity : listOfTypeBienEntities) {
                returnList.add(typeBienEntity.getMetier());
            }

            this.entityTransaction.commit();
            return returnList;
        } catch (Exception e) {
            return new java.util.ArrayList<>();
        }
    }

    @Override
    public boolean update(TypeBien obj) {
        E_TypeBien typeBienEntity = (E_TypeBien) JpaDaoEntityMapper.getEntityObject(obj);
        return super.updateEntity(typeBienEntity);
    }

    @Override
    public boolean delete(TypeBien obj) {
        E_TypeBien typeBienEntity = (E_TypeBien) JpaDaoEntityMapper.getEntityObject(obj);
        return super.deleteEntity(typeBienEntity);
    }

    @Override
    public boolean deleteAll() {
        return super.deleteAllEntities(E_TypeBien.class);
    }

    private JpaDaoSingletonTypeBien() {
        super();
    }

    private static JpaDaoSingletonTypeBien instance;
    public static JpaDaoSingletonTypeBien getInstance() {
        if (instance == null) {
            instance = new JpaDaoSingletonTypeBien();
        }
        return instance;
    }
}

