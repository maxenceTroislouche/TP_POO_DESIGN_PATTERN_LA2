package jsonDto;

import metier.TypeBien;
import org.bson.Document;

public class TypeBienDocument extends Document {

    public TypeBienDocument(TypeBien typeBien) {
        this.append("id", typeBien.getId())
                .append("lib", typeBien.getLib());

    }

    public TypeBienDocument(Document document) {
        this.append("id", document.getInteger("id"))
                .append("lib", document.getString("lib"));
    }

    public TypeBien getMetier() {
        return new TypeBien(
                this.getInteger("id"),
                this.getString("lib")
        );
    }

}
