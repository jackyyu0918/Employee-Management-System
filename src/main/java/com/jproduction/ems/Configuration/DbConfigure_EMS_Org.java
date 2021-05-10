package com.jproduction.ems.Configuration;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource({ "classpath:persistence-multiple-db.properties" })
@EnableJpaRepositories(
    basePackages = "com.jproduction.ems.Dao.emsOrg", 
    entityManagerFactoryRef = "emsOrgEntityManager", 
    transactionManagerRef = "emsOrgTransactionManager"
)
public class DbConfigure_EMS_Org {
    @Autowired
    private Environment env;
    
    @Bean
    public LocalContainerEntityManagerFactoryBean emsOrgEntityManager() {
        LocalContainerEntityManagerFactoryBean em
          = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(emsOrgDataSource());
        em.setPackagesToScan(
          new String[] { "com.jproduction.ems.Model.emsOrg" });

        HibernateJpaVendorAdapter vendorAdapter
          = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto",
          env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect",
          env.getProperty("hibernate.dialect"));
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    public DataSource emsOrgDataSource() {
 
        DriverManagerDataSource dataSource
          = new DriverManagerDataSource();
        dataSource.setDriverClassName(
          env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.ems_org.jdbcurl"));
        dataSource.setUsername(env.getProperty("spring.datasource.ems_org.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.ems_org.password"));

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager emsOrgTransactionManager() {
 
        JpaTransactionManager transactionManager
          = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
        	emsOrgEntityManager().getObject());
        return transactionManager;
    }
}