package service;

import model.Agendamento;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoService {
    private List<Agendamento> agendamentos = new ArrayList<>();

    public boolean verificarConflito(LocalDateTime dataHora) {
        for (Agendamento ag : agendamentos) {
            if (ag.getDataHora().equals(dataHora) && ag.getStatus().equals("Agendado")) {
                return true;
            }
        }
        return false;
    }

    public void agendar(Agendamento agendamento) {
        agendamentos.add(agendamento);
    }

    public List<Agendamento> listarPorData(LocalDateTime data) {
        List<Agendamento> result = new ArrayList<>();
        for (Agendamento ag : agendamentos) {
            if (ag.getDataHora().toLocalDate().equals(data.toLocalDate())) {
                result.add(ag);
            }
        }
        return result;
    }
}
