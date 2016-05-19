package cn.qdsoft.cn;

import javax.servlet.http.HttpServletRequest;

public class WebUtil {

	public static String getString(HttpServletRequest req, String name) {
		String val = req.getParameter(name);
		return val == null ? "" : val.trim();
	}

	public static int getInt(HttpServletRequest req, String name) {
		String var = req.getParameter(name);
		return Integer.parseInt(var);
	}

	public static double getDouble(HttpServletRequest req, String name) {
		String val = req.getParameter(name);
		return Double.parseDouble(val);
	}
}
