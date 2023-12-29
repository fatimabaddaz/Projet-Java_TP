package phase2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class NoteMethods {
	public static void main (String [] args) {
		 
		MenuofNotes();
	}
		public static void MenuofNotes() { 
			System.out.println("Bienvenu dans l'espace Notes");
	    System.out.println("choisir une des options suivantes");
	    System.out.println("1: Pour ajouter une note d'un étudiant");
	     System.out.println("2: Pour modifier une note d'un étudiant");
	     System.out.println("3: Pour supprimer une note d'un étudiant");
	     System.out.println("4: Pour afficher les notes");
	    
	   
	     
	     Scanner scan= new Scanner(System.in);
			System.out.println("saisir l'option ");
			int option =scan.nextInt();
			 switch(option) {
	       case 1:
	    	   addNote();
	         break;
	       case 2:
	      	 
	    	   updateNoteById() ;
	    	   showNote() ;
	           break;
	       case 3:
	    	   deletenoteById();
	    	   showNote();
	           break;
	       case 4:
	    	   showNote() ;
	           break;
	       
	   }}
		
		public static Note addNote() {
		        Note note1 = new Note();
		        Scanner myscan = new Scanner(System.in);

		        System.out.println("entrer la note");
		       float note = myscan.nextFloat();
		        myscan.nextLine();
	             System.out.println("entrer l'id du l'etudiant ");
		        int id_E= myscan.nextInt();
		        System.out.println("entrer l'id de Module correspond a cette note");
		       int id_M = myscan.nextInt();
		       

		        
		       

		        try {
		            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioneducative","root","");
		            String sql = "INSERT INTO note (note ,id_E,id_M) VALUES ( ?, ?,?)";
		            PreparedStatement pstmt = connection.prepareStatement(sql);
		            pstmt.setFloat(1,note );
		            pstmt.setInt(2,id_E);
		            pstmt.setInt(3, id_M);
		           
		            pstmt.executeUpdate();
		            pstmt.close();
		            connection.close();
		            } 
		        catch (Exception e) {
		            e.printStackTrace();
		            }
		        System.out.println("votre NOTEest  ajoutée avec succée");
		        return note1;

		    } 
		 public static void updateNoteById() {
			 Note note1 = new Note();
		      Scanner myscan = new Scanner(System.in);
		      System.out.println("entrer l'id du etudiant");
		        int id_E = myscan.nextInt();
		       

		        myscan.nextLine();

		        System.out.println("entrer la note");
		        float note= myscan.nextFloat();
		        
		        System.out.println("entrer l'id du module correspond a cette note");
		           int id_M = myscan.nextInt();
		        
		       

		        
		     

		      
			    try {
			          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioneducative","root","");
			          String sql = "UPDATE note SET note=? WHERE id_E = ? and id_M=?";
			          PreparedStatement pstmt = connection.prepareStatement(sql);
			          pstmt.setFloat(1, note);
			          pstmt.setInt(2, id_E);
			          pstmt.setInt(3, id_M);
			         
			         
			          
			          pstmt.executeUpdate();
			          pstmt.close();
			          connection.close();
			         
			    } 
			    catch (Exception e) {
			          e.printStackTrace();
			    }
			    System.out.println("votre NOTE est modifié avec succée");
			    
			}
		
		public static void deletenoteById() {
		    Scanner myscan = new Scanner(System.in);
		      
		    System.out.println("entrer l'id du etudiant ");
		    int id_E= myscan.nextInt();
		    System.out.println("entrer l'id du Module ");
		    int id_M= myscan.nextInt();
		      
		   
		    
		    try {
		          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioneducative","root","");
		          String sql = "DELETE FROM  note WHERE id_E= ? and id_M=?";
		          PreparedStatement pstmt = connection.prepareStatement(sql);
		          
		          pstmt.setInt(1, id_E);
		          pstmt.setInt(2, id_M);
		          pstmt.executeUpdate();
		          pstmt.close();
		          connection.close();
		         
		    } 
		    catch (Exception e) {
		          e.printStackTrace();
		    }
		    System.out.println(" LA NOTE est suprimé avec succée");
		}
		 public static void showNote() {
			   
		      
			  System.out.println("voici la liste des notes");
			      
			   
			    
			    try {
			          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioneducative","root","");
			          
			          Statement mystmt=connection.createStatement();
			          
			          ResultSet myrslt=mystmt.executeQuery("select *from note order by id_E");
			          while(myrslt.next()) {
			        	  System.out.println(myrslt.getInt("id_E")+"  // "+myrslt.getFloat("note")+" //    "+myrslt.getInt("Id_M"));
			          }
			         
			    } 
			    catch (Exception e) {
			          e.printStackTrace();
			    }
			    
			}
		 
		 
			}
