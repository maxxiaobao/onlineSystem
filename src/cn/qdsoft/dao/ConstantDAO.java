package cn.qdsoft.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import cn.qdsoft.cn.DB;

public class ConstantDAO {

	public static Map findAll() throws SQLException {
		String sql = "select * from constants order by type";
		Map map = new HashMap();
		try (PreparedStatement stmt = DB.getConn().prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String type = rs.getString("type");
				Map innerMap = new HashMap();
				if (map.get(type) == null) {
					map.put(type, innerMap);
				}
				innerMap.put(rs.getInt("name"), rs.getString("title"));
			}
			rs.close();
		}
		return map;
	}
}
