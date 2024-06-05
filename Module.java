package Cours;

public class Module {
    private int id;
    private String nomModule;
    public Module(int id, String nomModule) {
        this.id = id;
        this.nomModule = nomModule;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNomModule() {
        return nomModule;
    }
    public void setNomModule(String nomModule) {
        this.nomModule = nomModule;
    }

}
