package servlet.controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.encore.model.Item;
import com.encore.model.ItemDao;

public class ItemListController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<String> fruits = new ArrayList<String>();
		
		// 브라우저의 모든 쿠키 정보를 받아와 필요한 쿠키만 뽑는 로직을 작성
		// 1) 브라우저에서 모든 쿠키 받아옴 2) 그 중 내가 원하는 쿠키를 뽑아 바인딩
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().startsWith("fruitshop")) {
					fruits.add(c.getValue());
				}
			}
		}
		
		request.setAttribute("fruits", fruits);
		
		//////////////////////////////////////////////////////////
		
		ArrayList<Item> list = ItemDao.getInstance().getAllItem();
		
		request.setAttribute("list", list);
		
		return new ModelAndView("itemList.jsp");
	}

}
