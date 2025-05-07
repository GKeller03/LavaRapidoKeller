package service;

import model.TipoServico;
import java.util.ArrayList;
import java.util.List;

public class TipoServicoService {
    private List<TipoServico> servicos = new ArrayList<>();

    public void adicionar(TipoServico servico) {
        servicos.add(servico);
    }

    public List<TipoServico> listar() {
        return servicos;
    }
}
