package com;

import com.lesson5.DAO;
import com.lesson5.ItemController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.PlatformTransactionManager;
import javax.persistence.EntityManagerFactory;
import java.util.Properties;


@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com"})

public class AppConfig {

    //We create  entityManagerFactory() like SessionFactory
    //с помощю спринга мы связываем EntityManagerFactory и конфиг Спринга
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        //Spring ORM
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        //we add data for connection to DB
        em.setDataSource(dataSource());
        //add package for search where EntityManagerFactory situated
        em.setPackagesToScan(new String[]{"com"});
//standart class for tuning EntityManager
// like:  show sql true or false
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
       // em.setJpaProperties(additionalProperties());
        return em;
    }


    // this Bean is a reference to our Data Base
    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@sl22-database1.cshzc28zzyct.us-east-2.rds.amazonaws.com:1521:ORCL");
        dataSource.setUsername("main");
        dataSource.setPassword("db123slash22");
        return dataSource;
    }

    //Standart Bean for transaction сущность отвечающие за транзакции
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    /*Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect")
        return properties;
    }*/

    @Bean
    public ItemController itemController(){
        return new ItemController();
    }

    @Bean
    public DAO Dao(){
        return new DAO();
    }

}
