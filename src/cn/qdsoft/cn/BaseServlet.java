package cn.qdsoft.cn;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class BaseServlet extends HttpServlet {

	protected void writeJSON(HttpServletResponse resp, String json)
			throws IOException {
		resp.setContentType("text/json");
		resp.getWriter().print(json);
	}

	public void success(HttpServletResponse resp, String msg)
			throws IOException {
		String json = JSON.start().append("success", true).append("msg", msg)
				.end();
		writeJSON(resp, json);
	}

	public void fail(HttpServletResponse resp, String msg) throws IOException {
		String json = JSON.start().append("success", false).append("msg", msg)
				.end();
		writeJSON(resp, json);
	}

	public String[] savePart(Part part) throws IOException {
		String header = part.getHeader("Content-Disposition");
		int startIndex = header.lastIndexOf("=") + 2;
		int endIndex = header.length() - 1;
		String oldName = header.substring(startIndex, endIndex);
		startIndex = oldName.lastIndexOf(".");
		System.out.println(startIndex);
		String ext = startIndex > -1 ? oldName.substring(startIndex) : "";
		System.out.println(ext);
		String newName = System.currentTimeMillis() + ext;
		Util.copy(part.getInputStream(), new File(saveDir, newName));
		System.out.println(newName + "," + oldName);

		return new String[] { newName, oldName };
	}

	protected final File saveDir = new File("d:/uploads");

}
