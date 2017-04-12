package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Elections;
import model.ElectionsDAO;


/**
 * Servlet implementation class MasterControllerServlet
 */
@WebServlet("/VoteControllerServlet")
public class VoteControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor. 
	 */
	public VoteControllerServlet() {
		// TODO Auto-generated constructor stub
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		System.out.println("Inside the vote controller servelet");
		ElectionsDAO dao = new ElectionsDAO();
		String actionToPerform = request.getParameter("doThisToItem");
		HttpSession session = request.getSession();
		int revar = (Integer) session.getAttribute("myeId");
		String candNames = (String) session.getAttribute("candidates");
		
		 if(actionToPerform.equals("vote"))
			
		{
			String tempID = request.getParameter("id");
			//int tempId = request.getParameter("id");
			int tempNID = Integer.parseInt(tempID);
			System.out.println(tempNID  + "number value");
			//HttpSession session = request.getSession();
			//int var = (Integer) session.getAttribute("myeId");
			
            Elections candidateVotes = dao.getAllElections().get(revar);
			String elecName = candidateVotes.getElectionName().toString();
			String cand1N = candidateVotes.getCandidate1Name().toString();
			String cand2N = candidateVotes.getCandidate2Name().toString();
			String cand3N = candidateVotes.getCandidate3Name().toString();
			int c1V = candidateVotes.getCand1Vote();
			int c2V = candidateVotes.getCand2Vote();
			int c3V = candidateVotes.getCand3Vote();
            	if(tempNID == 0){
				c1V=c1V+1;
				System.out.println(c1V);
				Elections vote1CountUpdate = new Elections(elecName,cand1N,cand2N,cand3N,c1V,c2V,c3V);
				System.out.println(vote1CountUpdate.toString());
                dao.updateVote1Count(vote1CountUpdate);
			 }
			    else if(tempNID == 1){
				c2V=c2V+1;
				Elections vote2CountUpdate = new Elections(elecName,cand1N,cand2N,cand3N,c1V,c2V,c3V);
				dao.updateVote2Count(vote2CountUpdate);

			 }
			    else if(tempNID == 2){
				c3V=c3V+1;
				Elections vote3CountUpdate = new Elections(elecName,cand1N,cand2N,cand3N,c1V,c2V,c3V);
				dao.updateVote3Count(vote3CountUpdate);

			}
            	

    			request.setAttribute("electionId", revar+"");
    			request.setAttribute("c1N", candNames);
    			
		
            	getServletContext().getRequestDispatcher("/ElectionNamesServlet").forward(request, response);
        	
		        doGet(request, response);
		}
		}
	}


