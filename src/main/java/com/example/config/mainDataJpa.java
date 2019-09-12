package com.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.ds.DataSourceNames;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactoryPrimary",
        transactionManagerRef="transactionManagerPrimary",
        basePackages= { "com.example.respository" }) //不同数据库需要设置Repository所在位置
public class mainDataJpa implements ApplicationContextAware {
    private String sourceName = DataSourceNames.MAIN;
    @Autowired
    private Environment env; //1
    private ApplicationContext applicationContext;
    @Bean
    @Qualifier("mainEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(EntityManagerFactoryBuilder builder){
        DataSource ds = this.applicationContext.getBean(sourceName, DruidDataSource.class);
//        return builder.dataSource(ds)
//                .properties(getDefaultHibernateProps())
//                .packages("com.example.respository")
//                .persistenceUnit("com.example.respository")
//                .build();
        LocalContainerEntityManagerFactoryBean factory =
                new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(ds);
        factory.setPackagesToScan("com.example.respository");
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        jpaProperties.put("hibernate.show-sql", env.getProperty("hibernate.show-sql"));
        factory.setJpaProperties(jpaProperties);
        return factory;

    }

    private Map<String,Object> getDefaultHibernateProps(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("hibernate.show-sql",Boolean.TRUE);
        return map;
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
