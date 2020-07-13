package org.springframework.demo;


import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.demo.entity.Man;
import org.springframework.demo.service.IManService;

@Configuration
@ComponentScan("org.springframework.demo.service.impl")
public class AppStart {

	public static void main(String[] args) {
//		startByBeanFactory();
		startByClassPathXmlApplicationContext();
//		startByAnnotationConfigApplicationContext();
	}

	/**
	 * 基于 BeanFactory
	 */
	public static void startByBeanFactory() {
		// 用 BeanFactory 手动使用
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		Resource resource = resourceLoader.getResource("bean.xml");
		// 定义Spring容器
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		// 加载 -> 解析 -> 注册
		XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
		beanDefinitionReader.loadBeanDefinitions(resource);

		for (String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}

		// 使用
		IManService manService = beanFactory.getBean("iManService", IManService.class);
		Man man = manService.getOne("spring");
		System.out.println(man.getName());
	}


	/**
	 * 基于 ApplicationContext, 通过XML导入
	 */
	public static void startByClassPathXmlApplicationContext() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
		IManService manService = applicationContext.getBean("iManService", IManService.class);
		for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}
		Man man = manService.getOne("spring");
		System.out.println(man.getName());
	}

	/**
	 * 基于 ApplicationContext, 注解的调试
	 */
	public static void startByAnnotationConfigApplicationContext() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppStart.class);
		for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}
		IManService manService = applicationContext.getBean("iManService", IManService.class);
		Man man = manService.getOne("spring");
		System.out.println(man.getName());

	}
}
