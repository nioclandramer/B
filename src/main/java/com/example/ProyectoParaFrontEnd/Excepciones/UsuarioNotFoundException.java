package com.example.ProyectoParaFrontEnd.Excepciones;

public class UsuarioNotFoundException extends RuntimeException{
    public UsuarioNotFoundException(){
        super();
    }
    public UsuarioNotFoundException(String mensaje){
        super(mensaje);
    }
    public UsuarioNotFoundException(Throwable cause){
        super(cause);
    }
}
