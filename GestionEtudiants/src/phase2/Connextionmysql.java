package phase2;
import java.sql.*;



public class Connextionmysql {
	public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/gestioneducative";
        String user = "root";
        String pwd = "";
        try {
            Connection cx = DriverManager.getConnection(url, user, pwd);
            System.out.println("Good Connection");
            Statement myStmt=cx.createStatement();
            
            		
            
            
        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }
}