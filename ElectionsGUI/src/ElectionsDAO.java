import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
				Elections tempElections = new Elections( electionName, candidate1Name, candiadate2Name, candiadate3Name, cand1Vote, cand2Vote, cand3Vote );
				allElections.add(tempElections);
				/*System.out.println(electionName + " -- " + candidate1Name + " -- " + candiadate2Name + " -- " + candiadate3Name
						+ " -- " + cand1Vote + " -- " + cand2Vote +  " -- " + cand3Vote );*/
				//System.out.println(id + " -- " + store + " -- " + item);


			}


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
	//public List<List> listOfCandNamesandCounts = new ArrayList<List>();

	public ArrayList<String> getCurrentElectionsFromTable(String s){
		ArrayList<String> electionsFromSelectedTable = new ArrayList<String>();

		for(Elections p : getAllElections()){
			if(p.getElectionName().equals(s)){
				electionsFromSelectedTable.add(p.getCandidate1Name());
				electionsFromSelectedTable.add(p.getCandidate2Name());
				electionsFromSelectedTable.add(p.getCandidate3Name());
				//System.out.println(p.getCandidate1Name());
			}

		}
		return electionsFromSelectedTable;

	}

	public ArrayList<Integer> getCurrentElectionsCountFromTable(String s){
		ArrayList<Integer> electionsCountFromSelectedTable = new ArrayList<Integer>();
		for(Elections p : getAllElections()){
			if(p.getElectionName().equals(s)){
				electionsCountFromSelectedTable.add(p.getCand1Vote());
				electionsCountFromSelectedTable.add(p.getCand2Vote());
				electionsCountFromSelectedTable.add(p.getCand3Vote());
				//System.out.println("elec:"+electionsCountFromSelectedTable);


			}

		}
		return electionsCountFromSelectedTable;
	}
	public void insertNewElection(Elections i) {

		String tempElectionName = i.getElectionName();
		String tempCand1Name = i.getCandidate1Name();
		String tempCand2Name = i.getCandidate2Name();
		String tempCand3Name= i.getCandidate3Name();
		int tempCand1Vote = i.getCand1Vote();
		int tempCand2Vote = i.getCand2Vote();
		int tempCand3Vote = i.getCand3Vote();



		String query = "insert into currentelections (electionname, candidate1name, candidate2name, candidate3name, cand1vote, cand2vote, cand3vote) values (' "
				+ tempElectionName + " ' , ' " + tempCand1Name +  " ' , ' " + tempCand2Name + " ' , ' " + tempCand3Name + " ' , ' " + tempCand1Vote + " ' , ' " + tempCand2Vote + " ' , ' " + tempCand3Vote + " ')";
		System.out.println(query);
		try {
			Statement st = (Statement)con.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateVote1Count(Elections current){
		makeConnection();

		int currentCand1Vote = current.getCand1Vote();
		String currentElectionName = current.getElectionName();
		System.out.println(currentCand1Vote + currentElectionName);


		String q = "update currentelections set  Cand1Vote = '"
				+ currentCand1Vote + "' where ElectionName = '" + currentElectionName + "'";
		try{
			Statement st = (Statement) con.createStatement();
			st.executeUpdate(q);
		} catch (SQLException e){
			System.out.println("error in UpdateItem method");
			e.printStackTrace();
		}
	}

	public void updateVote2Count(Elections current){
		makeConnection();

		int currentCand2Vote = current.getCand2Vote();
		String currentElectionName = current.getElectionName();

		String q = "update currentelections set  Cand2Vote = '"
				+ currentCand2Vote + "' where ElectionName = '" + currentElectionName + "'";
		try{
			Statement st = (Statement) con.createStatement();
			st.executeUpdate(q);
		} catch (SQLException e){
			System.out.println("error in UpdateItem method");
			e.printStackTrace();
		}
	}

	public void updateVote3Count(Elections current){
		makeConnection();

		int currentCand3Vote = current.getCand3Vote();
		String currentElectionName = current.getElectionName();

		String q = "update currentelections set  Cand3Vote = '"
				+ currentCand3Vote + "' where ElectionName = '" + currentElectionName + "'";
		try{
			Statement st = (Statement) con.createStatement();
			st.executeUpdate(q);
		} catch (SQLException e){
			System.out.println("error in UpdateItem method");
			e.printStackTrace();
		}
	}








}


