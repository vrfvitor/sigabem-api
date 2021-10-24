# sigabem-api
REST API para transportadora SigaBem

## Sobre
- Projeto roda na porta 8080, raiz "/api"
- Cálculo da cotação com POST na "/cotacao-frete"
- Swagger-ui habilitado
- `@Repository` meramente "semântico", implementação delegada (Spring Data JPA)
- Banco de dados MySQL (pela simplicidade do projeto)
