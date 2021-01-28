package com.lesson4.ex1.service;

import java.io.IOException;

public interface Service {

    Object servRead(String params) throws IOException;

    void servSave(Object object) throws IOException;

    void servUpdate(long id) throws IOException;

    void servDelete(long idn);
}
