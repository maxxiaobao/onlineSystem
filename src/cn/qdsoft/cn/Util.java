package cn.qdsoft.cn;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Util {

	public static void copy(InputStream in, File outfile) throws IOException {
		File dir = outfile.getParentFile();
		if (!dir.exists()) {
			dir.mkdirs();
		}
		OutputStream out = new FileOutputStream(outfile);
		copy(in, out);
		out.close();
	}

	public static void copy(InputStream in, OutputStream out)
			throws IOException {
		byte[] bytes = new byte[1024 * 10];
		int count;
		while ((count = in.read(bytes)) != -1) {
			out.write(bytes, 0, count);
		}
	}

}
