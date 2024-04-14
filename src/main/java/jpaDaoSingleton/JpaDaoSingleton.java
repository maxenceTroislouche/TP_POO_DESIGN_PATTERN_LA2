package jpaDaoSingleton;

import dao.Dao;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public abstract class JpaDaoSingleton<T> implements Dao<T> {
    private static final String persistenceUnitName = "default";
    protected final EntityManager entityManager;
    private final EntityManagerFactory entityManagerFactory;
    protected final EntityTransaction entityTransaction;

    protected JpaDaoSingleton() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
        this.entityManager = this.entityManagerFactory.createEntityManager();
        this.entityTransaction = this.entityManager.getTransaction();
    }

    public boolean create(T obj) {
        try {
            this.entityTransaction.begin();
            this.entityManager.persist(obj);
            this.entityTransaction.commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public T find(Class<T> c, int id) {
        try {
            this.entityTransaction.begin();
            T obj = this.entityManager.find(c, id);
            this.entityTransaction.commit();
            return obj;
        } catch (Exception e) {
            return null;
        }
    }

    public List<T> findAll(Class<T> c) {
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

    public boolean update(T obj) {
        try {
            this.entityTransaction.begin();
            this.entityManager.merge(obj);
            this.entityTransaction.commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean delete(T obj) {
        try {
            this.entityTransaction.begin();
            this.entityManager.detach(obj);
            this.entityTransaction.commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean deleteAll(Class<T> c) {
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




