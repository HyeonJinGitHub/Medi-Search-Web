package hyeonjin.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import hyeonjin.domain.MemberVO;
import hyeonjin.persistence.MemberDAO;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		HttpSession session = request.getSession();
		 String cmd; 
		 cmd = request.getParameter("key"); 
		 if(cmd.equals("back")) {
			 response.sendRedirect("mypage.jsp");
			} else if(cmd.equals("logout")) {
				session.removeAttribute("memberVO");
				session.removeAttribute("ID");
				session.removeAttribute("name");
				
				 response.sendRedirect("login.jsp");
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		HttpSession session = request.getSession();
		String cmd, message;
		cmd = request.getParameter("key");
		if(cmd.equals("join")) {
			MemberVO memberVO = new MemberVO();
			memberVO.setMemberID(request.getParameter("id"));
			memberVO.setMemberPassword(request.getParameter("passwd"));
			memberVO.setMemberName(request.getParameter("username"));
			memberVO.setMemberAge(request.getParameter("userage"));
			memberVO.setMemberMobile(request.getParameter("mobile"));
			memberVO.setMemberGender(request.getParameter("gender"));
		
			MemberDAO memberDAO = new MemberDAO();
			
			if(memberDAO.add(memberVO)) message = "애용Medicine에 가입을 축하합니다";
			else message = "가입 실패입니다. 아이디가 중복되니 다른 아이디를 입력해주세요. <br>입력하신 정보는 아래와 같습니다.";
			
			request.setAttribute("message", message);
			request.setAttribute("member", memberVO);
			
			RequestDispatcher view = request.getRequestDispatcher("registerResult.jsp");
			view.forward(request, response);
			
		} else if(cmd.equals("login"))
		{
			String loginID, loginPassword;
			MemberVO memberVO = new MemberVO();
			MemberDAO memberDAO = new MemberDAO();
			
			loginID = request.getParameter("memberloginID");
			loginPassword = request.getParameter("memberPassword");
			
			memberVO.setMemberID(loginID);
			memberVO.setMemberPassword(loginPassword);
			
			memberVO = memberDAO.login(memberVO);
			if(memberVO != null) {
				session.setAttribute("memberVO", memberVO);
				session.setAttribute("ID", memberVO.getMemberID());
				session.setAttribute("name", memberVO.getMemberName());				
			
				message = memberVO.getMemberName()+"님 <br>애용Medi-Search에 오신것을 환영합니다!";
				
				request.setAttribute("member", memberVO);
				request.setAttribute("message", message);
				RequestDispatcher view = request.getRequestDispatcher("successLogin.jsp");
				view.forward(request, response);
			}else {
				response.sendRedirect("loginFail.jsp");
			}
	
		}
		else if(cmd.equals("update"))
		{
			MemberVO memberVO = new MemberVO();
			
			memberVO.setMemberID(request.getParameter("id"));
			memberVO.setMemberPassword(request.getParameter("passwd"));
			memberVO.setMemberName(request.getParameter("username"));
			memberVO.setMemberAge(request.getParameter("userage"));
			memberVO.setMemberMobile(request.getParameter("mobile"));
			memberVO.setMemberGender(request.getParameter("gender"));
			
			MemberDAO dao = new MemberDAO();
			
			if(dao.update(memberVO)) {message="수정이 완료되었습니다.<br>";
			session.setAttribute("memberVO", memberVO);
			session.setAttribute("ID", memberVO.getMemberID());
			session.setAttribute("name", memberVO.getMemberName());
			}
			else message = "수정 취소하였습니다. 기존 정보는 다음과 같습니다.";
			
			request.setAttribute("message", message);
			request.setAttribute("member", memberVO);
			
			RequestDispatcher view = request.getRequestDispatcher("updateResult.jsp");
			view.forward(request, response);
		} else if(cmd.equals("register"))
		{
			response.sendRedirect("register.jsp");
		}
	}
}


