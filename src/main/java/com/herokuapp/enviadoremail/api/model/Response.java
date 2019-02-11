package com.herokuapp.enviadoremail.api.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
	private Boolean data;
	private List<String> erros;
	
	public List<String> getErros() {
		if(this.erros == null) {
			this.erros = new ArrayList<>();
		}
		return erros;
	}
}
