package dao;

import metier.CategorieBien;

public interface DaoCategorieSurface extends Dao<CategorieBien> {
    public CategorieBien findLibCategorieSurface(String lib);
    public CategorieBien find(int id);
}

