package cn.qdsoft.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qdsoft.dao.PhoneDAO;
import cn.qdsoft.model.Phone;

@WebServlet("/phone/list.do")
public class PhoneListServlet extends HttpServlet {

	private PhoneDAO phoneDAO = new PhoneDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			List<Phone> phoneList = phoneDAO.findAll();
			req.setAttribute("phoneList", phoneList);
			req.getRequestDispatcher("/phone/list.jsp").forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
