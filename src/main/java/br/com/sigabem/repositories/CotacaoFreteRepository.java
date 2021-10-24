package br.com.sigabem.repositories;

import br.com.sigabem.models.*;
import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface CotacaoFreteRepository extends CrudRepository<CotacaoFrete, Long> {
}
