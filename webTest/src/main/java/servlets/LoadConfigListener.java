package servlets;

import java.io.InputStream;
import java.util.Properties;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class LoadConfigListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		Properties properties = new Properties();
		
		try {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
			if(inputStream != null) {
				properties.load(inputStream);
			}
			String pass = properties.getProperty("jdbc.password");
			System.out.println(pass);
			sce.getServletContext().setAttribute("dbUrl", properties.getProperty("jdbc.url"));
			sce.getServletContext().setAttribute("dbUser", properties.getProperty("jdbc.username"));
			sce.getServletContext().setAttribute("dbPass", pass);
			sce.getServletContext().setAttribute("dbDriver", properties.getProperty("jdbc.driver"));
			Class.forName(properties.getProperty("jdbc.driver"));
		}catch(Exception e) {
			
		}
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
}
