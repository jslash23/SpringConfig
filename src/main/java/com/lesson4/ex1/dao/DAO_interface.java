package com.lesson4.ex1.dao;

import java.io.IOException;

public interface DAO_interface {
   Object read(Object object) throws IOException;
 //  Storage readStorage (Object object);
   void  save(Object object) throws IOException;
   void delete(long id);
   void update(long id) throws IOException;
    Object  findById(long id) throws IOException;
}
