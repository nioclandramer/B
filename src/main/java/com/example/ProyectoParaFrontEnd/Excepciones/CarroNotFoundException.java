package com.example.ProyectoParaFrontEnd.Excepciones;

public class CarroNotFoundException extends RuntimeException{
    public CarroNotFoundException(){
        super();
    }
    public CarroNotFoundException(String message){
        super(message);
    }
    public CarroNotFoundException(Throwable cause){
        super(cause);
    }
}
