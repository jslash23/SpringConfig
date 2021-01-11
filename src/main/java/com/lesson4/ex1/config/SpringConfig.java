package com.lesson4.ex1.config;

import com.lesson4.ex1.models.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.lesson4.ex1")
public class SpringConfig {

//private  SpringConfig springConfig;

    public SpringConfig() {
    }

    @Autowired
   public SpringConfig(ApplicationContext applicationContext){
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

