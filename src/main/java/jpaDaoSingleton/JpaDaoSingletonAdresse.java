package jpaDaoSingleton;

import dao.DaoAdresse;
import jpaDto.E_Adresse;
import jpaDto.E_Bien;

import java.util.List;

public class JpaDaoSingletonAdresse extends JpaDaoSingleton<E_Adresse> implements DaoAdresse {
    @Override
    public int nombreBiens(E_Adresse adresse) {
        JpaDaoSingletonBien jpaDaoBien = JpaDaoSingletonBien.getInstance();
        return jpaDaoBien.findByAdresse(adresse).size();
    }

    @Override
    public List<E_Bien> biensACetteAdresse(E_Adresse adresse) {
        JpaDaoSingletonBien jpaDaoBien = JpaDaoSingletonBien.getInstance();
        return jpaDaoBien.findByAdresse(adresse);
    }

    @Override
    public E_Adresse find(int id) {
        return super.find(E_Adresse.class, id);
    }

    @Override
    public boolean deleteAll() {
        return super.deleteAll(E_Adresse.class);
    }

    private JpaDaoSingletonAdresse() {
        super();
    }

    private static JpaDaoSingletonAdresse instance;
    public static JpaDaoSingletonAdresse getInstance() {
        if (instance == null) {
            instance = new JpaDaoSingletonAdresse();
        }
        return instance;
    }
}
