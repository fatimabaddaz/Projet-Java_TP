package phase2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class EtudiantMethods {



public static void main (String [] args) {
	MenuofEtudiant();
	
}
	public static void MenuofEtudiant() {	 
		System.out.println("Bienvenu dans l'espace étudiants");
    System.out.println("choisir une des options suivantes");
    System.out.println("1: Pour ajouter une étudiant");
     System.out.println("2: Pour modifier une étudiant");
     System.out.println("3: Pour supprimer un étudiant");
     System.out.println("4: Pour afficher les étudiants");
    
   
     
     Scanner scan= new Scanner(System.in);
		System.out.println("saisir l'option ");
		int option =scan.nextInt();
		 switch(option) {
       case 1:
    	   addEtudiant();
    	   showEtudiants() ;
         break;
       case 2:
      	 
    	   updateEtudianttById() ;
    	   showEtudiants() ;
           break;
       case 3:
    	   deleteEtudiantById();
    	   showEtudiants() ;
           break;
       case 4:
    	   showEtudiants() ;
           break;
       
   }}


public static Etudiant addEtudiant() {
	        Etudiant etudiant = new Etudiant();
	        Scanner myscan = new Scanner(System.in);

	        System.out.println("entrer l'id de l'etudiant");
	        int id_E = myscan.nextInt();
	       

	        myscan.nextLine();

	        System.out.println("entrer le nom de l'etudiant");
	        String nom = myscan.nextLine();
	        

	        System.out.println("entrer le prénom de l'etudiant");
	        String prenom = myscan.nextLine();
	       

	        System.out.println("entrer l'emai de l'etudiant");
	        String email_E = myscan.nextLine();
	       

	        System.out.println("entrer le code apogee de l'etudiant");
	        String apogee= myscan.nextLine();
	       

	        System.out.println("entrer l'id de la filiere");
	        int Id_F = myscan.nextInt();
	       

	        try {
	            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioneducative","root","");
	            String sql = "INSERT INTO etudiant (id_E , nom ,prenom,email_E,apogee,Id_F) VALUES (?, ?, ?,?,?,?)";
	            PreparedStatement pstmt = connection.prepareStatement(sql);
	            pstmt.setInt(1, id_E);
	            pstmt.setString(2, nom);
	            pstmt.setString(3, prenom);
	            pstmt.setString(4, email_E);
	            pstmt.setString(5, apogee);
	            pstmt.setInt(6, Id_F);

	            pstmt.executeUpdate();
	            pstmt.close();
	            connection.close();
	            } 
	        catch (Exception e) {
	            e.printStackTrace();
	            }
	        System.out.println("vous etes ajouté avec succée");
	        return etudiant;

	    }
	public static void updateEtudianttById() {
		Etudiant etudiant = new Etudiant();
	      Scanner myscan = new Scanner(System.in);

	      System.out.println("entrer l'id de l'etudiant");
	        int id_E = myscan.nextInt();
	       

	        myscan.nextLine();

	        System.out.println("entrer le nom de l'etudiant");
	        String nom = myscan.nextLine();
	        

	        System.out.println("entrer le prénom de l'etudiant");
	        String prenom = myscan.nextLine();
	       

	        System.out.println("entrer l'emai de l'etudiant");
	        String email_E = myscan.nextLine();
	       

	        System.out.println("entrer le code apogee de l'etudiant");
	        String apogee= myscan.nextLine();
	       

	        System.out.println("entrer l'id de la filiere");
	        int Id_F = myscan.nextInt();
	     

	      
		    try {
		          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioneducative","root","");
		          String sql = "UPDATE etudiant SET nom=?,prenom=?,email_E=?,apogee=?,Id_F=? WHERE id_E = ?";
		          PreparedStatement pstmt = connection.prepareStatement(sql);
		          pstmt.setString(1, nom);
		          pstmt.setString(2, prenom);
		          pstmt.setString(3, email_E);
		          pstmt.setString(4, apogee);
		          pstmt.setInt(5,Id_F);
		          pstmt.setInt(6,id_E );
		          
		          pstmt.executeUpdate();
		          pstmt.close();
		          connection.close();
		         
		    } 
		    catch (Exception e) {
		          e.printStackTrace();
		    }
		    System.out.println("votre etudiant est modifié avec succée");
		    
		}
	
	public static void deleteEtudiantById() {
	    Scanner myscan = new Scanner(System.in);
	      
	    System.out.println("entrer l'id ");
	    int id_E = myscan.nextInt();
	      
	   
	    
	    try {
	          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioneducative","root","");
	          String sql = "DELETE FROM  etudiant WHERE id_E= ?";
	          PreparedStatement pstmt = connection.prepareStatement(sql);
	          
	          pstmt.setInt(1, id_E);
	         
	          pstmt.executeUpdate();
	          pstmt.close();
	          connection.close();
	         
	    } 
	    catch (Exception e) {
	          e.printStackTrace();
	    }
	    System.out.println(" l'étudiant(e) est suprimé avec succée");
	}
	
	public static void showEtudiants() {
		   
	      
		  System.out.println("voici la liste des etudiants");
		      
		   
		    
		    try {
		          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioneducative","root","");
		          
		          Statement mystmt=connection.createStatement();
		          
		          ResultSet myrslt=mystmt.executeQuery("select *from etudiant order by id_E");
		          while(myrslt.next()) {
		        	  System.out.println(myrslt.getInt("id_E")+" "+myrslt.getString("nom")+"  "+myrslt.getString("prenom")+" "+myrslt.getString("email_E")+" "+myrslt.getString("apogee")+" "+myrslt.getInt("Id_F"));
		          }
		         
		    } 
		    catch (Exception e) {
		          e.printStackTrace();
		    }
		    
		}
	
	
	
	
}



