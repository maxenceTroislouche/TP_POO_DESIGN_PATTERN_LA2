package jpaDaoSingleton;

import dao.*;

public class JpaDaoFactory extends DaoFactory {
    public DaoBien getDaoBien() {
        return JpaDaoSingletonBien.getInstance();
    }

    public DaoTypeBien getDaoTypeBien() {
        return JpaDaoSingletonTypeBien.getInstance();
    }

    public DaoCategorieSurface getDaoCategorieSurface() {
        return JpaDaoSingletonCategorieSurface.getInstance();
    }

    public DaoAdresse getDaoAdresse() {
        return JpaDaoSingletonAdresse.getInstance();
    }
}
