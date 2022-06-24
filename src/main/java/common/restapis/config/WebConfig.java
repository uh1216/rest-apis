package common.restapis.config;

import common.restapis.api.interceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://sanghabank.com:8080"); //ToDo CORS처리 (나중에 프론트 주소로 바꿔야함)
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginCheckInterceptor())
                .order(1)
                .addPathPatterns("/**") // /하위는 전부 다 인터셉터 적용
                .excludePathPatterns("/css/**", "/*.ico", "/login", "/Members", "/upload"); // 해당 URL은 적용 X
    }
}
