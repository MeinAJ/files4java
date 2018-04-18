package com.aj.service.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.aj.service.model", sqlSessionTemplateRef = "ajDbSqlSessionTemplate")
public class AjDbDataSource {

	@Bean(name = "ajDbData")
	@ConfigurationProperties(prefix = "spring.datasource")
	@Primary
	public DataSource ajDbDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "ajDbSqlSessionFactory")
	@Primary
	public SqlSessionFactory ajDbSqlSessionFactory(@Qualifier("ajDbData") DataSource dataSource)
			throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean
				.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		return sqlSessionFactoryBean.getObject();
	}

	@Bean(name = "ajDbTransactionManager")
	@Primary
		public DataSourceTransactionManager ajDbTransactionManager(@Qualifier("ajDbData") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "ajDbSqlSessionTemplate")
	@Primary
	public SqlSessionTemplate ajDbSqlSessionTemplate(
			@Qualifier("ajDbSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
