package com.herokuapp.enviadoremail.api.util;

import com.herokuapp.enviadoremail.api.model.Usuario;

public class FabricaUsuarioPadrao {
	public static final String EMAIL = "enviadoremail.herokuapp.com@gmail.com";
	public static final String SENHA = "brttrxrx";
	
	public static Usuario getUsuarioPadraoInstance() {
		return new Usuario(EMAIL, SENHA);
	}
}
