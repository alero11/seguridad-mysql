package com.service.security.exception;


public class UserNameNotFoundException extends RuntimeException {

     public UserNameNotFoundException(String ex){
        super("El usuario: "+ ex + "no existe en la base de datos");
     }
}