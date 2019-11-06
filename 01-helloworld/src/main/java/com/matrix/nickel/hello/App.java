package com.matrix.nickel.hello;

import com.matrix.nickel.hello.config.HelloConfig;
import com.matrix.nickel.hello.service.HelloService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		// 从AnnotationConfigApplicationContext开始，一步一步的分析spring源码
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(HelloConfig.class);
		HelloService service = ctx.getBean(HelloService.class);
		System.out.println(service);
	}
}
