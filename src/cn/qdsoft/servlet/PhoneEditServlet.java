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
import cn.qdsoft.model.Phone;

@WebServlet("/phone/edit.do")
public class PhoneEditServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Phone p = new Phone();
		try {
			p = DAOFactory.getPhoneDAO().findById(WebUtil.getInt(req, "id"));
			req.setAttribute("p", p);
			req.getRequestDispatcher("/phone/edit.jsp").forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		Phone p = new Phone();
		p.setId(WebUtil.getInt(req, "id"));
		p.setDescription(WebUtil.getString(req, "description"));
		p.setFacId(WebUtil.getInt(req, "facId"));
		p.setName(WebUtil.getString(req, "name"));
		p.setPhoneCount(WebUtil.getInt(req, "phoneCount"));
		p.setPrice(WebUtil.getDouble(req, "price"));

		try {
			Phone temp = DAOFactory.getPhoneDAO().findByName(p.getName());
			if (temp != null && temp.getId() != p.getId()) {
				fail(resp, "此商品已存在");
			} else {
				DAOFactory.getPhoneDAO().update(p);
				success(resp, "更新成功");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
