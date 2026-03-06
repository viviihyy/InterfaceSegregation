package service;

import interfaces.ICadastroCliente;

public class ClienteComumService implements ICadastroCliente {
    @Override
    public void cadastrarCliente(String nome, String email) {
        System.out.println("CLIENTE COMUM CADASTRADO COMO: " + nome);
    }

    @Override
    public String buscarClientePorEmail(String email) {
        return "CLIENTE COMUM ENCONTRADO: " +email;
    }
}
