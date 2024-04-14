package dao;

import jpaDto.E_Adresse;
import jpaDto.E_Bien;

import java.util.List;

public interface DaoBien extends Dao<E_Bien> {
    public E_Bien find(int id);
    public List<E_Bien> findByAdresse(E_Adresse adresse);
}
