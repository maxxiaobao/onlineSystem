package cn.qdsoft.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qdsoft.cn.DAOFactory;
import cn.qdsoft.cn.WebUtil;

@WebServlet("/phone/delete.do")
public class PhoneDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = WebUtil.getInt(req, "id");
		try {
			DAOFactory.getPhoneDAO().delete(id);
			req.getRequestDispatcher("/phone/list.do").forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
