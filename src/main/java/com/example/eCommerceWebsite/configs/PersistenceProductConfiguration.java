package com.example.eCommerceWebsite.configs;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.example.eCommerceWebsite.repository.productRepo",
        entityManagerFactoryRef = "productEntityMangerFactoryBean",
        transactionManagerRef = "productTransactionManager"
)
public class PersistenceProductConfiguration extends CommonPersistenceConfiguration{

    @Bean(name="productDataSource")
@Primary
    public DataSource productDataSource() {
        return createDataSource(
                "product.datasource.url",
                "product.datasource.driver-class-name",
                "product.datasource.username",
                "product.datasource.password"
        );
    }
    @Primary
    @Bean(name = "productEntityMangerFactoryBean")
    public LocalContainerEntityManagerFactoryBean productEntityManagerFactoryBean(){
        return createEntityManagerFactory(productDataSource(), "com.example.eCommerceWebsite.models.productModel");
    }
    @Bean(name = "productTransactionManager")
    @Primary
    public PlatformTransactionManager productTransactionManager(){
        return createTransactionManager(productEntityManagerFactoryBean());
    }
}
