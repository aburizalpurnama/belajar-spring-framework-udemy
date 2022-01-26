package com.rizal.spring.security.demo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.rizal.spring.security.demo")
@PropertySource({"classpath:database.properties"})
public class AppConfig implements WebMvcConfigurer {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    private Environment env;

    // define bean for view resolver
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

    @Bean
    public DataSource dataSource() {

        // create connection pool
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        // set the jdbc driver
        try {
            dataSource.setDriverClass(env.getProperty("jdbc.driver"));
        }
        catch (PropertyVetoException exc) {
            throw new RuntimeException(exc);
        }

        // for sanity's sake, let's log url and user ... just to make sure we are reading the data
        logger.info("jdbc.url=" + env.getProperty("jdbc.url"));
        logger.info("jdbc.user=" + env.getProperty("jdbc.user"));

        // set database connection props
        dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        dataSource.setUser(env.getProperty("jdbc.user"));
        dataSource.setPassword(env.getProperty("jdbc.password"));

        // set connection pool props
        dataSource.setInitialPoolSize(getIntProperty("cp.initialPoolSize"));
        dataSource.setMinPoolSize(getIntProperty("cp.minPoolSize"));
        dataSource.setMaxPoolSize(getIntProperty("cp.maxPoolSize"));
        dataSource.setMaxIdleTime(getIntProperty("cp.maxIdleTime"));

        return dataSource;
    }

    private int getIntProperty(String propsName) {
        String propVal = env.getProperty(propsName);

        // now convert to int
        int intPropVal = Integer.parseInt(propVal);

        return intPropVal;
    }
}
