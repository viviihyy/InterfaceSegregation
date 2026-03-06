import interfaces.ICadastroCliente;
import interfaces.INotificador;
import interfaces.IGerenciadorFidelidade;
import service.ClienteComumService;
import service.ClienteVIPService;

public class Main {

    public static void main(String[] args) {

        System.out.println("===== CLIENTE COMUM =====");

        ICadastroCliente clienteComum = new ClienteComumService();
        clienteComum.cadastrarCliente("Luisa", "lulu@gmail.com");
        System.out.println(clienteComum.buscarClientePorEmail("lulu@gmail.com"));


        System.out.println("\n===== CLIENTE VIP =====");

        ICadastroCliente cadastroVIP = new ClienteVIPService();
        INotificador notificadorVIP = new ClienteVIPService();
        IGerenciadorFidelidade fidelidadeVIP = new ClienteVIPService();

        cadastroVIP.cadastrarCliente("Gabrielli", "gabi@gmail.com");
        System.out.println(cadastroVIP.buscarClientePorEmail("gabi@gmail.com"));

        notificadorVIP.enviarNotificacao("gabi@gmail.com", "Promoção especial!");
        fidelidadeVIP.aplicarDescontoVIP("gabi@gmail.com", 20);
    }
}