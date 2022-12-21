package hanghae.simpleproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/images/**.jpg")
                .addResourceLocations("classpath:/static/images/")
                .setCacheControl(CacheControl.maxAge(10, TimeUnit.SECONDS).mustRevalidate());

        registry.addResourceHandler("/images/**.png")
                .addResourceLocations("classpath:/static/images/")
                .setCacheControl(CacheControl.maxAge(20, TimeUnit.SECONDS));

        registry.addResourceHandler("/js/**")
                .addResourceLocations("classpath:/static/js/")
                .setCacheControl(CacheControl.maxAge(30, TimeUnit.SECONDS).mustRevalidate());

    }
}

