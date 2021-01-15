package com.lesson4.ex1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

//наш джава класс который исполняет роль web.xml  знает где находится Спринг конфигурация
    //она находится в springConfig классе
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringConfig.class};
    }
//
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};// "/" означает что все запросы от пользователя
        //мы посылаем на диспетчер Сервлет
    }
}
