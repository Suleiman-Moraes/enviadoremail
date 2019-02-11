package com.herokuapp.enviadoremail.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
}
