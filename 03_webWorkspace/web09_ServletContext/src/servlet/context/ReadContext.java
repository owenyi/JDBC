package servlet.context;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 1. ServletContext를 반환받는다...ServletConfig의 getServletContext()
 * 2. ServletContext에 리딩...getAttribute()
 * 3. 읽어온 정보를 출력
 */
@WebServlet("/Reading")
public class ReadContext extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 필드 추가
	private HashMap<String, String> userList;
	private ServletContext cont;

	@Override
	public void init() throws ServletException {
		System.out.println("init() call...");
		// 1. ServletContext 반환
		cont = getServletContext();
		System.out.println("Reading ServletContext...return..." + cont.getContextPath());
		System.out.println("Reading ServletContext...return..." + cont);
		userList = new HashMap<String, String>();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		
		// 2. 리딩
		userList = (HashMap) cont.getAttribute("userList"); // convention...이름이 중요하다...왔다 갔다 하면서 확인할 필요X
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2>다음은 Attribute 안에 바인딩 된 데이터를 찾아온 결과입니다.</h2><p>");
		Set<String> set = userList.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = userList.get(key);
			out.println(key + " : " + value + "<br>");
		}
		out.println("</body></html>");
		out.close();
	}
	
}
