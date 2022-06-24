package com.tp.yogioteur.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// @Mapper를 사용하고 있습니다. 여기에서 Mapper를 찾으세요
@MapperScan(basePackages = {"com.tp.yogioteur.mapper"})

// mybatis/properties/db.properties 파일의 내용을 참조하겠습니다.
@PropertySource(value={"classpath:mybatis/properties/db.properties"})

// TransactionManager를 사용하겠습니다.
@EnableTransactionManagement

@Configuration
public class DBConfig {

	// mybatis/properties/db.properties 파일에 등록된 프로퍼티 값을 변수에 저장합니다.
	// 프로퍼티들은 ${}로 처리합니다.
	@Value(value="${hikariConfig.driverClassName}") private String driverClassName;
	@Value(value="${hikariConfig.jdbcUrl}") private String jdbcUrl;
	@Value(value="${hikariConfig.username}") private String username;
	@Value(value="${hikariConfig.password}") private String password;
	
	
	// HikariCP 환경 설정
	@Bean
	public HikariConfig hikariConfig() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName(driverClassName);
		hikariConfig.setJdbcUrl(jdbcUrl);
		hikariConfig.setUsername(username);
		hikariConfig.setPassword(password);
		return hikariConfig;
	}
	
	// HikariCP DataSource
	@Bean(destroyMethod="close")
	public HikariDataSource dataSource() {
		return new HikariDataSource(hikariConfig());
	}
	
	// SqlSessionFactory
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());  // HikariCP DataSource 전달
		sqlSessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("mybatis/config/mybatis-config.xml"));
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("mybatis/mapper/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}
	
	// SqlSessionTemplate : 지금까지 만든 bean은 모두 이걸 위해서 존재한다.
	// SqlSessionTemplate은 SqlSession을 의미한다.
	// 모든 Repository에서 이 bean을 가져다 사용한다.
	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());
	}
	
	// 트랜잭션 매니저
	// 트랜잭션 매니저의 동작을 위해서 DBConfig에 @EnableTransactionManagement 애너테이션을 추가해야 한다.
	@Bean
	public TransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
}