package cn.qdsoft.cn;

public class JSON {

	private StringBuffer buffer = new StringBuffer();

	public static JSON start() {
		JSON json = new JSON();
		json.buffer.append("{");
		return json;
	}

	public JSON append(String name, String value) {
		buffer.append("\"");
		buffer.append(name);
		buffer.append("\":\"");
		buffer.append(value);
		buffer.append("\",");
		return this;
	}

	public JSON append(String name, int value) {
		buffer.append("\"");
		buffer.append(name);
		buffer.append("\":");
		buffer.append(value);
		buffer.append(",");
		return this;
	}

	public JSON append(String name, boolean value) {
		buffer.append("\"");
		buffer.append(name);
		buffer.append("\":");
		buffer.append(value);
		buffer.append(",");
		return this;
	}

	public String end() {
		if (buffer.length() > 1) {
			buffer.deleteCharAt(buffer.length() - 1);
		}
		buffer.append("}");
		String str = buffer.toString();
		buffer = null;
		return str;
	}
}
