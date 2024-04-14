package jpaDto;

import jakarta.persistence.*;
import metier.CategorieBien;

@Entity
@Table(name = "CATEGORIE_SURFACE_BIEN")
public class E_CategorieBien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CATEGORIE_SURFACE_BIEN")
    private int id;

    @Column(name = "LIB_CATEGORIE_SURFACE_BIEN")
    private String lib;

    public E_CategorieBien() {}

    public E_CategorieBien(CategorieBien categorieBien) {
        this.id = categorieBien.getId();
        this.lib = categorieBien.getLib();
    }

    public CategorieBien getMetier() {
        return new CategorieBien(this.id, this.lib);
    }

    @Override
    public String toString() {
        return "E_CategorieBien{" +
                "id=" + id +
                ", lib='" + lib + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getLib() {
        return lib;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }
}
