package zhangyuyao.matrixsb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import zhangyuyao.matrixsb.filter.MyInterceptor;
import zhangyuyao.matrixsb.filter.ThreadIdFilter;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class MatrixSbApplication extends WebMvcConfigurationSupport {

    public static void main(String[] args) {
        log.info("环境变量：{}", Arrays.toString(args));
        SpringApplication.run(MatrixSbApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean getFilterRegistrationBean() {
        FilterRegistrationBean<ThreadIdFilter> filterRegistrationBean = new FilterRegistrationBean<>();

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
