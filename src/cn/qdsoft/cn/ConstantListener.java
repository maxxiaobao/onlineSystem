package cn.qdsoft.cn;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import cn.qdsoft.dao.ConstantDAO;
import cn.qdsoft.dao.FactoryDAO;

@WebListener
public class ConstantListener implements ServletContextListener {

	private ConstantDAO constantDAO = DAOFactory.getConstantDAO();
	private FactoryDAO factoryDAO = DAOFactory.getFactoryDAO();

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent evt) {
		ServletContext sc = evt.getServletContext();
		try {
			sc.setAttribute("constantMap", constantDAO.findAll());
			sc.setAttribute("factoryList", factoryDAO.findAll());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
