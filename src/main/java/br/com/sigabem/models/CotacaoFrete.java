package br.com.sigabem.models;

import lombok.*;

import javax.persistence.*;
import java.math.*;
import java.time.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cotacao_frete")
public class CotacaoFrete {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "nome_destinatario")
    private String nomeDestinatario;

    @Column(name = "peso")
    private Double peso;

    @Column(name = "cep_origem")
    private String cepOrigem;

    @Column(name = "cep_destino")
    private String cepDestino;

    @Column(name = "vl_total_frete")
    private BigDecimal vlTotalFrete;

    @Column(name = "data_prevista_entrega")
    private LocalDateTime dataPrevistaEntrega;

    @Column(name = "data_consulta")
    private LocalDateTime dataConsulta;

}
