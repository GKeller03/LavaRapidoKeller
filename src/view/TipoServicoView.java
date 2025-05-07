package view;

import controller.TipoServicoController;
import model.TipoServico;
import service.TipoServicoService;

import javax.swing.*;

public class TipoServicoView {
    public static void mostrarFormulario() {
        TipoServicoService service = new TipoServicoService();
        TipoServicoController controller = new TipoServicoController(service);

        String nome = JOptionPane.showInputDialog("Nome do serviço:");
        if (nome == null || nome.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nome do serviço é obrigatório.");
            return;
        }

        String descricao = JOptionPane.showInputDialog("Descrição:");
        if (descricao == null || descricao.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Descrição é obrigatória.");
            return;
        }

        String precoStr = JOptionPane.showInputDialog("Preço (mínimo R$ 10,00):");
        if (precoStr == null || precoStr.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preço é obrigatório.");
            return;
        }

        double preco;
        try {
            preco = Double.parseDouble(precoStr.trim());

            // Verifica se o preço é menor que R$ 10,00
            if (preco < 10.0) {
                JOptionPane.showMessageDialog(null, "O preço deve ser maior ou igual a R$ 10,00.");
                return;
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Preço inválido. Digite um número válido, como 50.0");
            return;
        }

        // Criação do objeto TipoServico com as informações fornecidas
        TipoServico servico = new TipoServico(1, nome.trim(), descricao.trim(), preco);
        controller.cadastrar(servico);

        JOptionPane.showMessageDialog(null, "Serviço cadastrado com sucesso!");
    }
}
