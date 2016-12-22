package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.Services.BlogDAOImpl;
import com.niit.Services.ForumDAOImpl;
import com.niit.Services.JobDAOImpl;
import com.niit.Services.UserDAOImpl;
import com.niit.model.Blog;
import com.niit.model.Forum;
import com.niit.model.Job;
import com.niit.model.User;

@Configuration
@ComponentScan("com.niit.*")
@EnableTransactionManagement
public class DBConfig {
	
	@Autowired
	@Bean(name="datasource")

	public DataSource getDataSource() {
	   DriverManagerDataSource dataSource=new DriverManagerDataSource();
	    dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
	    dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	    dataSource.setUsername("MARUTHIVARMAN");
	    dataSource.setPassword("niit");
		return dataSource;
			
	    
	}

	private Properties getHibernateProperties()
	{
		Properties properties=new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		
		properties.put("hibernate.format_sql","true");
		    return properties;
	}

	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder(dataSource);
		  sessionBuilder.addProperties(getHibernateProperties());
		  sessionBuilder.addAnnotatedClass(User.class);
		  sessionBuilder.addAnnotatedClass(Blog.class);
		  sessionBuilder.addAnnotatedClass(Forum.class);
		  sessionBuilder.addAnnotatedClass(Job.class);
		   return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transcationManager=new HibernateTransactionManager(sessionFactory);
		return transcationManager;
	}
	
	
	  @Autowired(required=true)  
	    @Bean(name="userDAO")
	    public UserDAOImpl getUserDAO(SessionFactory sessionFactory) {
		      return new UserDAOImpl(sessionFactory);
	    }
	  
	  @Autowired(required=true)  
	    @Bean(name="blogDAO")
	    public BlogDAOImpl getBlogDAO(SessionFactory sessionFactory) {
		      return new BlogDAOImpl(sessionFactory);
	    }
	  
	  @Autowired(required=true)  
	    @Bean(name="forumDAO")
	    public ForumDAOImpl getForumDAO(SessionFactory sessionFactory) {
		      return new ForumDAOImpl(sessionFactory);
	    }
	  
	  @Autowired(required=true)  
	    @Bean(name="jobDAO")
	    public JobDAOImpl getJobDAO(SessionFactory sessionFactory) {
		      return new JobDAOImpl(sessionFactory);
	    }
	  
	  
		}

