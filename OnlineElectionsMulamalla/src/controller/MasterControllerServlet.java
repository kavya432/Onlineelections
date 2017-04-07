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
@WebServlet("/MasterControllerServlet")
public class MasterControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MasterControllerServlet() {
        // TODO Auto-generated constructor stub
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside the Master servelet");
		ElectionsDAO dao = new ElectionsDAO();
		String actionToPerform = request.getParameter("doThisToItem");
		if(actionToPerform.contentEquals("add")){
			System.out.println("Launch us to add elections");
			getServletContext().getRequestDispatcher("/add-election.jsp").forward(request, response);
		}else if(actionToPerform.equals("select")){
			int electionId = Integer.parseInt(request.getParameter("id"));
			String electionName = request.getParameter("id");
			//String electionName = request.getParameter("id");
			System.out.println(electionId);
			Elections candidateNames = dao.getAllElections().get(electionId);
			ArrayList<String> cands =new ArrayList<String>();
			String candidate1 = candidateNames.getCandidate1Name();
			cands.add(candidate1);
			String candidate2 = candidateNames.getCandidate2Name();
			cands.add(candidate2);
			String candidate3 = candidateNames.getCandidate3Name();
			cands.add(candidate3);
			
			request.setAttribute("candidates", electionId+"");
			request.setAttribute("candidates", cands);
			HttpSession session = request.getSession();
			session.setAttribute("myeId",electionId);
			//session.setAttribute("myeName",electionName);
			
			
			System.out.println(cands);
		
			getServletContext().getRequestDispatcher("/vote-election.jsp").forward(request, response);
		}
		
		
		doGet(request, response);
	}

}
