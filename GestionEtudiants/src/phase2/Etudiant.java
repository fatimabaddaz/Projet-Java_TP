package phase2;
public class Etudiant {

    private int id_E;
    private String nom;
    private String prenom;
    private String email_E;
    private int apogee;
    private int id_F;
   



    public Etudiant() {
    }

    public Etudiant(int id_E,String nom, String prenom, String email_E, int apogee,int id_F ) {
    	this.id_E=id_E;
        this.nom = nom;
        this.prenom = prenom;
        this.email_E = email_E;
        this.apogee = apogee;
        this.id_F = id_F;
    }
    public int getid_E() {
        return id_E;
    }

    public void setId(int id_E) {
        this.id_E = id_E;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email_E;
    }

    public void setEmail(String email_E) {
        this.email_E = email_E;
    }

    public int getApogee() {
        return apogee;
    }

    public void setApogee(int apogee) {
        this.apogee = apogee;
    }

    public int getid_F() {
        return id_F;
    }

    public void setId_F(int id_F) {
        this.id_F = id_F;
    

    
    }}
