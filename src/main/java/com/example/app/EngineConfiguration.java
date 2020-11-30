package com.example.app;

import javax.sql.DataSource;

import org.camunda.bpm.engine.spring.ProcessEngineFactoryBean;
import org.camunda.bpm.engine.spring.SpringProcessEngineConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class EngineConfiguration {

	private DataSource dataSource() {

		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

		dataSource.setDriverClass(org.h2.Driver.class);
		dataSource.setUrl("jdbc:h2:mem:camunda;DB_CLOSE_DELAY=-1");
		dataSource.setUsername("sa");
		dataSource.setPassword("");

		return dataSource;
	}

	private DataSourceTransactionManager transactionManager() {

		return new DataSourceTransactionManager(dataSource());
	}

	private SpringProcessEngineConfiguration processEngineConfiguration() {

		SpringProcessEngineConfiguration config = new SpringProcessEngineConfiguration();

		config.setDataSource(dataSource());
		config.setTransactionManager(transactionManager());

		config.setDatabaseSchemaUpdate("true");
		config.setHistory("audit");
		config.setJobExecutorActivate(true);

		return config;
	}

	@Bean
	public ProcessEngineFactoryBean processEngineFactoryBean() {

		ProcessEngineFactoryBean factoryBean = new ProcessEngineFactoryBean();
		factoryBean.setProcessEngineConfiguration(processEngineConfiguration());
		return factoryBean;
	}

}
