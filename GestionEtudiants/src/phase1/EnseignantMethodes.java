package phase1;

import java.util.ArrayList;
public class EnseignantMethodes {
	private static ArrayList<Enseignant> listeEnseignants = new ArrayList<>();
	
	public static void addEns(int idEns, String nomEns, String prenomEns, String emailEns, String gradeEns,String departementEns){
		
		Enseignant newEns = new Enseignant(idEns,nomEns,prenomEns,emailEns,gradeEns,departementEns);
		System.out.println("L'enseignant "+newEns.getNomEns()+" est bien ajouter");
		
		listeEnseignants.add(newEns);
	}
	
	public static void updateEns(int idEns, String nomEns, String prenomEns, String emailEns, String gradeEns,String departementEns){
		
		 for (Enseignant enseignant : listeEnseignants) {
	            if (enseignant.getIdEns() == idEns) {
	            	enseignant.setNomEns(nomEns);
	            	enseignant.setPrenomEns(prenomEns);
	            	enseignant.setEmailEns(emailEns);
	            	enseignant.setGradeEns(gradeEns);
	            	enseignant.setDepartementEns(departementEns);
	                System.out.println("Enseignant "+enseignant.getIdEns()+" modifié");
	                return;
	            }
	        }
		 System.out.println("L'enseignant souhaiter n'existe pas.");
	}
	
    public static void deleteEns(int idEns){
    	Enseignant enseignantASupprimer = null;
    	
        for (Enseignant enseignant : listeEnseignants) {
            if (enseignant.getIdEns() == idEns) {
            	enseignantASupprimer = enseignant;
                break;
            }
        }
        if (enseignantASupprimer != null) {
        	listeEnseignants.remove(enseignantASupprimer);
            System.out.println("Enseignant "+enseignantASupprimer.getIdEns()+" supprimé ");
        } else {
            System.out.println("l'enseignant souhaiter n'existe pas");
        }
	}
    
    public static void showEns() {
    	System.out.println("Liste de tous les enseignants :");
        for (Enseignant enseignant : listeEnseignants) {
            System.out.println(  "ID: "+enseignant.getIdEns()+"  Nom : " + enseignant.getNomEns() 
                               + ",    Prénom : " + enseignant.getPrenomEns()+",    Email : " + enseignant.getEmailEns()
                               +",    Grade : " + enseignant.getGradeEns()+ ",    Departement : " + enseignant.getDepartementEns());
            }

    }
    
    public static void main(String[] args) {
        
    	System.out.println("");
    	addEns(1, "Mehdi", "aitsaid", "mehdiaitsaid@gmail.com", "13", "GE-GM");
    	addEns(2, "Saad", "badi", "saadbadi@gmail.com", "11", "maths appliquéé");
    	System.out.println("");
    	showEns();
    	System.out.println("");
        updateEns(2, "Ghita", "Mengoub", "Gitaghita@gmail.com", "12", "GE-GM");
        System.out.println("");
        showEns();
        System.out.println("");
        deleteEns(1);
        System.out.println("");
        showEns();
        System.out.println("");
        addEns(1, "Jamila", "Naji", "Jamilajamila@gmail.com", "13", "Maths appliquée");
        System.out.println("");
        showEns();
    }
}
