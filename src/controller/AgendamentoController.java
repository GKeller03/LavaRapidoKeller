package controller;

import model.Agendamento;
import service.AgendamentoService;

public class AgendamentoController {
    private AgendamentoService service;

    public AgendamentoController(AgendamentoService service) {
        this.service = service;
    }

    public boolean agendar(Agendamento agendamento) {
        if (service.verificarConflito(agendamento.getDataHora())) {
            return false;
        }
        service.agendar(agendamento);
        return true;
    }
}
