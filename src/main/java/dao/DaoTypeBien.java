package dao;

import metier.TypeBien;

public interface DaoTypeBien extends Dao<TypeBien> {
    public TypeBien findLibTypeBien(String lib);
    public TypeBien find(int id);
}
