package MainProgram.Configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


@Configuration
public class Configure extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/mybatis/**").addResourceLocations("classpath:/mybatis/");
        registry.addResourceHandler("/FileAll/**").addResourceLocations("file:/D:/FileAll/");
    }
}
