package com.lesson4.ex1;

import com.lesson4.ex1.config.SpringConfig;
import com.lesson4.ex1.controllers.FileController;
import com.lesson4.ex1.controllers.StorageController;
import com.lesson4.ex1.dao.FileDAO;
import com.lesson4.ex1.models.File;
import com.lesson4.ex1.models.Storage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {
   /* public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class
        );

        File file = context.getBean("file", File.class);
        Storage storage = context.getBean("storage", Storage.class);

        FileController fileController = context.getBean("fileController", FileController.class );
        StorageController storageController = context.getBean("storageController", StorageController.class);

        FileDAO fileDAO = context.getBean("fileDAO", FileDAO.class);
        fileController.doGetFile(,);


    }*/
}
