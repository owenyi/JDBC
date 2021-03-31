package servlet.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//필드 추가
	private String name, address;

    public ServletConfigTest1() {
        System.out.println("생성자 호출...인스턴스 이 때 생성됩니다.");
    }

	public void init() throws ServletException {
		System.out.println("init() call...");
		// 서블릿의 필드 초기화...이 정보는 절대로 화면으로부터 받아온 정보가 아니다.
		// 요청 받기 훨씬 이전에 keeping된 값을 컨테이너에 끌어당겨왔다.
		name = getInitParameter("custname"); // ServletConfig를 상속 받기 때문에 getInitParameter()를 그냥 쓸 수 있다.
		address = getInitParameter("address");
		System.out.println(name + ", " + address);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8;");
		
		PrintWriter out = res.getWriter();
		out.println("<html><body bgcolor='yellow'");
		out.println("<h2>A Servlet Configuration...Using ServletConfig</h2>");
		out.println("Your Name is " + name + "<br>");
		out.println("Your Address is " + address + "<br>");
		out.println("</body></html>");
		
		out.close();
	}

}
