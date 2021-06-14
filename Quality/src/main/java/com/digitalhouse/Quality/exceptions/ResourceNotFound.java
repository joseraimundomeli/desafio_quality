package com.digitalhouse.Quality.exceptions;

public class ResourceNotFound extends  RuntimeException{
    public ResourceNotFound(){
        super("Recurso não encontrado!");
    }
}
