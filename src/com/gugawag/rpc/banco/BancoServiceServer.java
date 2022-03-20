package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    private Map<String, Double> saldoContas;
    private List<Conta> contas;

    public BancoServiceServer() throws RemoteException {
        saldoContas = new HashMap<>();
        saldoContas.put("1", 100.0);
        saldoContas.put("2", 156.0);
        saldoContas.put("3", 950.0);

        contas = new ArrayList<Conta>();
    }

    @Override
    public double saldo(String numConta) throws RemoteException {
        if (contas.size()>0) {
            for(Conta conta: contas) {
                if (conta != null && conta.getNumero().equals(numConta))
                    return conta.getSaldo();
                else return 0;
            }
        }
        return saldoContas.get(numConta);
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        if (contas.size()>0) return contas.size();
        return saldoContas.size();
    }

    @Override
    public void cadastro(String numConta, double saldo) throws RemoteException {
        Conta conta = new Conta();
        conta.setNumero(numConta);
        conta.setSaldo(saldo);
        contas.add(conta);
        System.out.println(String.format("Conta de número %s criada", numConta));
    }

    @Override
    public void removeConta(String numConta) throws RemoteException {
        Conta removConta = new Conta();
        for(Conta conta: contas){
            if (conta != null && conta.getNumero().equals(numConta)) {
                removConta = conta;
            }
        }
        if (removConta != null) contas.remove(removConta);
        System.out.println(String.format("Conta de número %s removida", numConta));
    }

}
