package br.com.sigabem.rest;

import br.com.sigabem.dto.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;

@Component
@RequiredArgsConstructor
public class ViaCepClient {

    @Value("${viacep.url}")
    private String apiURL;
    private final RestTemplate restTemplate;

    public ViaCepDTO cunsultar(String cep) {
        var url = String.format("%s/%s/json", apiURL, cep);
        return restTemplate.getForObject(url, ViaCepDTO.class);
    }
}
