package phase2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class ModuleNote {
	public static void main (String [] args) {


		MenuofModule();
	

	
		
	}
    public static void MenuofModule(){
		  System.out.println("Bienvenu dans l'espace Modules");
		    System.out.println("choisir une des options suivantes");
		    System.out.println("1: Pour ajouter  un module");
		     System.out.println("2: Pour modifier un module");
		     System.out.println("3: Pour supprimer un module");
		     System.out.println("4: Pour afficher les modules");
		    
		   
		     
		     Scanner scan= new Scanner(System.in);
				System.out.println("saisir l'option ");
				int option =scan.nextInt();
				 switch(option) {
		       case 1:
		    	   addModule();
		    	   showModule() ;
		         break;
		       case 2:
		      	 
		    	   updateModuleById() ;
		    	   showModule() ;
		           break;
		       case 3:
		    	   deleteModuleeById();
		    	   showModule();
		           break;
		       case 4:
		    	   showModule() ;
		           break;
		       
		   }}





		public static Module addModule() {
		        Module module = new Module();
		        Scanner myscan = new Scanner(System.in);

		        System.out.println("entrer l'id du module");
		        int id_M = myscan.nextInt();
		       

		        myscan.nextLine();

		        System.out.println("entrer le titre du module");
		        String intitule_M= myscan.nextLine();
		        

		        System.out.println("entrer l'id enseignant correspond a ce module");
		        int Id_Ens= myscan.nextInt();
		       

		        System.out.println("entrer l'id de la filiere correspond a ce module");
		       int id_F = myscan.nextInt();
		       

		        
		       

		        try {
		            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioneducative","root","");
		            String sql = "INSERT INTO module (id_M ,intitule_M ,Id_Ens,id_F) VALUES (?, ?, ?,?)";
		            PreparedStatement pstmt = connection.prepareStatement(sql);
		            pstmt.setInt(1, id_M );
		            pstmt.setString(2, intitule_M);
		            pstmt.setInt(3,Id_Ens);
		            pstmt.setInt(4, id_F);
		           
		            pstmt.executeUpdate();
		            pstmt.close();
		            connection.close();
		            } 
		        catch (Exception e) {
		            e.printStackTrace();
		            }
		        System.out.println("votre MODULE est  ajoutée avec succée");
		        return module;

		    } 
		 public static void updateModuleById() {
			 Module module = new Module();
		      Scanner myscan = new Scanner(System.in);
		      System.out.println("entrer l'id du module");
		        int id_M = myscan.nextInt();
		       

		        myscan.nextLine();

		        System.out.println("entrer le titre du module");
		        String intitule_M= myscan.nextLine();
		        

		        System.out.println("entrer l'id enseignant correspond a ce module");
		        int Id_Ens= myscan.nextInt();
		       

		        System.out.println("entrer l'id de la filiere correspond a ce module");
		       int id_F = myscan.nextInt();
		     

		      
			    try {
			          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioneducative","root","");
			          String sql = "UPDATE module SET intitule_M=?,Id_Ens=?,id_F=? WHERE id_M = ?";
			          PreparedStatement pstmt = connection.prepareStatement(sql);
			          pstmt.setString(1, intitule_M);
			          pstmt.setInt(2, Id_Ens);
			          pstmt.setInt(3, id_F);
			          pstmt.setInt(4, id_M );
			         
			          
			          pstmt.executeUpdate();
			          pstmt.close();
			          connection.close();
			         
			    } 
			    catch (Exception e) {
			          e.printStackTrace();
			    }
			    System.out.println("votre Module est modifié avec succée");
			    
			}
		
	public static void deleteModuleeById() {
		    Scanner myscan = new Scanner(System.in);
		      
		    System.out.println("entrer l'id du module ");
		    int id_M= myscan.nextInt();
		      
		   
		    
		    try {
		          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioneducative","root","");
		          String sql = "DELETE FROM  module WHERE id_M= ?";
		          PreparedStatement pstmt = connection.prepareStatement(sql);
		          
		          pstmt.setInt(1, id_M);
		         
		          pstmt.executeUpdate();
		          pstmt.close();
		          connection.close();
		         
		    } 
		    catch (Exception e) {
		          e.printStackTrace();
		    }
		    System.out.println(" le module est suprimé avec succée");
		}
		 public static void showModule() {
			   
		      
			  System.out.println("voici la liste des modules");
			      
			   
			    
			    try {
			          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioneducative","root","");
			          
			          Statement mystmt=connection.createStatement();
			          
			          ResultSet myrslt=mystmt.executeQuery("select *from module order by id_M");
			          while(myrslt.next()) {
			        	  System.out.println(myrslt.getInt("id_M")+" "+myrslt.getString("intitule_M")+"  "+myrslt.getString("Id_Ens")+" "+myrslt.getString("id_F"));
			          }
			         
			    } 
			    catch (Exception e) {
			          e.printStackTrace();
			    }
			    
			}
		 
}
		
		
		





