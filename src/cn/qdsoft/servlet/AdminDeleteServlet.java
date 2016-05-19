package cn.qdsoft.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qdsoft.cn.WebUtil;
import cn.qdsoft.dao.AdminDAO;

@WebServlet("/admin/delete.do")
public class AdminDeleteServlet extends HttpServlet {

	private AdminDAO adminDAO = new AdminDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		int id = WebUtil.getInt(req, "id");
		try {
			adminDAO.delete(id);
			req.getRequestDispatcher("/admin/list.do").forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
