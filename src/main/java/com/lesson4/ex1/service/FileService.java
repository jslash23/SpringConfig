package com.lesson4.ex1.service;
import com.lesson4.ex1.dao.DAO_interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FileService implements com.lesson4.ex1.service.Service {

    private final DAO_interface dao_interface;

    @Autowired
    public FileService(@Qualifier("fileDAO") DAO_interface dao_interface) {
        this.dao_interface = dao_interface;
    }


@Override
    public Object servRead(String params){
        return dao_interface.read(params);

    }

    @Override
    public void servSave(Object file)  {

        // TODO: 20.12.2020  
       dao_interface.save(file);//

    }

    @Override
    public void servUpdate(long id) {

      dao_interface.update(id);//
    }

    @Override
    public void servDelete(long idn)  {

        dao_interface.delete(idn);
    }

}
