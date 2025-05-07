package view;

import controller.AgendamentoController;
import model.Agendamento;
import model.Cliente;
import model.TipoServico;
import service.AgendamentoService;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AgendamentoView {
    public static void mostrarFormulario(Cliente cliente, TipoServico tipoServico) {
        AgendamentoService service = new AgendamentoService();
        AgendamentoController controller = new AgendamentoController(service);

        String dataStr = JOptionPane.showInputDialog("Data e hora (formato: yyyy-MM-dd HH:mm)\nExemplo: 2025-05-06 14:30");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dataHora;

        try {
            dataHora = LocalDateTime.parse(dataStr.trim(), formatter); // <- Aqui está o .trim()
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato inválido! Use: yyyy-MM-dd HH:mm\nEx: 2025-05-06 14:30");
            return;
        }

        Agendamento agendamento = new Agendamento(1, cliente, tipoServico, dataHora, "Agendado");

        if (controller.agendar(agendamento)) {
            JOptionPane.showMessageDialog(null, "Agendamento realizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro: Conflito de horário!");
        }
    }
}
