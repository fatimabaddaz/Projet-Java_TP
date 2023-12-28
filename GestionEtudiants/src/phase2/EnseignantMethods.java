package phase2;
import java.util.Scanner;

import phase2.Enseignant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class EnseignantMethods {
	
	public static void main (String [] args) {
		MenuofEtudiants();
		
	  }    
		      
	 public static void MenuofEtudiants() {  
		 System.out.println("Bienvenu dans l'espace Enseignants");
     System.out.println("choisir une des options suivantes");
     System.out.println("1: Pour ajouter un enseignat");
      System.out.println("2: Pour modifier un enseignat");
      System.out.println("3: Pour supprimer un enseignat");
      System.out.println("4: Pour afficher les enseignats");
     
    
      
      Scanner scan= new Scanner(System.in);
		System.out.println("saisir l'option ");
		int option =scan.nextInt();
		 switch(option) {
        case 1:
       	 createEnseignant();
       	 showEnseignant();
          break;
        case 2:
       	 
       	 updateEnseignantById();
       	 showEnseignant();
            break;
        case 3:
       	 deleteEnseignantById();
       	 showEnseignant();
            break;
        case 4:
       	 showEnseignant();
            break;
        
    }}
				
			
		  
	   
	  
	  


		    public static Enseignant createEnseignant() {
		        Enseignant enseignant = new Enseignant();
		        Scanner myscan = new Scanner(System.in);

		        System.out.println("entrer l'id de léenseignat ");
		        int Id_Ens = myscan.nextInt();
		       

		        myscan.nextLine();

		        System.out.println("entrer le nom de l'enseignant");
		        String Nom_Ens = myscan.nextLine();
		        

		        System.out.println("entrer le prénom de l'enseignant");
		        String Prenom_Ens = myscan.nextLine();
		       

		        System.out.println("entrer l'emai de l'enseignant");
		        String email = myscan.nextLine();
		       

		        System.out.println("entrer la grade de l'enseignant");
		        String grade = myscan.nextLine();
		       

		        System.out.println("entrer l'id de département correspond l'enseignant");
		        int Id_dept = myscan.nextInt();
		       

		        try {
		            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioneducative","root","");
		            String sql = "INSERT INTO enseignant (Id_Ens,Nom_Ens,Prenom_Ens,email,grade,Id_dept) VALUES (?, ?, ?,?,?,?)";
		            PreparedStatement pstmt = connection.prepareStatement(sql);
		            pstmt.setInt(1, Id_Ens);
		            pstmt.setString(2, Nom_Ens);
		            pstmt.setString(3, Prenom_Ens);
		            pstmt.setString(4, email);
		            pstmt.setString(5, grade);
		            pstmt.setInt(6, Id_dept);

		            pstmt.executeUpdate();
		            pstmt.close();
		            connection.close();
		            } 
		        catch (Exception e) {
		            e.printStackTrace();
		            }
		        System.out.println("votre enseignant est ajouté avec succée");
		        return enseignant;

		    }
		    
		    

	 public static void updateEnseignantById() {
		  Enseignant enseignant = new Enseignant();
	      Scanner myscan = new Scanner(System.in);

	      System.out.println("entrer l'id de léenseignat ");
	      int Id_Ens = myscan.nextInt();
	     

	      myscan.nextLine();

	      System.out.println("entrer le nom de l'enseignant");
	      String Nom_Ens = myscan.nextLine();
	      

	      System.out.println("entrer le prénom de l'enseignant");
	      String Prenom_Ens = myscan.nextLine();
	     

	      System.out.println("entrer l'emai de l'enseignant");
	      String email = myscan.nextLine();
	     

	      System.out.println("entrer la grade de l'enseignant");
	      String grade = myscan.nextLine();
	     

	      System.out.println("entrer l'id de département correspond l'enseignant");
	      int Id_dept = myscan.nextInt();
		    try {
		          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioneducative","root","");
		          String sql = "UPDATE enseignant SET Nom_Ens=?,Prenom_Ens=?,email=?,grade=?,Id_dept=? WHERE Id_Ens = ?";
		          PreparedStatement pstmt = connection.prepareStatement(sql);
		          pstmt.setString(1, Nom_Ens);
		          pstmt.setString(2, Prenom_Ens);
		          pstmt.setString(3, email);
		          pstmt.setString(4, grade);
		          pstmt.setInt(5,Id_dept );
		          pstmt.setInt(6,Id_Ens );
		          
		          pstmt.executeUpdate();
		          pstmt.close();
		          connection.close();
		         
		    } 
		    catch (Exception e) {
		          e.printStackTrace();
		    }
		    System.out.println("votre enseignant est modifié avec succée");
		    
		}
	 
	 

	 public static void deleteEnseignantById() {
		    Scanner myscan = new Scanner(System.in);
		      
		    System.out.println("entrer l'id ");
		    int id_Ens = myscan.nextInt();
		      
		   
		    
		    try {
		          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioneducative","root","");
		          String sql = "DELETE FROM  enseignant  WHERE id_Ens= ?";
		          PreparedStatement pstmt = connection.prepareStatement(sql);
		          
		          pstmt.setInt(1, id_Ens);
		         
		          pstmt.executeUpdate();
		          pstmt.close();
		          connection.close();
		         
		    } 
		    catch (Exception e) {
		          e.printStackTrace();
		    }
		    System.out.println("votre enseignant est suprimé avec succée");
	 }
	 
	 
	 
	  public static void showEnseignant() {
		   
		      
		  System.out.println("voici la liste des enseignants");
		      
		   
		    
		    try {
		          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioneducative","root","");
		          
		          Statement mystmt=connection.createStatement();
		          
		          ResultSet myrslt=mystmt.executeQuery("select *from enseignant order by Id_Ens");
		          while(myrslt.next()) 
		        	  System.out.println(myrslt.getInt("Id_Ens")+" "+myrslt.getString("Nom_Ens")+"  "+myrslt.getString("Prenom_Ens")+" "+myrslt.getString("email")+" "+myrslt.getString("grade")+" "+myrslt.getInt("Id_dept"));
		          }
		         
		     
		    catch (Exception e) {
		          e.printStackTrace();
		    }
		    
		}
		    
		    
	  }
	  

	  
	
	  




