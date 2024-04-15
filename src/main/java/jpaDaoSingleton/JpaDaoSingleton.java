package jpaDaoSingleton;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public abstract class JpaDaoSingleton<T> {
    private static final String persistenceUnitName = "default";
    protected final EntityManager entityManager;
    private final EntityManagerFactory entityManagerFactory;
    protected final EntityTransaction entityTransaction;

    protected JpaDaoSingleton() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
        this.entityManager = this.entityManagerFactory.createEntityManager();
        this.entityTransaction = this.entityManager.getTransaction();
    }

    protected boolean createEntity(T entity) {
        try {
            this.entityTransaction.begin();
            this.entityManager.merge(entity); // merge au lieu de persist pour éviter les erreurs d'entités détachées
//            this.entityManager.persist(entity);
            this.entityTransaction.commit();
        } catch (Exception e) {
            System.out.println("Erreur lors de la création de l'entité");
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    protected T findEntity(Class<T> c, int id) {
        try {
            this.entityTransaction.begin();
            T entity = this.entityManager.find(c, id);
            this.entityTransaction.commit();
            return entity;
        } catch (Exception e) {
            return null;
        }
    }

    protected List<T> findAllEntities(Class<T> c) {
        try {
            this.entityTransaction.begin();
            String queryString = "SELECT e FROM " + c.getSimpleName() + " e";
            TypedQuery<T> query = this.entityManager.createQuery(queryString, c);
            List<T> list = query.getResultList();
            this.entityTransaction.commit();
            return list;
        } catch (Exception e) {
            return new ArrayList<T>();
        }
    }

    protected boolean updateEntity(T entity) {
        try {
            this.entityTransaction.begin();
            this.entityManager.merge(entity);
            this.entityTransaction.commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    protected boolean deleteEntity(T entity) {
        try {
            this.entityTransaction.begin();
            this.entityManager.detach(entity);
            this.entityTransaction.commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    protected boolean deleteAllEntities(Class<T> c) {
        try {
            this.entityTransaction.begin();
            String queryString = "DELETE FROM " + c.getSimpleName() + " e";
            TypedQuery<T> query = this.entityManager.createQuery(queryString, c);
            query.executeUpdate();
            this.entityTransaction.commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void close() {
        this.entityManagerFactory.close();
        this.entityManager.close();
    }
}




