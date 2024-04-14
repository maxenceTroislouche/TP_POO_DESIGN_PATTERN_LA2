package jpaDto;

import jakarta.persistence.*;
import metier.Bien;

import java.util.Date;

@Entity
@Table(name = "BIEN")
public class E_Bien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_BIEN")
    private int id;

    @ManyToOne
    @JoinColumn(name = "type_bien")
    private E_TypeBien type;

    @ManyToOne
    @JoinColumn(name = "categorie_surface_bien")
    private E_CategorieBien categorie;

    @ManyToOne
    @JoinColumn(name = "ID_ADRESSE")
    private E_Adresse adresse;

    @Column(name = "surface_habitable")
    private float surfaceHabitable;

    @Column(name = "nbr_pieces")
    private Integer nbrPieces;

    @Column(name = "description_libre")
    private String description;

    @Column(name = "Commentaire_agence")
    private String commentaireAgence;

    @Column(name = "date_creation")
    private Date dateCreation;

    @Column(name = "date_derniere_maj")
    private Date dateDerniereMaj;

    @Column(name = "NO_APPARTEMENT")
    private String noAppartement;

    @Column(name = "ETAGE")
    private Integer etage;

    public E_Bien() {

    }

    public E_Bien(Bien bien) {
        this.id = bien.getId();
        this.type = new E_TypeBien(bien.getTypeBien());
        this.categorie = new E_CategorieBien(bien.getCategorieBien());
        this.adresse = new E_Adresse(bien.getAdresse());
        this.surfaceHabitable = bien.getSurfaceHabitable();
        this.nbrPieces = bien.getNbrPieces();
        this.description = bien.getDescription();
        this.commentaireAgence = bien.getCommentaireAgence();
        this.dateCreation = bien.getDateCreation();
        this.dateDerniereMaj = bien.getDateDerniereMaj();
        this.noAppartement = bien.getNoAppartement();
        this.etage = bien.getEtage();
    }

    public Bien getMetier() {
        return new Bien(this.id, this.type.getMetier(), this.categorie.getMetier(), this.adresse.getMetier(), this.surfaceHabitable, this.nbrPieces, this.description, this.commentaireAgence, this.noAppartement, this.etage, this.dateCreation, this.dateDerniereMaj);
    }

    @Override
    public String toString() {
        return "E_Bien{" +
                "id=" + id +
                ", type=" + type +
                ", categorie=" + categorie +
                ", adresse=" + adresse +
                ", surfaceHabitable=" + surfaceHabitable +
                ", nbrPieces=" + nbrPieces +
                ", description='" + description + '\'' +
                ", commentaireAgence='" + commentaireAgence + '\'' +
                ", dateCreation=" + dateCreation +
                ", dateDerniereMaj=" + dateDerniereMaj +
                ", noAppartement='" + noAppartement + '\'' +
                ", etage=" + etage +
                '}';
    }

    public int getId() {
        return id;
    }

    public E_TypeBien getType() {
        return type;
    }

    public void setType(E_TypeBien type) {
        this.type = type;
    }

    public E_CategorieBien getCategorie() {
        return categorie;
    }

    public void setCategorie(E_CategorieBien categorie) {
        this.categorie = categorie;
    }

    public E_Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(E_Adresse adresse) {
        this.adresse = adresse;
    }

    public float getSurfaceHabitable() {
        return surfaceHabitable;
    }

    public void setSurfaceHabitable(float surfaceHabitable) {
        this.surfaceHabitable = surfaceHabitable;
    }

    public Integer getNbrPieces() {
        return nbrPieces;
    }

    public void setNbrPieces(Integer nbrPieces) {
        this.nbrPieces = nbrPieces;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCommentaireAgence() {
        return commentaireAgence;
    }

    public void setCommentaireAgence(String commentaireAgence) {
        this.commentaireAgence = commentaireAgence;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateDerniereMaj() {
        return dateDerniereMaj;
    }

    public void setDateDerniereMaj(Date dateDerniereMaj) {
        this.dateDerniereMaj = dateDerniereMaj;
    }

    public String getNoAppartement() {
        return noAppartement;
    }

    public void setNoAppartement(String noAppartement) {
        this.noAppartement = noAppartement;
    }

    public Integer getEtage() {
        return etage;
    }

    public void setEtage(Integer etage) {
        this.etage = etage;
    }
}
