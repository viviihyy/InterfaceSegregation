package service;

import interfaces.ICadastroCliente;
import interfaces.IGerenciadorFidelidade;
import interfaces.INotificador;

public class ClienteVIPService implements
        ICadastroCliente,
        INotificador,
        IGerenciadorFidelidade {
    @Override
    public void cadastrarCliente(String nome, String email) {
        System.out.println("CLIENTE VIP CADASTRADO COMO:" + nome);
    }

    @Override
    public String buscarClientePorEmail(String email) {
        return "CLIENTE VIP ENCONTRADO: " + email;
    }

    @Override
    public void aplicarDescontoVIP(String email, double percentual) {
        System.out.println("VIP APLICANDO " + percentual + "% DE DESCONTO PARA " + email);
    }

    @Override
    public void enviarNotificacao(String email, String mensagem) {
        System.out.println("NOTIFICAÇÃO ENVIADA PARA: " + email + " - " + mensagem);
    }
}
