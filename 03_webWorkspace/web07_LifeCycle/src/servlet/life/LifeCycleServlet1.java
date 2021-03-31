package servlet.life;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LIFE1")
public class LifeCycleServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 0;
	
	public LifeCycleServlet1() {
		System.out.println("1. LifeCycleServlet1 생성자 호출...by Container(WAS)...");
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
		
		// 클라이언트의 요청이 몇 번 들어왔는지를 count하는 로직을 작성
		out.println("<html><body bgcolor='yellow'>");
		out.println("<h3>LifeCycle CallBack Method...</h3>");
		out.println("<b>count : " + ++count + "</b>");
		out.println("</body></html>");
		
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
