package todoapp.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

import todoapp.commons.web.error.ReadableErrorAttributes;
import todoapp.commons.web.servlet.ExecutionTimeHandlerInterceptor;
import todoapp.commons.web.servlet.LoggingHandlerInterceptor;
import todoapp.commons.web.view.CommaSeparatedValuesView;
import todoapp.security.UserSessionRepository;
import todoapp.security.web.method.UserSessionArgumentResolver;
import todoapp.security.web.servlet.RolesVerifyHandlerInterceptor;
import todoapp.security.web.servlet.UserSessionFilter;

/**
 * Spring Web MVC 설정
 *
 * @author springrunner.kr@gmail.com
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
	private UserSessionRepository sessionRepository;
	
	public WebMvcConfiguration(UserSessionRepository sessionRepository) {
		this.sessionRepository = sessionRepository;
	}
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolver) {
		resolver.add(new UserSessionArgumentResolver(sessionRepository));
	}

	@Bean
	public ErrorAttributes errorAttributes(MessageSource messageSource) {
		return new ReadableErrorAttributes(messageSource);
	}
	
	@Bean
	public FilterRegistrationBean<UserSessionFilter> userSessionFilter(UserSessionRepository sessionRepository){
		FilterRegistrationBean<UserSessionFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new UserSessionFilter(sessionRepository));
		return registrationBean;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoggingHandlerInterceptor());
		registry.addInterceptor(new ExecutionTimeHandlerInterceptor());
		registry.addInterceptor(new RolesVerifyHandlerInterceptor());
	}

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // ContentNegotiating 관련 설정은 ContentNegotiationCustomizer를 통해 해야한다.
        // 여기서 직접 설정하면, 스프링부트가 구성한 ContentNegotiating 설정이 무시된다.
    }

    /**
     * 스프링부트가 생성한 ContentNegotiatingViewResolver를 조작할 목적으로 작성
     */
    @Configuration
    public static class ContentNegotiationCustomizer {
    	@Autowired
        public void configurer(ContentNegotiatingViewResolver viewResolver) {
        	List<View> views = new ArrayList<>(viewResolver.getDefaultViews());
    		views.add(new CommaSeparatedValuesView());
    		
    		viewResolver.setDefaultViews(views);
        }

    }
}
