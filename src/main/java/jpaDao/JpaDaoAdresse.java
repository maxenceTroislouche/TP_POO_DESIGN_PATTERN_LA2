package jpaDao;

import dao.DaoAdresse;
import jpaDto.E_Adresse;
import jpaDto.E_Bien;

import java.util.List;

public class JpaDaoAdresse extends JpaDao<E_Adresse> implements DaoAdresse {
    @Override
    public int nombreBiens(E_Adresse adresse) {
        JpaDaoBien jpaDaoBien = new JpaDaoBien();
        return jpaDaoBien.findByAdresse(adresse).size();
    }

    @Override
    public List<E_Bien> biensACetteAdresse(E_Adresse adresse) {
        JpaDaoBien jpaDaoBien = new JpaDaoBien();
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
}
