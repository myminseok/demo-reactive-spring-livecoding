package com.example.demoreactivespring;

import car.location.LocationServiceApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LocationServiceApp.class)
public class DemoReactiveSpringApplicationTests {

	@Test
	public void contextLoads() {
	}

}
