package com.lesson4.ex1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.lesson4.ex1")
public class springConfig {
    @Bean
    ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
/*
    @Bean
    public File file(){
        return new File();
    }

    @Bean
    public Storage storage(){
        return new Storage();
    }

    @Bean
    public FileController fileController(){
        return new FileController(fileService());
    }

    @Bean
    public StorageController storageController(){
        return new StorageController(storageService());
    }

    @Bean
    public FileService fileService(){
        return new FileService(fileDAO());
    }

    @Bean
    public StorageService storageService(){
        return new StorageService(storageDAO());
    }


    @Bean
   public  FileDAO fileDAO(){
        return new FileDAO();
    }

    @Bean
    public StorageDAO storageDAO(){
        return new StorageDAO();
    }
*/

