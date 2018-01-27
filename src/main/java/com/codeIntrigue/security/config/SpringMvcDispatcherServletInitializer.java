package com.codeIntrigue.security.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
public class SpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return null;
    }


    protected Class<?>[] getServletConfigClasses() {
        //servlet def for dispatcher servlet
        return new Class[] { AppConfig.class };
    }

    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
