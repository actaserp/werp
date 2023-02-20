package com.actas.ems.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@MapperScan(value="com.actas.ems.mapper.smsmcs", sqlSessionFactoryRef="smsmcsSqlSessionFactory")
@EnableTransactionManagement


public class SMSDataBaseConfig {
    @Bean(name="smsmcsDataSource")
    @ConfigurationProperties(prefix="spring.smsmcs.datasource")
    public DataSource smsMcsDataSource() {
        //application.properties에서 정의한 DB 연결 정보를 빌드
        return DataSourceBuilder.create().build();
    }

    @Bean(name="smsmcsSqlSessionFactory")
    public SqlSessionFactory smsmcsSqlSessionFactory(@Qualifier("smsmcsDataSource") DataSource smsMcsDataSource, ApplicationContext applicationContext) throws Exception{
        //세션 생성 시, 빌드된 DataSource를 세팅하고 SQL문을 관리할 mapper.xml의 경로를 알려준다.
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(smsMcsDataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:com/actas/ems/mapper/smsmcs/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name="smsmcsSqlSessionTemplate")
    public SqlSessionTemplate smsmcsSqlSessionTemplate(SqlSessionFactory smsmcsSqlSessionFactory) throws Exception{
        return new SqlSessionTemplate(smsmcsSqlSessionFactory);
    }

}
