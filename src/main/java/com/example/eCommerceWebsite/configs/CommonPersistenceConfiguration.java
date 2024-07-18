package com.example.eCommerceWebsite.configs;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class CommonPersistenceConfiguration {
@Autowired
    private Environment environment;

    public DataSource createDataSource(String url, String driverClassName, String username, String password) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(environment.getProperty(url));
        dataSource.setDriverClassName(Objects.requireNonNull(environment.getProperty(driverClassName)));
    dataSource.setUsername(environment.getProperty(username));
    dataSource.setPassword(environment.getProperty(password));
    return dataSource;
    }

    public LocalContainerEntityManagerFactoryBean createEntityManagerFactory(DataSource dataSource,String scanPackage){
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(dataSource);
        bean.setPackagesToScan(scanPackage);

        JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        bean.setJpaVendorAdapter(adapter);

        Map<String,String> props = new HashMap<>();
        props.put("hibernate.show_sql","true");
        props.put("hibernate.hbm2ddl.auto","update");
        bean.setJpaPropertyMap(props);

        return bean;
    }
    public PlatformTransactionManager createTransactionManager(LocalContainerEntityManagerFactoryBean entityManagerFactoryBean){
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactoryBean.getObject());
        return manager;
    }
}
