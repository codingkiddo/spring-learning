package com.spring.quickstarts.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

@Configuration
public class MySQLDataSourceConfig {

	@Bean(destroyMethod = "shutdown")
	@Profile("dev")
	public DataSource dataSourceEmbedded() {
		return new EmbeddedDatabaseBuilder()
				.addScript("classpath:db/schema.sql")
				.addScript("classpath:db/test-data.sql")
				.build();
	}
	
	@Bean
	@Profile("prod")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.hibernate.dialect.MySQLDialect");
        dataSource.setUrl("jdbc:mysql://localhost:3306/taco?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("12345678");
        return dataSource;
	}
	
	@Bean(destroyMethod="close")
	@Profile("test")
	public DataSource dataSourceTest() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:h2:tcp://dbserver/~/test");
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUsername("sa");
		dataSource.setPassword("password");
		dataSource.setInitialSize(20);
		dataSource.setMaxTotal(30);
		return dataSource;
	}
}
