package kr.or.connect.spring_guestbook.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages= {"kr.or.connect.spring_guestbook.dao","kr.or.connect.spring_guestbook.service"})
@Import({DBConfig.class})
public class ApplicationConfig {

}
