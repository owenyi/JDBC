package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.encore.model.Item;
import com.encore.model.ItemDao;

public class ItemViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int itemid = Integer.parseInt(request.getParameter("itemid"));
		
		Item item = ItemDao.getInstance().getItem(itemid);
		ItemDao.getInstance().updateRecordCount(itemid);
		
		request.setAttribute("item", item);
		
		return new ModelAndView("itemView.jsp");
	}

}
