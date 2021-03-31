package servlet.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String path;
	private String custid;

    public ServletConfigTest2() {
        System.out.println("생성자 호출...인스턴스 이 때 생성됩니다...ConfigTest2...");
    }

	public void init() throws ServletException {
		System.out.println("init() call...ConfigTest2...");
		
		path = getInitParameter("path");
		System.out.println(path);
		// 저장된 파일의 값을 읽어서 필드에 할당...로직을 작성
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			custid = br.readLine();
			System.out.println("고객정보...credit no..." + custid);
			
			br.close();
		} catch (Exception e) {
			
		}
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
		
		// form으로 받아온 값 읽어온다...getParameter()...getInitParameter()와 시점이 완전히 다르고 값을 받아오는 통로도 다르다...!!!
		String custname = req.getParameter("cust");
		
		PrintWriter out = res.getWriter();
		out.println("<html><body bgcolor='yellow'");
		out.println("<h2>A Servlet Configuration...Using ServletConfig</h2>");
		out.println("<h3>" + custname + ", " + custid + "로 인증되었습니다...서비스 진행 가능합니다..."); // 인증 정보를 확인하는 절차가 추가로 필요하겠지만...
		out.println("</body></html>");
		
		out.close();
	}

}
