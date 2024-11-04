package com.example.eCommerceWebsite.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.example.eCommerceWebsite.repository.usersRepo",
        entityManagerFactoryRef = "userEntityMangerFactoryBean",
        transactionManagerRef = "userTransactionManager"
)
public class PersistenceUserConfiguration extends CommonPersistenceConfiguration{

    @Bean(name="userDataSource")
@Primary
    public DataSource userDataSource() {
        return createDataSource(
                "user.datasource.url",
                "user.datasource.driver-class-name",
                "user.datasource.username",
                "user.datasource.password"
        );
    }
    @Primary
    @Bean(name = "userEntityMangerFactoryBean")
    public LocalContainerEntityManagerFactoryBean productEntityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean factoryBean= createEntityManagerFactory(userDataSource(), "com.example.eCommerceWebsite.models.userModel");
        System.out.println(factoryBean);
        return factoryBean;
    }
    @Bean(name = "userTransactionManager")
    @Primary
    public PlatformTransactionManager productTransactionManager(){
        return createTransactionManager(productEntityManagerFactoryBean());
    }
}
