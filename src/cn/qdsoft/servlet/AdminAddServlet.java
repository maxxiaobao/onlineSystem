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
import cn.qdsoft.model.Admin;

@WebServlet("/admin/add.do")
public class AdminAddServlet extends BaseServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		Admin m = new Admin();
		m.setEmail(WebUtil.getString(req, "email"));
		m.setPasswd(Admin.DEFAULT_PASSWORD);
		m.setPhone(WebUtil.getString(req, "phone"));
		m.setPhoto(WebUtil.getString(req, "photo"));
		m.setQq(WebUtil.getString(req, "qq"));
		m.setRealname(WebUtil.getString(req, "realname"));
		m.setType(WebUtil.getInt(req, "type"));
		Admin temp = null;
		try {
			temp = DAOFactory.getAdminDAO().findByEmail(m.getEmail());
			if (temp != null) {
				// 电子邮件重复
				fail(resp, "邮件地址已存在");
			} else {
				DAOFactory.getAdminDAO().insert(m);
				// 添加成功
				success(resp, "管理员添加成功");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(resp, "数据库出现错误");
		}
	}
}
