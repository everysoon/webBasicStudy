package kr.or.soon.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"kr.or.soon.dao","kr.or.soon.service"})
//@Import({DBConfig.class})
public class ApplicationConfig {

}
