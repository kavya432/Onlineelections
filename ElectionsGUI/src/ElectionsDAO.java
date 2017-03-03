import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

import com.mysql.jdbc.Statement;

public class ElectionsDAO {
	//public static ListItemDAO dao;
	//public static ListItemDAO dao;
	Connection con = null;

	
	public ElectionsDAO(){
		makeConnection();
	}
		
	
    public void makeConnection(){
    	
    		// TODO Auto-generated method stub
            String url = "jdbc:mysql://localhost:3306/elections";
            String user = "root";
            String password = "DIAD2016";
                 try {
                	 Class.forName("com.mysql.jdbc.Driver");
                	 con = DriverManager.getConnection(url, user, password);
                	 System.out.println("Connection made");
                               	 
                 } catch (Exception ex){
                	 
                	 System.out.println("Sql Exception");
                	 
                 }
    	}
                	 
       public ArrayList<Elections> getAllElections(){
    	   ArrayList<Elections> allElections = new ArrayList<Elections>();
    			// TODO Auto-generated method stub
    	            	            	 
    	            	 String q = "SELECT * from currentelections";
    	            	 try{
    	            	 Statement st = (Statement) con.createStatement();
    	            	 ResultSet rs = st.executeQuery(q);
    	            	 
    	            	 while(rs.next()){
    	            		 //String id = rs.getString(1);
    	            		 int ElectionID = rs.getInt(1);
    	            		 String electionName = rs.getString(2);
    	            		 String candidate1Name = rs.getString(3);
    	            		 String candiadate2Name = rs.getString(4);
    	            		 String candiadate3Name = rs.getString(5);
    	            		 int cand1Vote = rs.getInt(6);
    	            		 int cand2Vote = rs.getInt(7);
    	            		 int cand3Vote = rs.getInt(8);
    	            		 Elections tempElections = new Elections(electionName, candidate1Name, candiadate2Name, candiadate3Name, cand1Vote, cand2Vote, cand3Vote );
    	            		 allElections.add(tempElections);
    	            		 System.out.println(electionName + " -- " + candidate1Name + " -- " + candiadate2Name + " -- " + candiadate3Name
    	            				 + " -- " + cand1Vote + " -- " + cand2Vote +  " -- " + cand3Vote );
    	            		 //System.out.println(id + " -- " + store + " -- " + item);
    	            		 
    	            		 
    	            	 }
    	            	// return allElections;
    	            	 
    	             } catch (SQLException ex){
    	            	 
    	            	 System.out.println("Sql Exception");
    	            	     	   
       }
    	            	 return allElections;
    }
       
       public HashSet<String> getUniqueElectionName(){
    	   ArrayList<String> allElectionName = new ArrayList<String>();
    	   for(Elections p : getAllElections()){
    		   allElectionName.add(p.getElectionName());
        	   //System.out.println("in getUniqueElectionName"+p.getElectionName());

    	   }
    	   HashSet<String> uniqueElectionname = new HashSet<String>(allElectionName);
    	   return uniqueElectionname;
       }
       
       
       public ArrayList<String> getCurrentElectionsFromTable(String s){
    	   ArrayList<String> electionsFromSelectedTable = new ArrayList<String>();
    	   for(Elections p : getAllElections()){
    		   if(p.getElectionName().equals(s)){
    			   electionsFromSelectedTable.add(p.getCandidate1Name());
    			   electionsFromSelectedTable.add(p.getCandidate2Name());
    			   electionsFromSelectedTable.add(p.getCandidate3Name());
    			   
    		   }
    		   
    	   }
		return electionsFromSelectedTable;
       }


	public void insertNewElection(Elections i) {
		
		String tempElectionName = i.getElectionName();
		String tempCand1Name = i.getCandidate1Name();
		String tempCand2Name = i.getCandidate2Name();
		String tempCand3Name= i.getCandidate3Name();
		//int tempCand1Vote = i.getCandidate1Count();
		//int tempCand2Vote = i.getCandiate2Count();
		//int tempCand3Vote = i.getCandiate3Count();
		
		
		
		String query = "insert into currentelections (electiontname, candidate1name, candidate2name, candiate3name ) values (' "
				+ tempElectionName + " ' , ' " + tempCand1Name +  " ' , ' " + tempCand2Name + " ' , ' " + tempCand3Name + " ' )";
		System.out.println(query);
		try {
			Statement st = (Statement)con.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


       
}


