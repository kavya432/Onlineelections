package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Elections;
import model.ElectionsDAO;

/**
 * Servlet implementation class AddItemServlet=-
 */
@WebServlet("/AddElectionServlet")
public class AddElectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddElectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//
		String elecName = request.getParameter("electionName");
		String cand1Name = request.getParameter("candidate1Name");
		String cand2Name = request.getParameter("candidate2Name");
		String cand3Name = request.getParameter("candidate3Name");
		int vote1count = 0;
		int vote2count = 0;
		int vote3count = 0;
		Elections li = new Elections(elecName, cand1Name,cand2Name,cand3Name,vote1count,vote2count,vote3count);
		ElectionsDAO dao = new ElectionsDAO();
		dao.insertNewElection(li);
		getServletContext().getRequestDispatcher("/ElectionNamesServlet").forward(request, response);
		//doGet(request, response);
	}

}
