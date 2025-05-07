package view;

import controller.ClienteController;
import model.Cliente;
import service.ClienteService;
import javax.swing.*;

public class ClienteView {
    public static void mostrarFormulario() {
        ClienteService service = new ClienteService();
        ClienteController controller = new ClienteController(service);

        String nome = JOptionPane.showInputDialog("Nome:");
        String cpf = JOptionPane.showInputDialog("CPF:");
        String telefone = JOptionPane.showInputDialog("Telefone:");
        String email = JOptionPane.showInputDialog("Email:");
        String placa = JOptionPane.showInputDialog("Placa:");

        Cliente cliente = new Cliente(1, nome, cpf, telefone, email, placa);
        controller.cadastrarCliente(cliente);

        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
    }
}
