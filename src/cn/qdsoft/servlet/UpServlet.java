package cn.qdsoft.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import cn.qdsoft.cn.BaseServlet;

@WebServlet("/up.do")
@MultipartConfig
public class UpServlet extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/plain"); // 返回浏览器的格式是纯文本格式
		Part part = req.getPart("input-file");
		String[] fileNames = savePart(part);
		resp.getWriter().print(fileNames[0]);
	}

}
