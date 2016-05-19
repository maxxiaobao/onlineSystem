package cn.qdsoft.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qdsoft.cn.DAOFactory;
import cn.qdsoft.model.Admin;

@WebServlet("/admin/list.do")
public class AdminListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			List<Admin> adminList = DAOFactory.getAdminDAO().findAll();
			System.out.print(adminList.size());
			req.setAttribute("adminList", adminList);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("/admin/list.jsp").forward(req, resp);
	}

}
