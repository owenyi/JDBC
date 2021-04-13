package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;

public class IdListController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		String path = "";
		String id = request.getParameter("id");
		
		try {
			/*
			 * ArrayList list = DAO의 모든 ID 값의 리스트를 받아온다...getIdList();
			 * Attribute에 list라는 이름으로 바인딩
			 * path = show_idList.jsp
			 */
			request.setAttribute("list", MemberDAOImpl.getInstance().getIdList());
		} catch (SQLException e) {
			
		}
		return new ModelAndView("show_idList.jsp");
	}

}
