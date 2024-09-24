package spring_boot_cicd.config;

import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomSevletConfig implements WebMvcConfigurer{

	/*
	@Override
	public void addFormatters(FormatterRegistry registry) {
		
		//registry.addFormatter();
		
		//LoclaDateTime을 특정 형식으로 처리하기 위한 포캣터 등록
		DateTimeFormatterRegistrar registrar=new DateTimeFormatterRegistrar();
		//원하는 형식으로 포맷터 등록
		registrar.setDateTimeFormatter(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		//포맷터 등록
		registrar.registerFormatters(registry);
		
	}
	*/

	@Override
	public void addCorsMappings(CorsRegistry registry) {
	    // 모든 경로에 대해 CORS 규칙을 적용
	    registry.addMapping("/**")
	        .allowedOrigins("*")  // 모든 출처에서의 요청을 허용
	        .allowedMethods("HEAD", "GET", "POST", "PUT", "DELETE", "OPTIONS")// 허용할 HTTP 메서드 지정
	        .maxAge(300)// preflight 요청의 캐시 시간 설정 (300초)
	        .allowedHeaders("Authorization", "Cache-Control", "Content-Type"); // 허용할 HTTP 헤더 지정
	}

	
	
	

}
