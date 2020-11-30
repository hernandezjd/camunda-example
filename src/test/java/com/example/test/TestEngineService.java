package com.example.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.app.EngineService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class TestEngineService {

	@Autowired
	private EngineService engineService;

	@Test
	public final void testThatEngineServiceIsAvailable() {

		assertNotNull(engineService);
	}
}
