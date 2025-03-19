package com.spring.quickstarts;

import javax.sql.DataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main02 {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();

		context.getEnvironment().setActiveProfiles("prod");

		context.setConfigLocations("classpath:datasource-configuration.xml");
		context.refresh();

		DataSource dataSource = context.getBean(DataSource.class);
		System.out.println(dataSource.toString());

		context.close();

	}

}
