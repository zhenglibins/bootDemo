package com.example.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lenovo on 2021/1/20.
 */
@Configuration
public class SpringConfig {
    @Bean(initMethod = "initMethod", destroyMethod = "destoryMethod")
    public BeanLifeCycleTest springBeanLife() {
        BeanLifeCycleTest bean = new BeanLifeCycleTest();
        bean.setId("001");
        return bean;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(SpringConfig.class,DevConfig.class);
        BeanLifeCycleTest ss = ac.getBean(BeanLifeCycleTest.class);
        ss.use();
        ac.close();
    }

}
