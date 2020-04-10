package com.elearning;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/*
 * need this class for Tomcat running
 */
public class WebInitializer extends SpringBootServletInitializer { 
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ExlLearningApplication.class);
    } 

}
