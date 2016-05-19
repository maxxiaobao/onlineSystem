package cn.qdsoft.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qdsoft.cn.BaseServlet;
import cn.qdsoft.cn.Util;
import cn.qdsoft.cn.WebUtil;

@WebServlet("/down.do")
public class DownloadServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String fileName = WebUtil.getString(req, "file");
		File file = new File("d:/uploads/" + fileName);
		InputStream in = new FileInputStream(file);
		Util.copy(in, resp.getOutputStream());
		in.close();
	}

}
