package phase2;


import java.util.Scanner;

import phase2.Departement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DepartementMéthode {
  public static void main (String [] args) {
	  
	  MenuofDepartement();
	
	
  }
  public static void MenuofDepartement() { 
	  System.out.println("Bienvenu dans l'espace Departement");
  System.out.println("choisir une des options suivantes");
  System.out.println("1: Pour ajouter un département");
   System.out.println("2: Pour modifier un département");
   System.out.println("3: Pour supprimer un département");
   System.out.println("4: Pour afficher les départements");
 
   
   Scanner scan= new Scanner(System.in);
	System.out.println("saisir l'option ");
	int option =scan.nextInt();
	 switch(option) {
     case 1:
    	 createDepartement();
    	 showDepartement();
       break;
     case 2:
    	 updateDepartementById();
    	 showDepartement();
         break;
     case 3:
    	 deleteDepartementById();
    	 showDepartement();
    	 
         break;
     case 4:
    	 showDepartement();
         break;
     
 }}
  
  public static Departement createDepartement() {
      Departement departement=new Departement();
	        Scanner myscan = new Scanner(System.in);
	        
	        System.out.println("entrer l'id du département ");
	        int id = myscan.nextInt();
	        
	        myscan.nextLine();
	        
	        System.out.println("entrer le titre du département");
	        String intitule = myscan.nextLine();
	        
	        System.out.println("entrer le chef de département");
	        String chef = myscan.nextLine();
	        

	        try {
	            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioneducative","root","");
	            String sql = "INSERT INTO departement (id,intitule, chef) VALUES (?, ?, ?)";
	            PreparedStatement pstmt = connection.prepareStatement(sql);
	            pstmt.setInt(1, id);
	            pstmt.setString(2, intitule);
	            pstmt.setString(3, chef);
	            pstmt.executeUpdate();
	            pstmt.close();
	            connection.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        System.out.println("votre departement est ajouté avec succée");
	        return departement;
	        
	        
	    }
  public static void updateDepartementById() {
	    Scanner myscan = new Scanner(System.in);
	      
	    System.out.println("entrer l'id du département ");
	    int id = myscan.nextInt();
	      
	    myscan.nextLine();
	      
	    System.out.println("entrer le titre du département");
	    String intitule = myscan.nextLine();
	      
	    System.out.println("entrer le chef du département");
	    String chef = myscan.nextLine(); 
	    try {
	          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioneducative","root","");
	          String sql = "UPDATE departement SET intitule = ?, chef = ? WHERE id = ?";
	          PreparedStatement pstmt = connection.prepareStatement(sql);
	          pstmt.setString(1, intitule);
	          pstmt.setString(2, chef);
	          pstmt.setInt(3, id);
	         
	          pstmt.executeUpdate();
	          pstmt.close();
	          connection.close();
	         
	    } 
	    catch (Exception e) {
	          e.printStackTrace();
	    }
	    System.out.println("votre departement est modifié avec succée");
	    
	}
  public static void deleteDepartementById() {
	    Scanner myscan = new Scanner(System.in);
	      
	    System.out.println("entrer l'id du département");
	    int id = myscan.nextInt();
	      
	   
	    
	    try {
	          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioneducative","root","");
	          String sql = "DELETE FROM  departement  WHERE id = ?";
	          PreparedStatement pstmt = connection.prepareStatement(sql);
	          
	          pstmt.setInt(1, id);
	         
	          pstmt.executeUpdate();
	          pstmt.close();
	          connection.close();
	         
	    } 
	    catch (Exception e) {
	          e.printStackTrace();
	    }
	    System.out.println("votre departement est suprimé avec succée");
	}
  public static void showDepartement() {
	   
	      
	  System.out.println("voici la liste des département");
	      
	   
	    
	    try {
	          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioneducative","root","");
	          
	          Statement mystmt=connection.createStatement();
	          
	          ResultSet myrslt=mystmt.executeQuery("select *from departement order by id");
	          while(myrslt.next()) {
	        	  System.out.println(myrslt.getInt("id")+" || "+myrslt.getString("intitule")+" ||"+myrslt.getString("chef"));
	          }
	         
	    } 
	    catch (Exception e) {
	          e.printStackTrace();
	    }
	    
	}

  
	  
  }
