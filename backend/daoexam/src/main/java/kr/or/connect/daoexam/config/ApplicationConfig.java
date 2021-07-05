package kr.or.connect.daoexam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
// 설정파일을 여러개로 나눠 사용할 수 있도록 import 사용
// DB설정파일을 import하자.
@Import({DBConfig.class})
@ComponentScan(basePackages= {"kr.or.connect.daoexam.dao"})
public class ApplicationConfig {

}
