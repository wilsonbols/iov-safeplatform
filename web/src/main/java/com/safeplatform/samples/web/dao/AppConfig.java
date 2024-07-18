package com.safeplatform.samples.web.dao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import javax.sql.DataSource;

@RefreshScope
@Configuration
public class AppConfig {

    @Value("${postgres.datasourceurl:jdbc:postgresql://db:5432/postgres}")
    private String dataSourceUrl;

    @Value("${postgres.datasourceuser:postgres}")
    private String dataSourceUser;

    @Value("${postgres.datasourcepassword:postgres123}")
    private String dataSourcePassword;



    @Bean()
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(dataSourceUrl);
        dataSource.setUsername(dataSourceUser);
        dataSource.setPassword(dataSourcePassword);
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setConfigLocation(new ClassPathResource("config/mybatis-config.xml"));
        return sessionFactoryBean;
    }

    @Bean
    public MapperFactoryBean<VehicleMapper> vehicleMapper() throws Exception {
        MapperFactoryBean<VehicleMapper> mapperFactoryBean = new MapperFactoryBean<>();
        mapperFactoryBean.setMapperInterface(VehicleMapper.class);
        mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory(dataSource()).getObject());
        return mapperFactoryBean;
    }

    @Bean
    public MapperFactoryBean<CollisionMapper> collisionMapper() throws Exception {
        MapperFactoryBean<CollisionMapper> mapperFactoryBean = new MapperFactoryBean<>();
        mapperFactoryBean.setMapperInterface(CollisionMapper.class);
        mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory(dataSource()).getObject());
        return mapperFactoryBean;
    }


}

