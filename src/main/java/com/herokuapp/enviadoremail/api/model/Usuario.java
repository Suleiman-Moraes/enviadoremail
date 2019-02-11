package com.herokuapp.enviadoremail.api.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String email;
	private String senha;
	
	public Usuario() {}
	public Usuario(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Usuario [email=" + email + ", senha=" + senha + "]";
	}
}
