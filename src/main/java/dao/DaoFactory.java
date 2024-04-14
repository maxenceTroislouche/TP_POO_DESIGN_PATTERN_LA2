package dao;

import jpaDaoSingleton.JpaDaoFactory;
import jsonDaoSingleton.JsonDaoFactory;

public abstract class DaoFactory {
    public abstract DaoBien getDaoBien();
    public abstract DaoTypeBien getDaoTypeBien();
    public abstract DaoCategorieSurface getDaoCategorieSurface();
    public abstract DaoAdresse getDaoAdresse();

    public static DaoFactory getDaoFactory(PersistenceType persistenceType) {
        if (persistenceType == PersistenceType.JPA) {
            return new JpaDaoFactory();
        } else if (persistenceType == PersistenceType.JSON) {
            return new JsonDaoFactory();
        } else {
            return null;
        }
    }
}
