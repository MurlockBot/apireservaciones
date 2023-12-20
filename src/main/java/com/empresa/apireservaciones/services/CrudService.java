package com.empresa.apireservaciones.services;

public interface CrudService<Request, Response, ID> {

    Response create(Request request);

    Response read(ID id);

    void remove(ID id);


}
