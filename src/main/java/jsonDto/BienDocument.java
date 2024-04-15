package jsonDto;

import metier.Adresse;
import metier.Bien;
import metier.CategorieBien;
import metier.TypeBien;
import org.bson.Document;

import java.math.BigDecimal;

public class BienDocument extends Document {

    public BienDocument(Bien bien) {
        TypeBienDocument typeBienDocument = null;
        if (bien.getTypeBien() != null) {
            typeBienDocument = new TypeBienDocument(bien.getTypeBien());
        }

        CategorieBienDocument categorieBienDocument = null;
        if (bien.getCategorieBien() != null) {
            categorieBienDocument = new CategorieBienDocument(bien.getCategorieBien());
        }

        AdresseDocument adresseDocument = null;
        if (bien.getAdresse() != null) {
            adresseDocument = new AdresseDocument(bien.getAdresse());
        }

        this.append("id", bien.getId())
                .append("typeBien", typeBienDocument)
                .append("categorieBien", categorieBienDocument)
                .append("adresse", adresseDocument)
                .append("surfaceHabitable", bien.getSurfaceHabitable())
                .append("nbrPieces", bien.getNbrPieces())
                .append("description", bien.getDescription())
                .append("commentaireAgence", bien.getCommentaireAgence())
                .append("noAppartement", bien.getNoAppartement())
                .append("etage", bien.getEtage())
                .append("dateCreation", bien.getDateCreation())
                .append("dateDerniereMaj", bien.getDateDerniereMaj());
    }

    public BienDocument(Document document) {
        TypeBienDocument typeBienDocument = null;
        if (document.get("typeBien") != null) {
            typeBienDocument = new TypeBienDocument((Document) document.get("typeBien"));
        }

        CategorieBienDocument categorieBienDocument = null;
        if (document.get("categorieBien") != null) {
            categorieBienDocument = new CategorieBienDocument((Document) document.get("categorieBien"));
        }

        AdresseDocument adresseDocument = null;
        if (document.get("adresse") != null) {
            adresseDocument = new AdresseDocument((Document) document.get("adresse"));
        }

        this.append("id", document.getInteger("id"))
                .append("typeBien", typeBienDocument)
                .append("categorieBien", categorieBienDocument)
                .append("adresse", adresseDocument)
                .append("surfaceHabitable", document.getDouble("surfaceHabitable"))
                .append("nbrPieces", document.getInteger("nbrPieces"))
                .append("description", document.getString("description"))
                .append("commentaireAgence", document.getString("commentaireAgence"))
                .append("noAppartement", document.getString("noAppartement"))
                .append("etage", document.getInteger("etage"))
                .append("dateCreation", document.getDate("dateCreation"))
                .append("dateDerniereMaj", document.getDate("dateDerniereMaj"));
    }

    public Bien getMetier() {
        TypeBienDocument typeBienDocument = (TypeBienDocument) this.get("typeBien");
        TypeBien typeBien = null;
        if (typeBienDocument != null) {
            typeBien = typeBienDocument.getMetier();
        }

        CategorieBienDocument categorieBienDocument = (CategorieBienDocument) this.get("categorieBien");
        CategorieBien categorieBien = null;
        if (categorieBienDocument != null) {
            categorieBien = categorieBienDocument.getMetier();
        }

        AdresseDocument adresseDocument = (AdresseDocument) this.get("adresse");
        Adresse adresse = null;
        if (adresseDocument != null) {
            adresse = adresseDocument.getMetier();
        }

        return new Bien(
                this.getInteger("id"),
                typeBien,
                categorieBien,
                adresse,
                // Pas sur que ça soit la meilleure façon de récupérer un float :/
                // https://stackoverflow.com/questions/26906984/how-to-get-float-value-from-json
                BigDecimal.valueOf(this.getDouble("surfaceHabitable")).floatValue(),
                this.getInteger("nbrPieces"),
                this.getString("description"),
                this.getString("commentaireAgence"),
                this.getString("noAppartement"),
                this.getInteger("etage"),
                this.getDate("dateCreation"),
                this.getDate("dateDerniereMaj")
        );
    }
}
