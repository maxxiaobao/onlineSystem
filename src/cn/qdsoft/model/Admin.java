package cn.qdsoft.model;

public class Admin {

	private int id;
	private String realname;
	private String email;
	private String passwd;
	private String qq;
	private String phone;
	private int type; // 管理员类型 1用户 2商品 3订单 4物流
	private int status; // 管理员状态 1正常 2禁用 3删除
	private String photo;

	public static final int NOMAL = 1;
	public static final int DISABLED = 2;
	public static final int DELETED = 3;
	public static final int USER = 1;
	public static final int GOODS = 2;
	public static final int ORDER = 3;
	public static final int LOGISTIC = 4;
	public static final String DEFAULT_PASSWORD = "111111";

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
