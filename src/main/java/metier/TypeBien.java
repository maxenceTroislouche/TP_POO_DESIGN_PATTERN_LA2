package metier;

public class TypeBien {
    private final int id;
    private String lib;

    public TypeBien(int id, String lib) {
        this.id = id;
        this.lib = lib;
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

    @Override
    public String toString() {
        return "TypeBien{" +
                "id=" + id +
                ", lib='" + lib + '\'' +
                '}';
    }
}
