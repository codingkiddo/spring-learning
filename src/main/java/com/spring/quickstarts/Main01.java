package com.spring.quickstarts;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.quickstarts.config.DataSourceConfig;

public class Main01 {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.getEnvironment().setActiveProfiles("prod");

		context.register(DataSourceConfig.class);
		context.refresh();

		DataSource dataSource = context.getBean(DataSource.class);
		System.out.println(dataSource.toString());

		context.close();

	}

}
