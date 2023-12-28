package phase2;

import java.util.Scanner;

public class Main {
	public static void main (String [] args) {
		  
	    System.out.println("choisir une des options suivantes");
	    System.out.println("1: Pour gérer les départements");
	    System.out.println("2: Pour gérer les enseignants");
	    System.out.println("3: Pour gérer les filieres");
	    System.out.println("4: Pour gérer les étudiants");
	    System.out.println("5: Pour gérer les modules");
	    System.out.println("6: Pour gérer les notes");
	   
	     
	     Scanner scan= new Scanner(System.in);
			System.out.println("saisir l'option ");
			int option =scan.nextInt();
			 switch(option) {
	       case 1:
	    	   DepartementMéthode.MenuofDepartement();
	         break;
	       case 2:
	      	 
	    	   EnseignantMethods.MenuofEtudiants();
	           break;
	       case 3:
	    	   FiliereMethods.MenuofFiliere();
	           break;
	       case 4:
	    	   EtudiantMethods.MenuofEtudiant();
	           break;
	       case 5:
	    	   ModuleNote.MenuofModule();
	    	   break;
	       case 6:
	    	   NoteMethods.MenuofNotes();
	       
	   }
		
	}
}
