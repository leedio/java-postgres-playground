package com.example.financeiro.model;
import java.util.*;


public class Transacao {
    
    private Integer id;
    private String cliente;
    private double valor;
    private String moeda;
    private char tipo;


    

    public Transacao(String cliente, double valor, String moeda, char tipo) {
        this.cliente = cliente;
        this.valor = valor;
        this.moeda = moeda;
        this.tipo = tipo;
    }

    public List<Transacao> todasTrasacoes = new ArrayList<>();
    public void adicionarTransacao(Transacao t){
        todasTrasacoes.add(t);
    }
    
    public Integer getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public double getValor() {
        return valor;
    }

    public String getMoeda() {
        return moeda;
    }

    public char getTipo() {
        return tipo;
    }

    public List<Transacao> getTodasTrasacoes() {
        return todasTrasacoes;
    }

    public double getSaldo(String cliente){
        double saldo = 0.0
        for (Transacao t : todasTrasacoes) {
            if(t.cliente.equals(cliente)){
                saldo +=t.valor;
            }
        }
        return saldo;
    }
}
