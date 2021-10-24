package br.com.sigabem.dto;

import br.com.sigabem.models.*;

import java.math.*;
import java.time.*;

public class CotacaoFreteDTO {

    public String cepOrigem;

    public String cepDestino;

    public BigDecimal vlTotalFrete;

    public LocalDateTime dataPrevistaEntrega;

    public CotacaoFreteDTO(CotacaoFrete cotacao) {
        this.cepOrigem = cotacao.getCepOrigem();
        this.cepDestino = cotacao.getCepDestino();
        this.vlTotalFrete = cotacao.getVlTotalFrete();
        this.dataPrevistaEntrega = cotacao.getDataPrevistaEntrega();
    }
}
