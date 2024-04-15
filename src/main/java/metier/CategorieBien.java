package metier;

public class CategorieBien {
    private final int id;
    private String lib;

    public CategorieBien(int id, String lib) {
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
        return "CategorieBien{" +
                "id=" + id +
                ", lib='" + lib + '\'' +
                '}';
    }
}
