package controller;

import model.TipoServico;
import service.TipoServicoService;

public class TipoServicoController {
    private TipoServicoService service;

    public TipoServicoController(TipoServicoService service) {
        this.service = service;
    }

    public void cadastrar(TipoServico servico) {
        service.adicionar(servico);
    }

    public void listar() {
        for (TipoServico ts : service.listar()) {
            System.out.println(ts.getNome() + " - R$ " + ts.getPreco());
        }
    }
}
