package jsonDaoSingleton;

import dao.*;

public class JsonDaoFactory extends DaoFactory {
    public DaoBien getDaoBien() {
        return JsonDaoSingletonBien.getInstance();
    }

    public DaoTypeBien getDaoTypeBien() {
        return JsonDaoSingletonTypeBien.getInstance();
    }

    public DaoCategorieSurface getDaoCategorieSurface() {
        return JsonDaoSingletonCategorieSurface.getInstance();
    }

    public DaoAdresse getDaoAdresse() {
        return JsonDaoSingletonAdresse.getInstance();
    }
}
