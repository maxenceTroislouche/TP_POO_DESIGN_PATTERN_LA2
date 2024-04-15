package dao;

import metier.Adresse;
import metier.Bien;

import java.util.List;

public interface DaoBien extends Dao<Bien> {
    public Bien find(int id);
    public List<Bien> findByAdresse(Adresse adresse);
}
