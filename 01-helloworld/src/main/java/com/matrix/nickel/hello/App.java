package com.matrix.nickel.hello;

import com.matrix.nickel.hello.config.HelloConfig;
import com.matrix.nickel.hello.service.HelloService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 1. 构造方法推断
 * 2. RootBeanDefinition
 * @author nickel
 * @create 2019/11/10 20:12:10
 */
public class App {
	public static void main(String[] args) {
		// 从AnnotationConfigApplicationContext开始，一步一步的分析spring源码
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(HelloConfig.class);
		HelloService service = ctx.getBean(HelloService.class);
		System.out.println(service);
		// com.matrix.nickel.hello.config.HelloConfig$$EnhancerBySpringCGLIB$$1402bc59@629f0666
		// com.matrix.nickel.hello.config.HelloConfig@182decdb
		// HelloConfig加了注解@Configuration打印的是代理类，没加注解是普通类，上面的两行注解表示说明
		System.out.println(ctx.getBean(HelloConfig.class));
	}
}
