package com.lesson4.ex1.controllers;

import com.lesson4.ex1.models.File;
import com.lesson4.ex1.service.FileService;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/file")
public class FileController {

    private final FileService fileService;

    //тут мы указали что бы Спринг нашел бин  класса FileService и этот бин был
    //внедрен в класс Controller

@Autowired
   public FileController(FileService fileService) {
        this.fileService = fileService;
    }
//@GetMapping("/read")


    @RequestMapping(method = RequestMethod.GET, value = "/read")
    @ResponseBody
    public String doGetFile(@RequestParam String id) throws IOException {
        // метод должен возвращать в окно браузера введенное значение
       // String params = req.getParameter("id");
        fileService.servRead(id);
        return "ID: " + id;
    }




    /*
      @RequestMapping(method = RequestMethod.GET, value = "/readFile")
    public void doGetFile(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // метод должен возвращать в окно браузера введенное значение
        String params = req.getParameter("id");
        resp.getWriter().println(fileService.servRead(params));
    }
     */


    @RequestMapping(method = RequestMethod.POST, value = "/saveFile")
    public void   doPostFile(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        File file = new File();
        //считываем стрим приходящий из Постмана (метод POST)
        //мапим данные Гибернейтом
        //добавляем имя и формат
        //сохраняем в БД
        file.setName(req.getParameter("name"));
        file.setFormat(req.getParameter("format"));
        fileService.servSave(file);
        resp.getWriter().println(file);
        //return  ResponseEntity.ok("Post OK");
    }


    //делаем запрос req.getParameter("fileName") вызываем параметр  "fileName"
    // и по имени которое получили делаем обновление  объекта из БД
    @RequestMapping(method = RequestMethod.PUT,value = "/updateFile")
    public void doPutFile(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        long idServ = Long.parseLong(req.getParameter("id"));
        fileService.servUpdate(idServ);
        resp.getWriter().println(idServ);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteFile")
    public void doDeleteFile(HttpServletRequest req, HttpServletResponse resp) throws HibernateException {

        long idServ = Long.parseLong(req.getParameter("id"));
        fileService.servDelete(idServ);
        //делаем запрос req.getParameter("fileId") вызываем параметр  "fileId"
        // и по айдишнику который получили делаем удаление объекта из БД
    }
}
