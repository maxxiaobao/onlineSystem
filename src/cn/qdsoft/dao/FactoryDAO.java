package cn.qdsoft.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.qdsoft.cn.DB;
import cn.qdsoft.model.Factory;

public class FactoryDAO {

	public List<Factory> findAll() throws SQLException {
		String sql = "select * from factory";
		List<Factory> list = new ArrayList<>();
		try (PreparedStatement stmt = DB.getConn().prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Factory f = new Factory();
				f.setId(rs.getInt("id"));
				f.setName(rs.getString("name"));
				list.add(f);
			}
			rs.close();
		}
		return list;
	}
}
