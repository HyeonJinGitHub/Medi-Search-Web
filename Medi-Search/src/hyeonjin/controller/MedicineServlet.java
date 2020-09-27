package hyeonjin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hyeonjin.domain.MedicineVO;
import hyeonjin.persistence.MedicineDAO;

/**
 * Servlet implementation class MedicineServlet
 */
@WebServlet("/MedicineServlet")
public class MedicineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		String cmd;
		cmd = request.getParameter("key");
		if(cmd.equals("search")) {
			ArrayList<MedicineVO> medicinelist = new ArrayList<MedicineVO>();
			MedicineDAO medicinedao = new MedicineDAO();
			medicinelist=medicinedao.readAll(request.getParameter("medicineName"));
			
			request.setAttribute("medicineList", medicinelist);
			RequestDispatcher view = request.getRequestDispatcher("searchResult.jsp");
			view.forward(request, response);
		}
	}

}
