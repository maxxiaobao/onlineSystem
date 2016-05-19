package cn.qdsoft.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.qdsoft.cn.DB;
import cn.qdsoft.model.Phone;

public class PhoneDAO {

	public void insert(Phone p) throws SQLException {
		String sql = "insert into phones(fac_id,name,price,phone_count,description)"
				+ "values(?,?,?,?,?)";
		try (PreparedStatement stmt = DB.getConn().prepareStatement(sql)) {
			stmt.setObject(1, p.getFacId());
			stmt.setObject(2, p.getName());
			stmt.setObject(3, p.getPrice());
			stmt.setObject(4, p.getPhoneCount());
			stmt.setObject(5, p.getDescription());
			stmt.executeUpdate();
		}
	}

	public void delete(int id) throws SQLException {
		String sql = "delete from phones where id = ?";
		try (PreparedStatement stmt = DB.getConn().prepareStatement(sql)) {
			stmt.setObject(1, id);
			stmt.executeUpdate();
		}
	}

	public void update(Phone p) throws SQLException {
		String sql = "update phones set name=?,fac_id=?,"
				+ "price=?,phone_count=?,description=? where id=? ";
		try (PreparedStatement stmt = DB.getConn().prepareStatement(sql)) {
			stmt.setObject(1, p.getName());
			stmt.setObject(2, p.getFacId());
			stmt.setObject(3, p.getPrice());
			stmt.setObject(4, p.getPhoneCount());
			stmt.setObject(5, p.getDescription());
			stmt.setObject(6, p.getId());
			stmt.executeUpdate();
		}
	}

	public Phone findByName(String name) throws SQLException {
		String sql = "select * from phones where name = ?";
		Phone p = null;
		try (PreparedStatement stmt = DB.getConn().prepareStatement(sql)) {
			stmt.setObject(1, name);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				p = new Phone();
				p.setDescription(rs.getString("description"));
				p.setFacId(rs.getInt("fac_id"));
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setPhoneCount(rs.getInt("phone_count"));
				p.setPrice(rs.getDouble("price"));
			}
			rs.close();
		}
		return p;
	}

	public Phone findById(int id) throws SQLException {
		String sql = "select * from phones where id = ?";
		Phone p = null;
		try (PreparedStatement stmt = DB.getConn().prepareStatement(sql)) {
			stmt.setObject(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				p = new Phone();
				p.setDescription(rs.getString("description"));
				p.setFacId(rs.getInt("fac_id"));
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setPhoneCount(rs.getInt("phone_count"));
				p.setPrice(rs.getDouble("price"));
			}
			rs.close();
		}
		return p;
	}

	public List<Phone> findAll() throws SQLException {
		String sql = "select * from phoneVw";
		List<Phone> list = new ArrayList<>();
		try (PreparedStatement stmt = DB.getConn().prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(covert(rs));
			}
			rs.close();
		}
		return list;
	}

	public Phone covert(ResultSet rs) throws SQLException {
		Phone p = new Phone();
		p.setDescription(rs.getString("description"));
		p.setFacId(rs.getInt("fac_id"));
		p.setFacName(rs.getString("fac_name"));
		p.setId(rs.getInt("id"));
		p.setName(rs.getString("name"));
		p.setPhoneCount(rs.getInt("phone_count"));
		p.setPrice(rs.getDouble("price"));
		return p;
	}
}
