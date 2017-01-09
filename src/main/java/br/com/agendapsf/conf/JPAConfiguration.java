package br.com.agendapsf.conf;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Profile("dev")
public class JPAConfiguration {
	
	
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Properties addProperties) throws URISyntaxException{
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		factoryBean.setDataSource(dataSource);
	
	    factoryBean.setJpaProperties(addProperties);
	    factoryBean.setPackagesToScan("br.com.agendapsf.models");
	     
	     return factoryBean;
	}
	
	@Bean
	@Profile("dev")
	public DataSource dataSource() {
		
		 DriverManagerDataSource dataSource = new DriverManagerDataSource();
		    dataSource.setUsername("root");
		    dataSource.setPassword("");
		    dataSource.setUrl("jdbc:mysql://localhost:3306/agendapsf");
		    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		    
		    return dataSource;
	}

	@Bean	
	@Profile("dev")
	public Properties addProperties() {
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	    props.setProperty("hibernate.show_sql", "true");
	    props.setProperty("hibernate.hbm2ddl.auto", "update");
		return props;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf){
		return new JpaTransactionManager(emf);
		
	}
	

}
