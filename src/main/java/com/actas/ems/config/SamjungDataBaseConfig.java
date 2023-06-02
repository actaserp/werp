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

//삼정엘리베이터
@Configuration
@MapperScan(value="com.actas.ems.mapper.samjung", sqlSessionFactoryRef="samjungSqlSessionFactory")
@EnableTransactionManagement

public class SamjungDataBaseConfig {
    @Bean(name="samjungDataSource")
    @ConfigurationProperties(prefix="spring.samjung.datasource")
    public DataSource masterDataSource() {
        //application.properties에서 정의한 DB 연결 정보를 빌드
        return DataSourceBuilder.create().build();
    }

    @Bean(name="samjungSqlSessionFactory")
    public SqlSessionFactory samjungSqlSessionFactory(@Qualifier("samjungDataSource") DataSource samjungDataSource, ApplicationContext applicationContext) throws Exception{
        //세션 생성 시, 빌드된 DataSource를 세팅하고 SQL문을 관리할 mapper.xml의 경로를 알려준다.
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(samjungDataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:com/actas/ems/mapper/samjung/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name="samjungSqlSessionTemplate")
    public SqlSessionTemplate samjungSqlSessionTemplate(SqlSessionFactory samjungSqlSessionFactory) throws Exception{
        return new SqlSessionTemplate(samjungSqlSessionFactory);
    }

}
