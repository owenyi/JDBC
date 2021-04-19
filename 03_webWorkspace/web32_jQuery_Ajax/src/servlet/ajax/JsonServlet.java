package servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import domain.Weather;

@WebServlet("/JsonServlet")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		// 1. JSON 객체를 하나 생성...json.jar가 있어야 한다.
		JSONObject json = new JSONObject();
		
		json.put("region", "Busan");
		json.put("wind", 12);
		json.put("temp", 34);
		json.put("rain", 56);
		
		// 2. Weather 객체를 생성
		Weather w = new Weather();
		w.setRegion("NY");
		w.setWind(44);
		w.setTemp(23);
		w.setRain(46);
		
		// 3. 객체를 json에 put
		json.put("weather", w);
		
		// 4. 객체를 전송
		out.print(json);
	}

}
