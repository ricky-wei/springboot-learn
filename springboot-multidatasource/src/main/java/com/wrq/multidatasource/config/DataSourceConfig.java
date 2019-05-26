package com.wrq.multidatasource.config;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Autowired
    Environment env;

    @Bean(name = "primaryDataSource")
    @Primary
    public DataSource createPrimaryDataSource() {

        PooledDataSource dataSource = new PooledDataSource();
        String url = env.getProperty("spring.datasource.primary.db.url");
        String username = env.getProperty("spring.datasource.primary.db.username");
        String password = env.getProperty("spring.datasource.primary.db.password");
        String driverClassName = env.getProperty("spring.datasource.primary.db.driverClassName");

        dataSource.setUrl(url);
        dataSource.setDriver(driverClassName);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "secondDataSource")
    public DataSource createSecondDatasource() {

        PooledDataSource dataSource = new PooledDataSource();
        String url = env.getProperty("spring.datasource.second.db.url");
        String username = env.getProperty("spring.datasource.second.db.username");
        String password = env.getProperty("spring.datasource.second.db.password");
        String driverClassName = env.getProperty("spring.datasource.second.db.driverClassName");

        dataSource.setUrl(url);
        dataSource.setDriver(driverClassName);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
