package com.ybh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Controller
public class Test {

	@RequestMapping("/hello")
	private String Index(String username, String password, Model model) {

		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-mvc.xml");
		//ComboPooledDataSource cpds = (ComboPooledDataSource) context.getBean("oracle");
		SqlSessionFactory sessionfactory=(SqlSessionFactory)context.getBean("sqlSessionFactory");

		try {
			SqlSession session = sessionfactory.openSession();
			MybatisTest mapper=session.getMapper(MybatisTest.class); 
			User user=mapper.selectUser(1);
			System.out.println(user.getC5());
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*try {
			Connection conn = cpds.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from y_test");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("c1"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		model.addAttribute("usernamecc", username);
		return "ok";
	}

}