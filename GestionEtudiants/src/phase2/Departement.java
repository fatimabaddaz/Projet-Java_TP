package phase2;


public class Departement {

    public int id;
   public String intitule;
    public String chef;

    


    public Departement() {
    }

    public Departement(int id,String intitule, String chef) {
        this.intitule = intitule;
        this.chef = chef;
        this.id=id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }


    public String getChef() {
        return chef;
    }

    public void setChef(String chef) {
        this.chef = chef;
    }

   
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
