package phase2;

public class Module {
    private int id_M;
    private String intitule_M;
    private int Id_Ens;
    private int id_F;

    public Module() {
    }

    public Module(int id_M,String intitule, int Id_Ens, int id_F) {
        this.id_M=id_M;
    	this.intitule_M = intitule_M;
        this.Id_Ens = Id_Ens;
        this.id_F = id_F;
    }

    public String getIntitule_M() {
        return intitule_M;
    }

    public void setIntitule(String intitule_M) {
        this.intitule_M = intitule_M;
    }

    public int getId_Ens() {
        return Id_Ens;
    }

    public void setId_Ens(int Id_Ens) {
        this.Id_Ens = Id_Ens;
    }

    public int getid_F() {
        return id_F;
    }

    public void setid_F(int id_F) {
        this.id_F = id_F;
    }
}

