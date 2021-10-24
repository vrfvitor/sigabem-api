package br.com.sigabem.dto;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ViaCepDTO {

    public String cep;

    public String uf;

    public String ddd;

}
