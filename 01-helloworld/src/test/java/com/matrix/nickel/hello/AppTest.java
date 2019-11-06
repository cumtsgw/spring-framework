package com.matrix.nickel.hello;

import com.matrix.nickel.hello.config.HelloConfig;
import com.matrix.nickel.hello.service.HelloService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = HelloConfig.class)
public class AppTest {
	@Autowired
	ApplicationContext ctx;

	@Test
	public void helloService(){
		HelloService helloService = ctx.getBean(HelloService.class);
		Assert.assertNotNull(helloService);
	}
}
