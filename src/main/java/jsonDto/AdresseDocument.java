package jsonDto;

import metier.Adresse;
import org.bson.Document;

public class AdresseDocument extends Document {

    public AdresseDocument(Adresse adresse) {
        this.append("id", adresse.getId())
                .append("typeVoie", adresse.getTypeVoie())
                .append("nomVoie", adresse.getNomVoie())
                .append("codePostal", adresse.getCodePostal())
                .append("ville", adresse.getVille());
    }

    public AdresseDocument(Document document) {
        this.append("id", document.getInteger("id"))
                .append("typeVoie", document.getString("typeVoie"))
                .append("nomVoie", document.getString("nomVoie"))
                .append("codePostal", document.getString("codePostal"))
                .append("ville", document.getString("ville"));
    }

    public Adresse getMetier() {
        return new Adresse(
                this.getInteger("id"),
                this.getString("typeVoie"),
                this.getString("nomVoie"),
                this.getString("codePostal"),
                this.getString("ville")
        );
    }
}
