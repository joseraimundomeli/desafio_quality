package com.digitalhouse.Quality.exceptions;


public class DistrictNotFoundException extends RuntimeException {
    public DistrictNotFoundException(String message){
        super("Bairro: " +message+  " não encontrado!");
    }
}
