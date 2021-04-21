package servlet.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.encore.model.Item;
import com.encore.model.ItemDao;

public class ItemViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int itemid = Integer.parseInt(request.getParameter("itemid"));
		
		// count 증가
		boolean result = ItemDao.getInstance().updateRecordCount(itemid);
		System.out.println("Counting Update : " + (result ? "OK!!!" : "Fail..."));
		
		Item item = ItemDao.getInstance().getItem(itemid);
		System.out.println("Item 조회 : " + item);
		
		// 오늘 본 상품 정보를 쿠키에 저장하는 로직 추가
		// 1) 쿠키 생성("key", "value") 2) 쿠키 저장 시간을 24시간으로 지정 setMaxAge() 3) 정보가 저장된 쿠키를 클라이언트로 보냄
		Cookie cookie = new Cookie("fruitshop" + itemid, item.getUrl());
		cookie.setMaxAge(24*60*60);
		response.addCookie(cookie);
		
		request.setAttribute("item", item);
		
		return new ModelAndView("itemView.jsp");
	}

}
