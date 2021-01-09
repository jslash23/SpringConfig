package com.lesson4.ex1.controllers;

import com.lesson4.ex1.models.Storage;
import com.lesson4.ex1.service.StorageService;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/ex4stor")
public class StorageController {


    private final StorageService storageService;

    @Autowired
    //тут мы указали что бы Спринг нашел бин  класса StorageService и этот бин был
    //внедрен в класс Controller
    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

   @RequestMapping(method = RequestMethod.GET, value = "/readStorage")
    protected void doGetStorage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // метод должен возвращать в окно браузера введенное значение
        String params = req.getParameter("id");
        resp.getWriter().println(storageService.servRead(params));
    }


    @RequestMapping(method = RequestMethod.POST, value = "/saveStorage")
    protected void doPostStorage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
       Storage storage = new Storage();
        //считываем стрим приходящий из Постмана (метод POST)
        //мапим данные Гибернейтом
        //добавляем ай ди и даты
        //сохраняем в БД

        storage.setStorageCountry(req.getParameter("storage_country"));
        //storage.setFormatSupported(req.getParameter("formatSupported"));
        storageService.servSave(storage);
        resp.getWriter().println(storage);
    }


    //делаем запрос req.getParameter("fileName") вызываем параметр  "fileName"
    // и по имени которое получили делаем обновление  объекта из БД
    @RequestMapping(method = RequestMethod.PUT, value = "/updateStorage")
    protected void doPutStorage(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        long idServ = Long.parseLong(req.getParameter("id"));
        storageService.servUpdate(idServ);
        resp.getWriter().println(idServ);
    }

    //return "POST OK";


    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteStorage")
    protected void doDeleteStorage(HttpServletRequest req, HttpServletResponse resp) throws HibernateException {

        long idServ = Long.parseLong(req.getParameter("id"));
        storageService.servDelete(idServ);

        //делаем запрос req.getParameter("itemId") вызываем параметр  "itemId"
        // и по айдишнику который получили делаем удаление объекта из БД
    }
}
