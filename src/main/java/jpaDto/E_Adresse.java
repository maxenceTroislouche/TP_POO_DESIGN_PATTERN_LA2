package jpaDto;

import jakarta.persistence.*;
import metier.Adresse;

@Entity
@Table(name = "ADRESSE")
public class E_Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ADRESSE")
    private int id;

    @Column(name = "type_voie")
    private String typeVoie;

    @Column(name = "nom_voie")
    private String nomVoie;

    @Column(name = "code_postal")
    private String codePostal;

    @Column(name = "ville")
    private String ville;

    public E_Adresse() {}

    public E_Adresse(Adresse adresse) {
        this.id = adresse.getId();
        this.typeVoie = adresse.getTypeVoie();
        this.nomVoie = adresse.getNomVoie();
        this.codePostal = adresse.getCodePostal();
        this.ville = adresse.getVille();
    }

    public Adresse getMetier() {
        return new Adresse(this.id, this.typeVoie, this.nomVoie, this.codePostal, this.ville);
    }

    @Override
    public String toString() {
        return "E_Adresse{" +
                "id=" + id +
                ", typeVoie='" + typeVoie + '\'' +
                ", nomVoie='" + nomVoie + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }

    public String getTypeVoie() {
        return typeVoie;
    }

    public void setTypeVoie(String typeVoie) {
        this.typeVoie = typeVoie;
    }

    public String getNomVoie() {
        return nomVoie;
    }

    public void setNomVoie(String nomVoie) {
        this.nomVoie = nomVoie;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getId() {
        return id;
    }
}
