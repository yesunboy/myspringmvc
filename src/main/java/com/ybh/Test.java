package com.ybh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		System.out.println("初始化context....开始");
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-mvc.xml");
		ComboPooledDataSource cpds = (ComboPooledDataSource) context.getBean("oracle");
		try {
			Connection conn = cpds.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from YBH_LY_IMP_GOODS");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("新货品id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("初始化context....结束");
		model.addAttribute("usernamecc", username);
		return "ok";
	}

}