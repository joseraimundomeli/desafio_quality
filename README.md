### Sobre o repositório

#### Documentação
Também disponível em: https://documenter.getpostman.com/view/5131373/TzeUmTtF


#### Desafio Quality

O Desafio quality consiste em avaliar o aprendizado sobre validações, testes unitários e de integração, e rever conceitos aprendidos em aulas anteriores como API e Spring. Para isso, foi proposto o desenvolvimento de uma API Rest para calcular a área e preço de imóveis utilizando dados fictícios.


#### Versionamento

Para versionamento foi utilizado a ferramenta Git e Github, seguindo uma padronização conforme ilustra a figura a baixo. Cada feature foi desenvolvida em uma branch especifica, oriundas de duas branchs principais: **develop** para ambiente de desenvolvimento e **master** para ambiente homologado. 

![code manager img](./img/code_manager.png)


## Executando o projeto 

Nesta seção serão apresentadas como utilizar a API, também é possível testar os endpoints utilizando a ferramenta Postman, sendo necessário importar as configurações para o Postman a partir do arquivo **Quality.postman_collection.json** localizado na pasta principal desse repositório.


### Request Body exemplo

Utilize este request body (payload) como padrão para testar os endpoints.

		{
		  "propName": "Casa Rosada",
		  "propDistrict" : "Bairro A",
		  "roons" : [
			    {
			      "roomName" : "Sala",
			      "roomWidth" : 10.0,
			      "roomLength" : 15.0
			    },
			    {
			      "roomName" : "Quarto Suite",
			      "roomWidth" : 10.0,
			      "roomLength" : 10.0
			    },
			    {
			      "roomName" : "Escritorio",
			      "roomWidth" : 8.0,
			      "roomLength" : 8.0
			    },
			    {
			      "roomName" : "Cozinha",
			      "roomWidth" : 10.0,
			      "roomLength" : 5.0
			    },
			    {
			      "roomName" : "Area de Servico",
			      "roomWidth" : 12.0,
			      "roomLength" : 5.0
			    }
		  ]
	}

### US-001: 

Método http: GET

Endpoint:

	http://localhost:8080/proparea

Request body exemplo: [Aqui :house:](https://github.com/joseraimundomeli/desafio_quality/tree/TASK0009-Documentacao#request-body-exemplo)

Resultado esperado: HTTP STATUS: 200

Response body esperado:

	{
	    "propName": "Casa Rosada",
	    "message": "Total area: 424.0"
	}

### US-002: 

Método http: GET

Endpoint:

	http://localhost:8080/price

Request body exemplo: [Aqui :house:](https://github.com/joseraimundomeli/desafio_quality/tree/TASK0009-Documentacao#request-body-exemplo)

Resultado esperado: HTTP STATUS: 200

Response body esperado:

	{
	    "propName": "Casa Rosada",
	    "message": "Total price: $ 439219.5"
	}


### US-003: 

Método http: GET

Endpoint:

	http://localhost:8080/bigroom

Request body exemplo: [Aqui :house:](https://github.com/joseraimundomeli/desafio_quality/tree/TASK0009-Documentacao#request-body-exemplo)

Resultado esperado: HTTP STATUS: 200

Response body esperado:

	{
	    "roomName": "Quarto Suite",
	    "roomWidth": 17.0,
	    "roomLength": 9.0
	}


### US-004: 

Método http: GET

Endpoint:

	http://localhost:8080/roomsarealist

Request body exemplo: [Aqui :house:](https://github.com/joseraimundomeli/desafio_quality/tree/TASK0009-Documentacao#request-body-exemplo)

Resultado esperado: HTTP STATUS: 200

Response body esperado:

	[
	    {
	        "roomName": "Sala",
	        "size": 150.0
	    },
	    {
	        "roomName": "Quarto Suite",
	        "size": 100.0
	    },
	    {
	        "roomName": "Escritorio",
	        "size": 64.0
	    },
	    {
	        "roomName": "Cozinha",
	        "size": 50.0
	    },
	    {
	        "roomName": "Area de Servico",
	        "size": 60.0
	    }
	]


