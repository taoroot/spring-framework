package org.springframework.demo;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.demo.controller.ManController;
import org.springframework.demo.temp.TempBean;

@Configuration
@ComponentScan({"org.springframework.demo.controller", "org.springframework.demo.service.impl"})
public class AppStart {

	public static void main(String[] args) {
		startByBeanFactory();
//		startByClassPathXmlApplicationContext();
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
		ManController controller = beanFactory.getBean(ManController.class);
		controller.getMan();
		createBean(beanFactory);
	}

	/**
	 * 基于 ApplicationContext, 通过XML导入
	 */
	public static void startByClassPathXmlApplicationContext() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
		for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}
		ManController controller = applicationContext.getBean(ManController.class);
		controller.getMan();
	}

	/**
	 * 基于 ApplicationContext, 通过注解导入
	 */
	public static void startByAnnotationConfigApplicationContext() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppStart.class);
		for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}
		ManController controller = applicationContext.getBean(ManController.class);
		controller.getMan();
	}

	/**
	 * 测试创建模式
	 */
	public static void createBean(BeanFactory factory) {
		TempBean bean = factory.getBean("bean0", TempBean.class);
		System.out.println("单例模式" + bean);
		bean = factory.getBean("bean0", TempBean.class);
		System.out.println("单例模式" + bean);


		bean = factory.getBean("bean1", TempBean.class);
		System.out.println("原型模式" + bean);
		bean = factory.getBean("bean1", TempBean.class);
		System.out.println("原型模式" + bean);


		bean = factory.getBean("bean2", TempBean.class);
		System.out.println("Static工厂方法模式" + bean);

		bean = factory.getBean("bean3", TempBean.class);
		System.out.println("实例工厂方法模式" + bean);


		bean = factory.getBean("bean4", TempBean.class);
		System.out.println("BeanFactory模式" + bean);


	}
}
