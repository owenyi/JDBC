package servlet.cookie;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ACookieTest")
public class ACookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로직은 여기에 바로 작성
		/*
		 * 1. 쿠키 생성
		 * 2. 생선된 쿠키를 클라이언트 쪽으로 보냄...
		 */
		Date now = new Date(); // 이거 안 됨
		Cookie c1 = new Cookie("now", "2021-04-05-03:37:20");
		Cookie c2 = new Cookie("id", "encore");
		
		// 쿠키의 유효 시간을 설정...
		c1.setMaxAge(24*60*60); // 하루 동안 쿠키 정보가 저장...브라우저에서...오늘 본 상품 정보 같은 거...
		c2.setMaxAge(0); // 쿠키 사용하지 않겠다.
		
		response.addCookie(c1);
		response.addCookie(c2);
		
		response.sendRedirect("bCookieTest.jsp");
	}
	
}
