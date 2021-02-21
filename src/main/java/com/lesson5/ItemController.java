package com.lesson5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController {

    private DAO dao;
    @Autowired
    public ItemController(DAO dao) {
        this.dao = dao;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/save", produces = "text/plain")
    public @ResponseBody
   ResponseEntity <String> save(Item item) {

        item.setDescription("testing item table");
        dao.save(item);
        //HttpStatus statusCode = entity.getStatusCode();
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
}
