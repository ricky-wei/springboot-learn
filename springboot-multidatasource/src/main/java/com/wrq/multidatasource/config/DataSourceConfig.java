package com.wrq.multidatasource.config;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
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
    @Qualifier("primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    @Primary
    public DataSource createPrimaryDataSource() {
        return DataSourceBuilder.create().build();
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
