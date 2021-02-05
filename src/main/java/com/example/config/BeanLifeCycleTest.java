package com.example.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by lenovo on 2021/1/20.
 */
public class BeanLifeCycleTest implements BeanNameAware, BeanClassLoaderAware, ApplicationContextAware,
        InitializingBean, BeanPostProcessor, DisposableBean {
    private String id;
    //构造函数
    public BeanLifeCycleTest(){
        System.out.println("构造函数");
    }
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("设置类加载器");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("gouz="+bean);
        System.out.println("postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("设置bean名称");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("设置bean属性");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("设置Context");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("来自DisposableBean 销毁");
    }

    //参数注入
    public void setId(String id) {
        this.id = id;
        System.out.println("invoke set method");
    }

    //来自BeanPostProcessor
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("来自BeanPostProcessor postProcessAfterInitialization");
        return bean;
    }

    //bean使用（如此时调用了下面的use方法）
    public void use() {
        System.out.println("use bean");
    }
    //来自注解@PreDestroy
    @PreDestroy
    public void preDestroyMethod() {
        System.out.println("来自注解@PreDestroy");
    }

    //来自bean定义中的配置destroyMethod = "destoryMethod"
    public void destoryMethod() {
        System.out.println("来自bean定义中的配置destroyMethod = \"destoryMethod\"");
    }

    //来自注解@PostConstruct
    @PostConstruct
    public void postConstructMethod() {
        System.out.println("来自注解@PostConstruct");
    }

    //来自配置initMethod = "initMethod"
    public void initMethod() {
        System.out.println("来自配置initMethod = \"initMethod\"");
    }

    @Override
    public String toString() {
        return "BeanLifeCycleTest{" +
                "id='" + id + '\'' +
                '}';
    }
}
