package br.com.sigabem.dto;

import br.com.sigabem.models.*;

public class CotacaoFreteForm {

    public String nomeDestinatario;

    public String cepOrigem;

    public String cepDestino;

    public Double peso;

    public CotacaoFrete paraEntidade() {
        var cotacao =  new CotacaoFrete();
        cotacao.setNomeDestinatario(nomeDestinatario);
        cotacao.setCepOrigem(cepOrigem);
        cotacao.setCepDestino(cepDestino);
        cotacao.setPeso(peso);
        return cotacao;
    }
}
