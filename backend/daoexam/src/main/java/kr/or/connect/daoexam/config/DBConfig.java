package kr.or.connect.daoexam.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
// 트랜젝션때문에 필요한거다~ 라는걸 알려주는 어노테이션
@EnableTransactionManagement
public class DBConfig {
 private String driverClassName = "com.mysql.jdbc.Driver";
 private String url ="jdbc:mysql://localhost:3306/springDB?useUnicode=true&character=UTF-8";
 private String userName ="root";
 private String password ="ict01";
 // 데이터 소스를 생성할 수 있는 클래스
 @Bean
 public DataSource dataSource() {
	 BasicDataSource dataSource = new BasicDataSource();
	 dataSource.setDriverClassName(driverClassName);
	 dataSource.setUrl(url);
	 dataSource.setUsername(userName);
	 dataSource.setPassword(password);
	 return dataSource;
 }
}
