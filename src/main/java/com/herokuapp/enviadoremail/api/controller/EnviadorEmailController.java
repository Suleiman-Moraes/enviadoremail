package com.herokuapp.enviadoremail.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.enviadoremail.api.model.Email;
import com.herokuapp.enviadoremail.api.model.Response;
import com.herokuapp.enviadoremail.api.service.EnviadorEmail;
import com.herokuapp.enviadoremail.api.util.FabricaUsuarioPadrao;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class EnviadorEmailController {
	@Autowired
	private EnviadorEmail enviadorEmail;
	
	@PostMapping
	public ResponseEntity<Response> enviarEmail(@RequestBody Email email) {
		Response response = new Response();
		try {
			enviadorEmail.enviarEmail(email);
			response.setData(Boolean.TRUE);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.setData(Boolean.FALSE);
			response.getErros().add(e.getMessage());
			return ResponseEntity.ok(response);
		}
	}
	
	@PostMapping(value = "/usaremailpadrao")
	public ResponseEntity<Response> enviarEmailComEmailPadrao(@RequestBody Email email) {
		Response response = new Response();
		try {
			email.setUsuario(FabricaUsuarioPadrao.getUsuarioPadraoInstance());
			enviadorEmail.enviarEmail(email);
			response.setData(Boolean.TRUE);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.setData(Boolean.FALSE);
			response.getErros().add(e.getMessage());
			return ResponseEntity.ok(response);
		}
	}
	
	@GetMapping
	public String comoProceder() {
		String response = "Assim que funciona o web service enviador de email:\r\n<br/>" + 
				"   -Só funciona se o remetente for um \"gmail\", o destino não importa;\r\n<br/>" + 
				"   -Sem cripitografia, apenas envio de e-mail;\r\n<br/>" + 
				"   -Por ser de graça, pode demorar um pouco, pq o Heroku deixa a aplicação dormindo quando não está em uso.\r\n<br/>" + 
				"   -Tem a opção ultilizando um e-mail padrão da própia API não tem muito segredo.\r\n<br/>" + 
				"   -Este é o JSON ultilizado: {\"usuario\":{\"email\":\"Endereço e-mail remetente\",\"senha\":\"Senha remetente\"},\"destinatario\":\"Endereço e-mail destinatário\",\"assunto\":\"Assunto\",\"corpo\":\"Corpo\"}";
		return response;
	}
}
