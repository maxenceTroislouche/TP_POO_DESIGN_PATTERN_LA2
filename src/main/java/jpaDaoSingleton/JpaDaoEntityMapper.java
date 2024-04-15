package jpaDaoSingleton;

import metier.Adresse;
import metier.Bien;
import metier.CategorieBien;
import metier.TypeBien;

public class JpaDaoEntityMapper {
    public static Object getEntityObject(Object object) {
        if (object.getClass() == Adresse.class) {
            return new jpaDto.E_Adresse((Adresse) object);
        } else if (object.getClass() == Bien.class) {
            return new jpaDto.E_Bien((Bien) object);
        } else if (object.getClass() == CategorieBien.class) {
            return new jpaDto.E_CategorieBien((CategorieBien) object);
        } else if (object.getClass() == TypeBien.class) {
            return new jpaDto.E_TypeBien((TypeBien) object);
        } else {
            throw new IllegalArgumentException("Unknown object type");
        }
    }
}
