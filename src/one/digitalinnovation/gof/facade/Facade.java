package one.digitalinnovation.gof.facade;

import subsistema1.crm.CrmService;
import subsistema2.cep.CepApi;

public class Facade {

    private final CrmService crmService;
    private final CepApi cepApi;

    // Injeção de dependências via construtor
    public Facade(CrmService crmService, CepApi cepApi) {
        this.crmService = crmService;
        this.cepApi = cepApi;
    }

    public void migrarCliente(String nome, String cep) {
        String cidade = cepApi.recuperarCidade(cep);
        String estado = cepApi.recuperarEstado(cep);
        
        crmService.gravarCliente(nome, cep, cidade, estado);
    }
}
