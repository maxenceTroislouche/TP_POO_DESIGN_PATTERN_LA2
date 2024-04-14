package jsonDto;

import metier.Bien;
import org.bson.Document;

import java.math.BigDecimal;

public class BienDocument extends Document {

    public BienDocument(Bien bien) {
        this.append("id", bien.getId())
                .append("typeBien", new TypeBienDocument(bien.getTypeBien()))
                .append("categorieBien", new CategorieBienDocument(bien.getCategorieBien()))
                .append("adresse", new AdresseDocument(bien.getAdresse()))
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
        this.append("id", document.getInteger("id"))
                .append("typeBien", new TypeBienDocument((Document) document.get("typeBien")))
                .append("categorieBien", new CategorieBienDocument((Document) document.get("categorieBien")))
                .append("adresse", new AdresseDocument((Document) document.get("adresse")))
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
        return new Bien(
                this.getInteger("id"),
                ((TypeBienDocument) this.get("typeBien")).getMetier(),
                ((CategorieBienDocument) this.get("categorieBien")).getMetier(),
                ((AdresseDocument) this.get("adresse")).getMetier(),
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
