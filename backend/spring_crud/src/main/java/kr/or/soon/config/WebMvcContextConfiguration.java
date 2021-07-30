package kr.or.soon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
@Configuration
@EnableWebMvc
/* 패키지 여러개면 콤마로 중괄호없이, 하나면 중괄호 넣어서 basePackage넣어주기 */
@ComponentScan(basePackages = { "kr.or.soon.controller" })
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter {
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// DefaultServlethandler를 사용하도록 enable.
		// 매핑정보가없는 url요청은 스프링의 DefaultServletHttpRequestHandler가 처리하도록 해줌.
		// 스프링의 DefaultServletHttpRequestHandler는 WAS의 DefaultServlet에 요청을 넘기고,
		// WAS는 DefaultServlet이 static한 자원을 읽을 수 있게 해줌
		configurer.enable();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		/*
		 * web.xml파일에는 모든요청들어오면 이렇게 처리해줘~하고 설정을 해놨는데 servlet-mapping아래 url-pattern이 /로
		 * 되있기때문에 반드시 addResourceHandler에서 아래와 같이 assets/**,css/**,img/**,js/**로 시작하는
		 * url요청은 어플리케이션 루트디렉터리 밑에 /css/ , /img/, /js/ 와같이 디렉터리를 만들어놓고 요청이들어왔을때 위의
		 * 디렉터리에서 찾도록 설정해주는 코드
		 */
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/META-INF/resources/webjars");
		registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
		registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
		registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);

	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// addViewControllers : 특정 url 처리를 컨트롤러 클래스를 작성하지않고 매핑할 수 있게 해줌.

		System.out.println("addViewControllers가 호출됩니다.");
		// viewName ="main"은 어디서 찾냐면 , View정보는 getInternalResourceViewResolver에 있음.
		registry.addViewController("/").setViewName("loginForm");
	}

	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		/*
		 * prefix는 앞쪽에 내용을 붙이고, suffix는 뒤쪽에 내용을 붙임 => /WEB-INF/views/main.jsp
		 */
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
