import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class dbconnTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String url = "jdbc:mysql://localhost:3306/elections";
        String user = "root";
        String password = "DIAD2016";
             try {
            	 Class.forName("com.mysql.jdbc.Driver");
            	 Connection con = DriverManager.getConnection(url, user, password);
            	 System.out.println("Connection made");
            	 
            	 String q = "SELECT * from currentelections";
            	 
            	 Statement st = (Statement) con.createStatement();
            	 ResultSet rs = st.executeQuery(q);
            	 
            	 while(rs.next()){
            		 //int ElectionID = rs.getInt(1);
            		 String electionName = rs.getString(2);
            		 String candiadate1Name = rs.getString(3);
            		 String candiadate2Name = rs.getString(4);
            		 String candiadate3Name = rs.getString(5);
            		 int cand1Vote = rs.getInt(6);
            		 int cand2Vote = rs.getInt(7);
            		 int cand3Vote = rs.getInt(8);
            		 System.out.println(electionName + " -- " + candiadate1Name + " -- " + candiadate2Name + " -- " + candiadate3Name
            				 + " -- " + cand1Vote + " -- " + cand2Vote +  " -- " + cand3Vote );
            	
            		
            		 
            	 }
            	 
             } catch (Exception ex){
            	 
            	 System.out.println("Sql Exception");
            	 
            	 
             }
	}

}
