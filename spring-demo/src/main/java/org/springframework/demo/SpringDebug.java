package org.springframework.demo;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDebug {
    public static void main(String[] args) {
        // 定位资源
//        ResourceLoader resourceLoader = new DefaultResourceLoader();
//        Resource resource = resourceLoader.getResource("bean.xml");
//
//        // 定义Spring容器
//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//
//        // 加载 -> 解析 -> 注册
//        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
//        beanDefinitionReader.loadBeanDefinitions(resource);
//
//        // 使用
//        Man man = beanFactory.getBean("man", Man.class);
//        man.setName("spring");
//        System.out.println(man.getName());


        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        Man man1 = applicationContext.getBean("man", Man.class);
        man1.setName("spring1");
        System.out.println(man1.getName());


    }
}
