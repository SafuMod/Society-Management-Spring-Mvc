package com.springmvc.config;

import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


// config-servlet.xml
@Configuration
@EnableTransactionManagement
@ComponentScan({"com.springmvc"})
public class ServletConfig {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/");
		vr.setSuffix(".jsp");
		return vr;
	}
	
	@Bean
	public DriverManagerDataSource ds() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/smsspringmvc");
		ds.setUsername("root");
		ds.setPassword("admin");
		return ds;
	}
	
	@Bean
	public LocalSessionFactoryBean factory() {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(ds());
		factory.setHibernateProperties(hibernateProperties());
		factory.setAnnotatedClasses(new Class[] {com.springmvc.model.User.class,com.springmvc.model.Role.class, com.springmvc.model.Staff.class, com.springmvc.model.Attendance.class, com.springmvc.model.Notice.class, com.springmvc.model.Complaint.class});
		return factory;
	}
	
	@Bean
	public HibernateTemplate hibernateTemplate() {
		HibernateTemplate ht = new HibernateTemplate();
		ht.setSessionFactory(factory().getObject());
		return ht;
	}
	
	@Bean
	public HibernateTransactionManager hibernateTransaction() {
		HibernateTransactionManager htm = new HibernateTransactionManager();
		htm.setSessionFactory(factory().getObject());
		return htm;
	}
	
	private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
          "hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        hibernateProperties.setProperty(
                "hibernate.hbm2ddl.auto", "update");
        hibernateProperties.setProperty(
        		"hibernate.show_sql","true");
        return hibernateProperties;
    }
	
}
