package com.lesson4.ex1.dao;

public interface DAO_interface {
   Object read(Object object);
 //  Storage readStorage (Object object);
   void  save(Object object);
   void delete(long id);
   void update(long id);
    Object  findById(long id);
}
