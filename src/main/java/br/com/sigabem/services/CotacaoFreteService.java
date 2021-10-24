package br.com.sigabem.services;

import br.com.sigabem.models.*;
import br.com.sigabem.repositories.*;
import br.com.sigabem.rest.*;
import lombok.*;
import org.springframework.stereotype.*;

import java.math.*;
import java.time.*;

@RequiredArgsConstructor
@Service
public class CotacaoFreteService {

    private static final BigDecimal FATOR_DESCONTO_MESMO_UF = BigDecimal.valueOf(75 / 100.0);   // 75%
    private static final BigDecimal FATOR_DESCONTO_MESMO_DDD = BigDecimal.valueOf(50 / 100.0);  // 50%

    private static final Integer DIAS_PRAZO_MESMO_UF = 3;
    private static final Integer DIAS_PRAZO_MESMO_DDD = 1;

    private final CotacaoFreteRepository repository;
    private final ViaCepClient viaCepClient;

    public CotacaoFrete processarCotacao(CotacaoFrete cotacao) {
        var valorTotalParcial = BigDecimal.valueOf(cotacao.getPeso());
        var valorDesconto = BigDecimal.ZERO;
        var diasPrazoEntrega = 10;

        var origem = viaCepClient.cunsultar(cotacao.getCepOrigem());
        var destino = viaCepClient.cunsultar(cotacao.getCepDestino());

        if (origem.uf.equals(destino.uf)) {
            if (origem.ddd.equals(destino.ddd)) {
                valorDesconto = valorTotalParcial.multiply(FATOR_DESCONTO_MESMO_DDD);
                diasPrazoEntrega = DIAS_PRAZO_MESMO_DDD;
            } else {
                valorDesconto = valorTotalParcial.multiply(FATOR_DESCONTO_MESMO_UF);
                diasPrazoEntrega = DIAS_PRAZO_MESMO_UF;
            }
        }

        var valorTotalFinal = valorTotalParcial.subtract(valorDesconto);
        var dataPrevistaEntrega = LocalDateTime.now().plusDays(diasPrazoEntrega);

        cotacao.setVlTotalFrete(valorTotalFinal);
        cotacao.setDataPrevistaEntrega(dataPrevistaEntrega);
        cotacao.setDataConsulta(LocalDateTime.now());

        return repository.save(cotacao);
    }

}
