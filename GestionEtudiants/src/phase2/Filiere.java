package phase2;
import java.util.ArrayList;
public class Filiere {
	

	

	    private int id_F;
	    private String intitule_F;
	    private int Id_Ens;
	    private int id;

	   

	    public Filiere() {
	    }

	    public Filiere(int id_F,String intitule_F, int Id_Ens, int id) {
	        this. id_F =  id_F;
	        this.intitule_F =intitule_F;
	        this.Id_Ens =  Id_Ens;
	        this.id =id;
	    }
	    public int getid_F() {
	        return id_F;
	    }

	    public void setid_F(int id_F) {
	        this.id_F = id_F;
	    }
	    public String getIntitule_F() {
	        return intitule_F;
	    }

	    public void setIntitule_F(String intitule_F) {
	        this.intitule_F = intitule_F;
	    }

	   
	    public int getId_Ens() {
	        return Id_Ens;
	    }

	    public void setId_Ens(int Id_Ens) {
	        this.Id_Ens = Id_Ens;
	    }

	   

	   

	    public int getid() {
	        return id;
	    }

	    public void setid(int id) {
	        this.id = id;
	    }
	}


