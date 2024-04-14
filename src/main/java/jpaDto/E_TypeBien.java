package jpaDto;

import jakarta.persistence.*;
import metier.TypeBien;

@Entity
@Table(name = "TYPE_BIEN")
public class E_TypeBien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TYPE_BIEN")
    private int id;

    @Column(name = "LIB_TYPE_BIEN")
    private String lib;

    public E_TypeBien() {

    }

    public E_TypeBien(TypeBien typeBien) {
        this.id = typeBien.getId();
        this.lib = typeBien.getLib();
    }

    public TypeBien getMetier() {
        return new TypeBien(this.id, this.lib);
    }

    @Override
    public String toString() {
        return "E_TypeBien{" +
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
