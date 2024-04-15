package metier;

import java.util.Date;

public class Bien {
    private final int id;
    private TypeBien typeBien;
    private CategorieBien categorieBien;
    private Adresse adresse;
    private float surfaceHabitable;
    private Integer nbrPieces;
    private String description;
    private String commentaireAgence;
    private String noAppartement;
    private Integer etage;
    private Date dateCreation;
    private Date dateDerniereMaj;

    public Bien(int id, TypeBien typeBien, CategorieBien categorieBien, Adresse adresse, float surfaceHabitable, Integer nbrPieces, String description, String commentaireAgence, String noAppartement, Integer etage, Date dateCreation, Date dateDerniereMaj) {
        this.id = id;
        this.typeBien = typeBien;
        this.categorieBien = categorieBien;
        this.adresse = adresse;
        this.surfaceHabitable = surfaceHabitable;
        this.nbrPieces = nbrPieces;
        this.description = description;
        this.commentaireAgence = commentaireAgence;
        this.noAppartement = noAppartement;
        this.etage = etage;
        this.dateCreation = dateCreation;
        this.dateDerniereMaj = dateDerniereMaj;
    }

    public int getId() {
        return id;
    }

    public TypeBien getTypeBien() {
        return typeBien;
    }

    public void setTypeBien(TypeBien typeBien) {
        this.typeBien = typeBien;
    }

    public CategorieBien getCategorieBien() {
        return categorieBien;
    }

    public void setCategorieBien(CategorieBien categorieBien) {
        this.categorieBien = categorieBien;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
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

    public void setNbrPieces(int nbrPieces) {
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

    @Override
    public String toString() {
        return "Bien{" +
                "id=" + id +
                ", typeBien=" + typeBien +
                ", categorieBien=" + categorieBien +
                ", adresse=" + adresse +
                ", surfaceHabitable=" + surfaceHabitable +
                ", nbrPieces=" + nbrPieces +
                ", description='" + description + '\'' +
                ", commentaireAgence='" + commentaireAgence + '\'' +
                ", noAppartement='" + noAppartement + '\'' +
                ", etage=" + etage +
                ", dateCreation=" + dateCreation +
                ", dateDerniereMaj=" + dateDerniereMaj +
                '}';
    }
}
