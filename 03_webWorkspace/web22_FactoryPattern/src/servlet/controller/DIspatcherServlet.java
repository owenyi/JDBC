package servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//                         / <- 확장자(.do)가 들어가면 빼줘야 됨
@WebServlet(urlPatterns = "*.do", loadOnStartup = 1)
public class DIspatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 얘는 이제 안 씀
//		String command = request.getParameter("command");
		// 파라미터가 아닌 전체주소를 직접 받아서 앞부분만 자른다
		String requestURI = request.getRequestURI(); // 전체주소
		System.out.println("RequestURI : " + requestURI); // web22_FactoryPattern/find.do
		
		String contextPath = request.getContextPath();
		System.out.println("ContextPath : " + contextPath); // web22_FactoryPattern
		
		String command = requestURI.substring(contextPath.length() + 1); // == find.do
		System.out.println("Command : " + command);
		
		ModelAndView mv = null;
		String path = "index.html"; // default : error page || home
		
		Controller controller = HandlerMapping.getInstance().createController(command);
		
		try {
			mv = controller.execute(request, response);
			path = mv.getPath();
		} catch (Exception e) {
			
		}
		
		if (mv != null) {
			if (mv.isRedirect()) response.sendRedirect(path); // 필드가 boolean이면 get이 아니라 is가 붙는다.
			else request.getRequestDispatcher(path).forward(request, response);
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
}
	