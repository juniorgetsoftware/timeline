package br.com.timeline;

import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan
@EnableTransactionManagement
@EnableJpaRepositories
public class SpringConfiguration {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource);
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.hbm2ddl.auto", "create-drop");
		jpaProperties.put("hibernate.show_sql", "true");
		// jpaProperties.put("hibernate.format_sql", "true");
		entityManagerFactory.setJpaProperties(jpaProperties);
		entityManagerFactory.setPackagesToScan("br.com.timeline.entity");
		entityManagerFactory.setPersistenceProvider(new HibernatePersistenceProvider());
		return entityManagerFactory;
	}

	@Bean
	public JpaTransactionManager transactionManager(DataSource dataSource, EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory);
		transactionManager.setDataSource(dataSource);
		return transactionManager;
	}

	@Bean
	public DataSource dataSource() {
		DataSource datasource = null;
		try {
			InitialContext e = new InitialContext();
			Context envContext = (Context) e.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/timelineDS");
			datasource = ds;
		} catch (NamingException arg2) {
			arg2.printStackTrace();
		}
		return datasource;
		
//		HikariDataSource dataSource = new HikariDataSource();
//		dataSource.setJdbcUrl("jdbc:mysql://localhost/timeline");
//		dataSource.setUsername("root");
//		dataSource.setPassword("root");
//		return dataSource;
	}

}
