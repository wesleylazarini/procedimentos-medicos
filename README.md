# Desafio Automação Procedimentos Medico

Desafio para automatizar o controle de autorizações de procedimentos médicos o plano de saúde.

## Getting Started

```bash
git clone https://github.com/wesleylazarini/procedimentosmedicos.git
```

```bash
cd ProcedimentosMedicos
```

Para executar localhost

```bash
mvnw spring-boot:run
```

Para gerar imagem docker da aplicação

```bash
mvn clean install
```

```bash
docker build -t procedimento-medico:lastest .
```

```bash
docker run -d -p 8080:8080 procedimento-medico:lastest
```

## Utilização

Para cadastro das regras de autorização

```bash
curl --location --request POST 'localhost:8080/autorizador/cadastro' \
	  --header 'Content-Type: application/json' \
	    --data-raw '{
		    "procedimento": 1234,
		    "idade": 10,
		    "sexo": "M",
		    "permitido": "SIM"
		 }'
```

Para solicitações de autorização

```bash
curl --location --request GET 'localhost:8080/autorizador/1234/10/M'
```

