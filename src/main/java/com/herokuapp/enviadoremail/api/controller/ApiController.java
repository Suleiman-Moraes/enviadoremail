package com.herokuapp.enviadoremail.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ApiController {
	@GetMapping
	public String comoProceder() {
		String response = "Assim que funciona o web service enviador de email:\r<br/>\n" + 
				"	-Só funciona se o remetente for um \"gmail\", o destino não importa;\r<br/>\n" + 
				"	-Sem cripitografia, apenas envio de e-mail;\r<br/>\n" + 
				"	-Por ser de graça, pode demorar um pouco, pq o Heroku deixa a aplicação dormindo quando não está em uso.\r<br/>\n" + 
				"	-Tem a opção ultilizando um e-mail padrão da própia API não tem muito segredo.\r<br/>\n" + 
				"	-Este é o JSON ultilizado: {\"usuario\":{\"email\":\"Endereço e-mail remetente\",\"senha\":\"Senha remetente\"},\"destinatario\":\"Endereço e-mail destinatário\",\"assunto\":\"Assunto\",\"corpo\":\"Corpo\"}\r<br/>\n" + 
				"	-URL passando os dados completos: https://enviadoremail.herokuapp.com/api METODO: POST\r<br/>\n" + 
				"	-URL usando e-mail da API: https://enviadoremail.herokuapp.com/api/usaremailpadrao METODO: POST";
		return response;
	}
}
