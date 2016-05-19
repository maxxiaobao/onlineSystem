package cn.qdsoft.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.qdsoft.cn.DB;
import cn.qdsoft.model.Admin;

public class AdminDAO {

	// 增加管理员
	public void insert(Admin m) throws SQLException {
		String sql = "insert into admins (realname,email,passwd,qq,phone,type,status,photo)"
				+ "values(?,?,?,?,?,?,?,?)";
		try (PreparedStatement stmt = DB.getConn().prepareStatement(sql)) {
			stmt.setObject(1, m.getRealname());
			stmt.setObject(2, m.getEmail());
			stmt.setObject(3, Admin.DEFAULT_PASSWORD);
			stmt.setObject(4, m.getQq());
			stmt.setObject(5, m.getPhone());
			stmt.setObject(6, m.getType());
			stmt.setObject(7, Admin.NOMAL);
			stmt.setObject(8, m.getPhoto());
			stmt.executeUpdate();
		}
	}

	// 删除管理员
	public void delete(int id) throws SQLException {
		String sql = "update admins set status =? where id = ?";
		try (PreparedStatement stmt = DB.getConn().prepareStatement(sql)) {
			stmt.setObject(1, Admin.DELETED);
			stmt.setObject(2, id);
			stmt.executeUpdate();
		}
	}

	// 修改管路员
	public void update(Admin m) throws SQLException {
		String sql = "update admins set realname=?,email=?,qq=?,phone=?,type=?,status=?,photo=? where id = ?";
		try (PreparedStatement stmt = DB.getConn().prepareStatement(sql)) {
			stmt.setObject(1, m.getRealname());
			stmt.setObject(2, m.getEmail());
			stmt.setObject(3, m.getQq());
			stmt.setObject(4, m.getPhone());
			stmt.setObject(5, m.getType());
			stmt.setObject(6, m.getStatus());
			stmt.setObject(7, m.getPhoto());
			stmt.setObject(8, m.getId());
			stmt.executeUpdate();
		}
	}

	// 查找管理员
	public List<Admin> findAll() throws SQLException {
		String sql = "select *  from admins where status <> ?";
		List<Admin> list = new ArrayList<>();
		try (PreparedStatement stmt = DB.getConn().prepareStatement(sql)) {
			stmt.setObject(1, Admin.DELETED);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(covert(rs));
			}
			rs.close();
		}
		return list;
	}

	// 根据id查找管理员
	public Admin findById(int id) throws SQLException {
		String sql = "select * from admins where id = ?";
		Admin m = new Admin();
		try (PreparedStatement stmt = DB.getConn().prepareStatement(sql)) {
			stmt.setObject(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				m = covert(rs);
			}
			rs.close();
		}
		return m;
	}

	public Admin findByEmail(String email) throws SQLException {
		String sql = "select * from admins where email = ?";
		Admin m = null;
		try (PreparedStatement stmt = DB.getConn().prepareStatement(sql)) {
			stmt.setObject(1, email);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				m = covert(rs);
			}
			rs.close();
		}
		return m;
	}

	// 把一行转换成一个Admin对象
	public Admin covert(ResultSet rs) throws SQLException {
		Admin m = new Admin();
		m.setEmail(rs.getString("email"));
		m.setId(rs.getInt("id"));
		m.setPasswd(rs.getString("passwd"));
		m.setPhone(rs.getString("phone"));
		m.setPhoto(rs.getString("photo"));
		m.setQq(rs.getString("qq"));
		m.setRealname(rs.getString("realname"));
		m.setStatus(rs.getInt("status"));
		m.setType(rs.getInt("type"));
		return m;
	}
}
