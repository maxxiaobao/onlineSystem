package cn.qdsoft.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qdsoft.cn.BaseServlet;
import cn.qdsoft.cn.DAOFactory;
import cn.qdsoft.cn.WebUtil;
import cn.qdsoft.dao.AdminDAO;
import cn.qdsoft.model.Admin;

@WebServlet("/admin/edit.do")
public class AdminEditServlet extends BaseServlet {

	AdminDAO adminDAO = DAOFactory.getAdminDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = WebUtil.getInt(req, "id");
		try {
			Admin m = adminDAO.findById(id);
			req.setAttribute("m", m);
			req.getRequestDispatcher("/admin/edit.jsp").forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Admin m = new Admin();
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		m.setEmail(WebUtil.getString(req, "email"));
		m.setId(WebUtil.getInt(req, "id"));
		m.setPhone(WebUtil.getString(req, "phone"));
		m.setPasswd(WebUtil.getString(req, "passwd"));
		m.setPhoto(WebUtil.getString(req, "photo"));
		m.setQq(WebUtil.getString(req, "qq"));
		m.setRealname(WebUtil.getString(req, "realname"));
		m.setStatus(WebUtil.getInt(req, "status"));
		m.setType(WebUtil.getInt(req, "type"));
		Admin temp;
		try {
			temp = adminDAO.findByEmail(m.getEmail());
			if ((temp != null && temp.getId() == m.getId()) || temp == null) {
				adminDAO.update(m);
				success(resp, "信息修改成功");
			} else {
				fail(resp, "邮件地址重复");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
