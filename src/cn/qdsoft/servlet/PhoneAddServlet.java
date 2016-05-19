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

@WebServlet("/phone/add.do")
public class PhoneAddServlet extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		Phone p = new Phone();
		p.setDescription(WebUtil.getString(req, "description"));
		p.setFacId(WebUtil.getInt(req, "facId"));
		p.setName(WebUtil.getString(req, "name"));
		p.setPhoneCount(WebUtil.getInt(req, "phoneCount"));
		p.setPrice(WebUtil.getDouble(req, "price"));
		try {
			Phone temp = DAOFactory.getPhoneDAO().findByName(p.getName());
			if (temp != null) {
				fail(resp, "此商品已存在");
			} else {
				DAOFactory.getPhoneDAO().insert(p);
				success(resp, "商品添加成功");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(resp, "数据库错误");
		}

	}
}
