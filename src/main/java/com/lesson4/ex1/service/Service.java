package com.lesson4.ex1.service;

public interface Service {

    Object servRead(String params);

    void servSave(Object object);

    void servUpdate(long id);

    void servDelete(long idn);
}
