package com.zhangyuyao.remote;

import com.zhangyuyao.remote.filter.MyInterceptor;
import com.zhangyuyao.remote.filter.ThreadIdFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
@ImportResource(locations = "classpath:spring-rabbitmq.xml")
public class RemoteApplication extends WebMvcConfigurationSupport {

	public static void main(String[] args) {
		SpringApplication.run(RemoteApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean getFilterRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

		filterRegistrationBean.setFilter(new ThreadIdFilter());
		filterRegistrationBean.addUrlPatterns("/*");

		return filterRegistrationBean;
	}

	/**
	 * Override this method to add Spring MVC interceptors for
	 * pre- and post-processing of controller invocation.
	 *
	 * @param registry
	 * @see InterceptorRegistry
	 */
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyInterceptor());
		super.addInterceptors(registry);
	}
}
