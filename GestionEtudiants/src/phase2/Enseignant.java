package phase2;

public class Enseignant {

    private int Id_Ens;
    private String Nom_Ens;
    private String Prenom_Ens;
    private String email;
    private String grade;
    private int Id_dept;
   


    public Enseignant() {
    }

    public Enseignant(int Id_Ens, String Nom_Ens, String Prenom_Ens, String email, String grade, int Id_dept) {
    	this.Id_Ens = Id_Ens;
    	this.Nom_Ens = Nom_Ens;
        this.Prenom_Ens = Prenom_Ens;
        this.email = email;
        this.grade = grade;
        this.Id_dept = Id_dept;
    }
    public int getId_Ens() {
        return Id_Ens;
    }

    public void setId_Ens( int Id_Ens) {
        this.Id_Ens = Id_Ens;
    }
    public String getNom() {
        return Nom_Ens;
    }

    public void setNom_Ens(String Nom_Ens) {
        this.Nom_Ens =Nom_Ens;
    }

    public String getPrenom() {
        return Prenom_Ens;
    }

    public void setPrenom_Ens(String Prenom_Ens) {
        this.Prenom_Ens= Prenom_Ens;
    }

    public String getEmail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getGrade() {
        return grade;
    }

    public void setgrade(String grade) {
        this.grade = grade;
    }

    
    public int getId_dept() {
        return Id_dept;
    }

    public void setId_dept( int Id_dept) {
        this.Id_dept = Id_dept;
    }

    
}

   


