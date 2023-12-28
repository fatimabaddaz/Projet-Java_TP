package phase2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class FiliereMethods {
	

	

	public static void main (String [] args) {
		MenuofFiliere();
		
	  }
	
	public static void MenuofFiliere() {  
		System.out.println("Bienvenu dans l'espace filieres");
    System.out.println("choisir une des options suivantes");
    System.out.println("1: Pour ajouter une filiere");
     System.out.println("2: Pour modifier une filiere");
     System.out.println("3: Pour supprimer une filiere");
     System.out.println("4: Pour afficher les filieres");
    
   
     
     Scanner scan= new Scanner(System.in);
		System.out.println("saisir l'option ");
		int option =scan.nextInt();
		 switch(option) {
       case 1:
      	 addFiliere();
      	 showFilieres() ;
         break;
       case 2:
      	 
      	 updatefiliereById() ;
      	 showFilieres() ;
           break;
       case 3:
      	 deleteFiliereById() ;
      	 showFilieres() ;
           break;
       case 4:
      	 showFilieres() ;
           break;
       
   }}
		public static Filiere addFiliere() {
		        Filiere filiere = new Filiere();
		        Scanner myscan = new Scanner(System.in);

		        System.out.println("entrer l'id de la filiere");
		        int id_F = myscan.nextInt();
		       

		        myscan.nextLine();

		        System.out.println("entrer le titre de la filiere");
		        String intitule_F= myscan.nextLine();
		        

		        System.out.println("entrer l'id enseignant correspond a cette filiere");
		        int Id_Ens= myscan.nextInt();
		       

		        System.out.println("entrer l'id departement correspond a cette filiere");
		       int id = myscan.nextInt();
		       

		        
		       

		        try {
		            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioneducative","root","");
		            String sql = "INSERT INTO filiere (id_F ,intitule_F ,Id_Ens,id) VALUES (?, ?, ?,?)";
		            PreparedStatement pstmt = connection.prepareStatement(sql);
		            pstmt.setInt(1, id_F );
		            pstmt.setString(2, intitule_F);
		            pstmt.setInt(3,Id_Ens);
		            pstmt.setInt(4, id);
		           
		            pstmt.executeUpdate();
		            pstmt.close();
		            connection.close();
		            } 
		        catch (Exception e) {
		            e.printStackTrace();
		            }
		        System.out.println("votre filiere est  ajoutée avec succée");
		        return filiere;

		    } 
		 public static void updatefiliereById() {
			 Filiere filiere = new Filiere();;
		      Scanner myscan = new Scanner(System.in);
		      System.out.println("entrer l'id de la filiere");
		        int id_F = myscan.nextInt();
		       

		        myscan.nextLine();

		        System.out.println("entrer le titre de la filiere");
		        String intitule_F= myscan.nextLine();
		        

		        System.out.println("entrer l'id enseignant correspond a cette filiere");
		        int Id_Ens= myscan.nextInt();
		       

		        System.out.println("entrer l'id departement correspond a cette filiere");
		       int id = myscan.nextInt();
		     

		      
			    try {
			          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioneducative","root","");
			          String sql = "UPDATE filiere SET intitule_F=?,Id_Ens=?,id=? WHERE id_F = ?";
			          PreparedStatement pstmt = connection.prepareStatement(sql);
			          pstmt.setString(1, intitule_F);
			          pstmt.setInt(2, Id_Ens);
			          pstmt.setInt(3, id);
			          pstmt.setInt(4, id_F );
			         
			          
			          pstmt.executeUpdate();
			          pstmt.close();
			          connection.close();
			         
			    } 
			    catch (Exception e) {
			          e.printStackTrace();
			    }
			    System.out.println("votre filiere est modifié avec succée");
			    
			}
		
		public static void deleteFiliereById() {
		    Scanner myscan = new Scanner(System.in);
		      
		    System.out.println("entrer l'id du filiere ");
		    int id_F= myscan.nextInt();
		      
		   
		    
		    try {
		          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioneducative","root","");
		          String sql = "DELETE FROM  filiere WHERE id_F= ?";
		          PreparedStatement pstmt = connection.prepareStatement(sql);
		          
		          pstmt.setInt(1, id_F);
		         
		          pstmt.executeUpdate();
		          pstmt.close();
		          connection.close();
		         
		    } 
		    catch (Exception e) {
		          e.printStackTrace();
		    }
		    System.out.println(" la filiere est suprimé avec succée");
		}
		
		public static void showFilieres() {
			   
		      
			  System.out.println("voici la liste des filieres");
			      
			   
			    
			    try {
			          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioneducative","root","");
			          
			          Statement mystmt=connection.createStatement();
			          
			          ResultSet myrslt=mystmt.executeQuery("select *from filiere order by id_F");
			          while(myrslt.next()) {
			        	  System.out.println(myrslt.getInt("id_F")+" "+myrslt.getString("intitule_F")+"  "+myrslt.getString("Id_Ens")+" "+myrslt.getString("id"));
			          }
			         
			    } 
			    catch (Exception e) {
			          e.printStackTrace();
			    }
			    
			}
		

	}



