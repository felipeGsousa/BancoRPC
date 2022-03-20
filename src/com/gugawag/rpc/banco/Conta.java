package com.gugawag.rpc.banco;

public class Conta {
    private String numero;
    private double saldo;

    public Conta() {
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
