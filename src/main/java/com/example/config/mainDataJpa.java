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
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="mainEntityManagerFactory",
        transactionManagerRef="mainTransactionManager",
        basePackages= { "com.example.respository" }) //不同数据库需要设置Repository所在位置
public class mainDataJpa implements ApplicationContextAware {
    private String sourceName = DataSourceNames.MAIN;
    @Autowired
    private Environment env; //1
    private ApplicationContext applicationContext;

    /**
     * 主 TransactionManager配置 事务配置
     * @param
     * @return
     */
    @Bean
    @Qualifier("mainTransactionManager")
    @Primary
    public PlatformTransactionManager mainTransactionManager(@Qualifier("mainEntityManagerFactory") LocalContainerEntityManagerFactoryBean mainEntityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager(mainEntityManagerFactory.getObject());
        return transactionManager;
    }
    @Bean
    @Qualifier("mainEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean mainEntityManagerFactory(){
        DataSource ds = this.applicationContext.getBean(sourceName, DruidDataSource.class);
//        return builder.dataSource(ds)
//                .properties(getDefaultHibernateProps())
//                .packages("com.example.respository")
//                .build();
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true); //hibernate基本配置
        vendorAdapter.setDatabase(Database.MYSQL);
        vendorAdapter.setShowSql(true);

        LocalContainerEntityManagerFactoryBean factory =
                new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setDataSource(ds);
        factory.setPackagesToScan("com.example.respository","com.example.entity");
//        Properties jpaProperties = new Properties();
//        jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
//        jpaProperties.put("hibernate.show-sql", env.getProperty("hibernate.show-sql"));
//        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
//        factory.setJpaProperties(jpaProperties);
        return factory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
