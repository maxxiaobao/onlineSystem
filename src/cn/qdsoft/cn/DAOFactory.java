package cn.qdsoft.cn;

import cn.qdsoft.dao.AdminDAO;
import cn.qdsoft.dao.ConstantDAO;
import cn.qdsoft.dao.FactoryDAO;
import cn.qdsoft.dao.PhoneDAO;

public class DAOFactory {

	private static AdminDAO adminDAO = new AdminDAO();
	private static ConstantDAO constantDAO = new ConstantDAO();
	private static PhoneDAO phoneDAO = new PhoneDAO();
	private static FactoryDAO factoryDAO = new FactoryDAO();

	public static FactoryDAO getFactoryDAO() {
		return factoryDAO;
	}

	public static void setFactoryDAO(FactoryDAO factoryDAO) {
		DAOFactory.factoryDAO = factoryDAO;
	}

	public static PhoneDAO getPhoneDAO() {
		return phoneDAO;
	}

	public static void setPhoneDAO(PhoneDAO phoneDAO) {
		DAOFactory.phoneDAO = phoneDAO;
	}

	public static ConstantDAO getConstantDAO() {
		return constantDAO;
	}

	public static void setConstantDAO(ConstantDAO constantDAO) {
		DAOFactory.constantDAO = constantDAO;
	}

	public static AdminDAO getAdminDAO() {
		return adminDAO;
	}

	public static void setAdminDAO(AdminDAO adminDAO) {
		adminDAO = adminDAO;
	}

}
