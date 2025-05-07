package main;

import view.ClienteView;
import view.TipoServicoView;
import view.AgendamentoView;

import javax.swing.*;
import model.Cliente;
import model.TipoServico;

public class Main {
    public static void main(String[] args) {
        String[] opcoes = { "Cadastrar Cliente", "Cadastrar Tipo de Serviço", "Agendar Serviço", "Sair" };

        while (true) {
            int escolha = JOptionPane.showOptionDialog(
                null,
                "Selecione uma opção",
                "Menu Principal",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
            );

            if (escolha == 0) {
                ClienteView.mostrarFormulario();
            } else if (escolha == 1) {
                TipoServicoView.mostrarFormulario();
            } else if (escolha == 2) {
                // 🔧 Substitua por seleção real de cliente e serviço depois
                Cliente cliente = new Cliente(1, "João", "12345678900", "99999-9999", "joao@email.com", "ABC1234");
                TipoServico servico = new TipoServico(1, "Lavagem completa", "Lavagem com cera", 60.0);

                AgendamentoView.mostrarFormulario(cliente, servico);
            } else {
                break;
            }
        }
    }
}
