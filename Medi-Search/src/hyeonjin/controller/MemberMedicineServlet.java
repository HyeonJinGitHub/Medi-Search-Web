package hyeonjin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hyeonjin.domain.MedicineVO;
import hyeonjin.domain.MemberMedicineVO;
import hyeonjin.persistence.MedicineDAO;
import hyeonjin.persistence.MemberMedicineDAO;

/**
 * Servlet implementation class MemberMedicineServlet
 */
@WebServlet("/MemberMedicineServlet")
public class MemberMedicineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		String cmd;
		cmd = request.getParameter("key");
		if(cmd.equals("add")) {
			MemberMedicineVO memberMedicineVO = new MemberMedicineVO();
			MedicineDAO medicineDAO = new MedicineDAO();
			MedicineVO medicineVO = medicineDAO.read(request.getParameter("medicineName"));
			
			memberMedicineVO.setUserID((String)session.getAttribute("ID"));
			memberMedicineVO.setMedicineName(medicineVO.getMedicineName());
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			MemberMedicineDAO dao = new MemberMedicineDAO();
			
			if(dao.search(memberMedicineVO))
			{
				if(dao.add(memberMedicineVO)) {
				
					 request.setAttribute("addMedicine", request.getParameter("medicineName"));
					  RequestDispatcher view = request.getRequestDispatcher("addSuccess.jsp");
					  view.forward(request, response);	
				}
			}
			else {
				 request.setAttribute("addMedicine", request.getParameter("medicineName"));
				  RequestDispatcher view = request.getRequestDispatcher("addFail.jsp");
				  view.forward(request, response);	
			}
		}else if(cmd.equals("userMedicine")) {
			MemberMedicineVO memberMedicineVO = new MemberMedicineVO();
			MemberMedicineDAO dao = new MemberMedicineDAO();
			memberMedicineVO.setUserID((String)session.getAttribute("ID"));
			
			ArrayList<MedicineVO> userMedicine = dao.getUserMedicineList(memberMedicineVO.getUserID());
			request.setAttribute("userMedicine", userMedicine);
			RequestDispatcher view = request.getRequestDispatcher("myMedicine.jsp");
			view.forward(request, response);
		} else if(cmd.equals("delete")) {
			MemberMedicineVO memberMedicineVO = new MemberMedicineVO();
			MemberMedicineDAO dao = new MemberMedicineDAO();
			MedicineDAO medicineDAO = new MedicineDAO();
			MedicineVO medicineVO = medicineDAO.read(request.getParameter("medicineName"));
			memberMedicineVO.setMedicineName(medicineVO.getMedicineName());
			memberMedicineVO.setUserID((String)session.getAttribute("ID"));
			if(dao.delete(memberMedicineVO)) {
			
				  ArrayList<MedicineVO> userMedicine = dao.getUserMedicineList(memberMedicineVO.getUserID());
				  request.setAttribute("userMedicine", userMedicine);
				  RequestDispatcher view = request.getRequestDispatcher("myMedicine.jsp");
				  view.forward(request, response);		
			}
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
