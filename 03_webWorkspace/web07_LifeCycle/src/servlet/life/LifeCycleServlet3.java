package servlet.life;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/LIFE3" }, loadOnStartup = 1)
public class LifeCycleServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 0;
	private String path = "C:\\encore_lss\\util\\web_util\\life\\count.txt";
	
	public LifeCycleServlet3() {
		System.out.println("1. LifeCycleServlet3 생성자 호출...by Container(WAS)...");
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
		
		out.println("<html><body bgcolor='yellow'>");
		out.println("<h3>LifeCycle CallBack Method...</h3>");
		out.println("<b>count : " + ++count + "</b>");
		out.println("</body></html>");
		
		out.close();
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("2. init() 호출...by Container...여기까지가 Ready On");
		// 파일에 저장된 내용을 읽어들이는 로직은 init에서 해준다.
		File f = new File(path);
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String str = br.readLine();
			count = Integer.parseInt(str); // 읽어들인 count 값을 필드에 다시 할당함!!
			
			br.close();
		} catch (Exception e) {
			System.out.println("파일을 읽어들이는데 문제가 발생했습니다...fail...");
		}
	}
	
	@Override
	public void destroy() {
		System.out.println("4. destroy() 호출...by Container");
		// 인스턴스가 메모리에서 제거되기 전에 필드 값을 영구적으로 보관...파일에 저장
		// 출력용 스트림을 생성...이곳에 필드 값을 출력
		File f = new File(path);
		f.getParentFile().mkdirs();// 디렉토리를 없다면 만들어 놔야 그곳에 count.txt 파일이 생성...물론 만들었지만
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(f)); // 출력용 스트림 생성
			pw.println(count); // 출력
			
			pw.close();
			
			System.out.println(path + " COUNT 값 : " + count + " 파일에 값 영구적으로 저장됨!!");
		} catch (Exception e) {
			System.out.println("출력용 스트림 생성 실패...");
		}
		
	}
	
}
