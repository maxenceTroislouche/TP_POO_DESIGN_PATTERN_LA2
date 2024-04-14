package jsonDto;

import metier.CategorieBien;
import org.bson.Document;

public class CategorieBienDocument extends Document {
    public CategorieBienDocument(CategorieBien categorieBien) {
        this.append("id", categorieBien.getId())
                .append("lib", categorieBien.getLib());
    }

    public CategorieBienDocument(Document document) {
        this.append("id", document.getInteger("id"))
                .append("lib", document.getString("lib"));
    }

    public CategorieBien getMetier() {
        return new CategorieBien(
                this.getInteger("id"),
                this.getString("lib")
        );
    }
}
