package com.example;
public class AppOpLogicos {

    boolean a(boolean valor){
        System.out.println(valor);
        return valor;
    }
    boolean b(boolean valor){
        System.out.println(valor);
        return valor;
    }
    boolean c(boolean valor){
        System.out.println(valor);
        return valor;
    }

    AppOpLogicos(){
        System.out.println(a(true) || b(false) || c(true));
    }

    public static void main(String[] args) {

    new AppOpLogicos();

        
    }
    

    
}