package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MFS")
public class FormServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 한글 처리 양방향
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		
		// 2. 각각 폼의 값들을 다 받아온다.
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String[] menus = request.getParameterValues("menu");
		String gender = request.getParameter("gender");
		String intro = request.getParameter("intro");
		
		// 3. PrintWriter 객체 리턴
		PrintWriter out = response.getWriter();
		
		// 4. 클라이언트의 브라우저로 받은 내용을 출력한다.
		out.println("<html><body>");
		out.println("<h2>폼에 입력된 값을 출력합니다.</h2>");
		out.println("<li>당신의 아이디 " + id + "</li>");
		out.println("<li>당신의 패스워드 " + password + "</li>");
		out.println("<storng>선택하신 메뉴들입니다.</strong>");
		String menu = "";
		for (String s : menus) {
			menu = s + " ";
		}
		out.println(menu);
		out.println("<br><strong>당신의 성별은 " + gender + "입니다.</strong><br>");
		out.println("<br><strong>방명록 내용입니다.</strong><br>");
		out.println(intro);
		out.println("</body></html>");
		
		// 5. PrintWriter를 닫아준다.
		out.close();
	}

}
