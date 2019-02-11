package com.herokuapp.enviadoremail.api.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Email implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private String destinatario;
	private String assunto;
	private String corpo;
	
	public Email() {}
	public Email(Usuario usuario, String destinatario, String assunto, String corpo) {
		this.usuario = usuario;
		this.destinatario = destinatario;
		this.assunto = assunto;
		this.corpo = corpo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Email other = (Email) obj;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Email [usuario=" + usuario + ", destinatario=" + destinatario + ", assunto=" + assunto + ", corpo="
				+ corpo + "]";
	}
}
