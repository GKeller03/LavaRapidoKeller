package controller;

import model.Cliente;
import service.ClienteService;

public class ClienteController {
    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void cadastrarCliente(Cliente cliente) {
        clienteService.adicionar(cliente);
    }

    public void listarClientes() {
        for (Cliente c : clienteService.listar()) {
            System.out.println("Cliente: " + c.getNome());
        }
    }
}
