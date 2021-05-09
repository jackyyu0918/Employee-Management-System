package com.jproduction.ems.Configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class Configure_DB {

	@Autowired
	private Environment env;

	@Bean
	@Primary
	public DataSource firstDataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(env.getProperty("spring.datasource.ems_auth.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.ems_auth.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.ems_auth.password"));
		dataSource.setDriverClassName(env.getProperty("spring.datasource.ems_auth.driver-class-name"));
		return dataSource;
	}

	@Bean
	public DataSource secondDataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(env.getProperty("spring.datasource.ems_org.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.ems_org.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.ems_org.password"));
		dataSource.setDriverClassName(env.getProperty("spring.datasource.ems_org.driver-class-name"));
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplateOne(@Qualifier("firstDataSource") DataSource ds)
	{
		return new JdbcTemplate(ds);
	}

	@Bean
	public JdbcTemplate jdbcTemplateTwo(@Qualifier("secondDataSource") DataSource ds)
	{
		return new JdbcTemplate(ds);
	}
}
