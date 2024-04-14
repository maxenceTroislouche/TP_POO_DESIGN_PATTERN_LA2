package dao;

import jpaDto.E_CategorieBien;

public interface DaoCategorieSurface extends Dao<E_CategorieBien> {
    public E_CategorieBien findLibCategorieSurface(String lib);
    public E_CategorieBien find(int id);
}

