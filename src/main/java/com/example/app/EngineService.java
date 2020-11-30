package com.example.app;

import org.camunda.bpm.engine.spring.ProcessEngineFactoryBean;
import org.springframework.stereotype.Service;

@Service
public class EngineService {

	public EngineService(ProcessEngineFactoryBean processEngineFactoryBean) {

		processEngineFactoryBean.getProcessEngineConfiguration().buildProcessEngine();
	}

}
