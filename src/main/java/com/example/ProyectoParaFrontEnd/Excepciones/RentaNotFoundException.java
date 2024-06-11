package com.example.ProyectoParaFrontEnd.Excepciones;

public class RentaNotFoundException extends RuntimeException{
    public RentaNotFoundException(){
        super();
    }
    public RentaNotFoundException(String message){
        super(message);
    }
    public RentaNotFoundException(Throwable cause){
        super(cause);
    }
}
