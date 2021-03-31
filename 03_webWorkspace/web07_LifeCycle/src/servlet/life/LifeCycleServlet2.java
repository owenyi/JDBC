package servlet.life;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 클라이언트의 요청을 처리한 결과
 * 즉 필드에 지정된 COUNT 값을 서블릿이 출력하지 않고
 * 정보를 JSP에게 넘기고
 * 결과 페이지 처리를 JSP가 하도록 로직을 수정
 * 이 때, 페이지 연결 방법을 사용해야 하나
 * 단순하게 우리가 이미 아록 있는 방법인 a태그를 이용하자.
 */
@WebServlet(urlPatterns = { "/LIFE2" }, loadOnStartup = 1)
public class LifeCycleServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 0;
	
	public LifeCycleServlet2() {
		System.out.println("1. LifeCycleServlet2 생성자 호출...by Container(WAS)...");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("3. service() 호출 --> doGet() | doPost() 호출...by Container");
		
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8;");
		
		PrintWriter out = res.getWriter();
		
//		out.println("<html><body bgcolor='yellow'>");
//		out.println("<h3>LifeCycle CallBack Method...</h3>");
//		out.println("<b>count : " + ++count + "</b>");
//		out.println("</body></html>");
		out.println("<a href='life2.jsp?cnt=" + ++count + "'>여기를 클릭하시면 JSP페이지로 이동합니다.</a>"); // get, qeury string
		
		out.close();
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("2. init() 호출...by Container...여기까지가 Ready On");
	}
	
	@Override
	public void destroy() {
		System.out.println("4. destroy() 호출...by Container");
	}
	
}
