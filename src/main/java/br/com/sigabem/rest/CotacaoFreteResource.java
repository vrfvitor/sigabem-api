package br.com.sigabem.rest;

import br.com.sigabem.dto.*;
import br.com.sigabem.services.*;
import io.swagger.annotations.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cotacao-frete")
@Api(value = "cotacao-frete", description = "API REST para cotação de fretes")
public class CotacaoFreteResource {

    private final CotacaoFreteService service;

    @PostMapping("")
    @ApiParam("Dados da entrega")
    public CotacaoFreteDTO gerarCotacao(@RequestBody CotacaoFreteForm form) {
        var cotacao = form.paraEntidade();
        var cotacaoPesistida = service.processarCotacao(cotacao);
        return new CotacaoFreteDTO(cotacaoPesistida);
    }
}
