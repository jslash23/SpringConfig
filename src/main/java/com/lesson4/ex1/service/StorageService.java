package com.lesson4.ex1.service;

import com.lesson4.ex1.dao.DAO_interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StorageService implements com.lesson4.ex1.service.Service {

   private final DAO_interface dao_interface;

   @Autowired
    public StorageService(@Qualifier("storageDAO") DAO_interface dao_interface) {
        this.dao_interface = dao_interface;
    }

    public Object servRead(String params){
        return dao_interface.read(params);

    }
    @Override
    public void servSave(Object storage) {
        //Object obj = storage;
        dao_interface.save(storage);//
    }

    @Override
    public void servUpdate(long id) {
        dao_interface.update(id);//
    }

    @Override
    public void servDelete(long idn) {
        dao_interface.delete(idn);//
    }
}
