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
//가온엘리베이터
@Configuration
@MapperScan(value="com.actas.ems.mapper.gaon", sqlSessionFactoryRef="gaonSqlSessionFactory")
@EnableTransactionManagement

//성우엘리베이터
public class GaonDataBaseConfig {
    @Bean(name="gaonDataSource")
    @ConfigurationProperties(prefix="spring.gaon.datasource")
    public DataSource masterDataSource() {
        //application.properties에서 정의한 DB 연결 정보를 빌드
        return DataSourceBuilder.create().build();
    }

    @Bean(name="gaonSqlSessionFactory")
    public SqlSessionFactory gaonSqlSessionFactory(@Qualifier("gaonDataSource") DataSource gaonDataSource, ApplicationContext applicationContext) throws Exception{
        //세션 생성 시, 빌드된 DataSource를 세팅하고 SQL문을 관리할 mapper.xml의 경로를 알려준다.
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(gaonDataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:com/actas/ems/mapper/gaon/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name="gaonSqlSessionTemplate")
    public SqlSessionTemplate gaonSqlSessionTemplate(SqlSessionFactory gaonSqlSessionFactory) throws Exception{
        return new SqlSessionTemplate(gaonSqlSessionFactory);
    }

}
