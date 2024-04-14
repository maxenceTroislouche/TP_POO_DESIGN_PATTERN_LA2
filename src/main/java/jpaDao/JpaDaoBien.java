package jpaDao;

import dao.DaoBien;
import jpaDto.E_Adresse;
import jpaDto.E_Bien;

import java.util.ArrayList;
import java.util.List;

public class JpaDaoBien extends JpaDao<E_Bien> implements DaoBien {
    @Override
    public E_Bien find(int id) {
        return super.find(E_Bien.class, id);
    }

    @Override
    public List<E_Bien> findByAdresse(E_Adresse adresse) {
        try {
            super.entityTransaction.begin();
            String queryString = "SELECT b FROM E_Bien b WHERE b.adresse = :adresse";

            List<E_Bien> biens = super.entityManager.createQuery(queryString, E_Bien.class)
                    .setParameter("adresse", adresse)
                    .getResultList();
            super.entityTransaction.commit();
            return biens;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public boolean deleteAll() {
        return super.deleteAll(E_Bien.class);
    }
}
