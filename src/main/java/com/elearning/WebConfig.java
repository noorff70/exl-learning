package com.elearning;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/*
 * db configuration
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
    
    @Bean(name = "db1")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource1() {
     return DataSourceBuilder.create().build();
    }
    
    @Bean(name = "jdbcTemplate1")
    public JdbcTemplate jdbcTemplate1(@Qualifier("db1") DataSource ds) {
     return new JdbcTemplate(ds);
    }
    
    @Bean(name = "db2")
    @ConfigurationProperties(prefix = "spring.data.mongodb")
    public DataSource dataSource2() {
     return  DataSourceBuilder.create().build();
    }

    @Bean(name = "mongoTemp")
    public JdbcTemplate mongoTemp(@Qualifier("db2") DataSource ds) {
     return new JdbcTemplate(ds);
    }
}
