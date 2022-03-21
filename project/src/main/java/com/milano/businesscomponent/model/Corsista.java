package com.milano.businesscomponent.model;

import java.util.Objects;

public class Corsista {
	private String nomeCorsista;
	private String cognomeCorsista;
	private long codCorsista;
	private byte precedentiFormativi;

	public String getNomeCorsista() {
		return nomeCorsista;
	}
	
	public void setNomeCorsista(String nomeCorsista) {
		this.nomeCorsista = nomeCorsista;
	}
	
	public String getCognomeCorsista() {
		return cognomeCorsista;
	}
	
	public void setCognomeCorsista(String cognomeCorsista) {
		this.cognomeCorsista = cognomeCorsista;
	}
	
	public long getCodCorsista() {
		return codCorsista;
	}
	
	public void setCodCorsista(long codCorsista) {
		this.codCorsista = codCorsista;
	}
	
	public byte getPrecedentiFormativi() {
		return precedentiFormativi;
	}

	public void setPrecedentiFormativi(byte precedentiFormativi) {
		this.precedentiFormativi = precedentiFormativi;
	}

	public Corsista(String nomeCorsista, String cognomeCorsista, long codCorsista, byte precedentiFormativi) {
		this.nomeCorsista = nomeCorsista;
		this.cognomeCorsista = cognomeCorsista;
		this.codCorsista = codCorsista;
		this.precedentiFormativi = precedentiFormativi;
	}

	public Corsista() {
	}

	@Override
	public String toString() {
		return "Nome Corsista=" + nomeCorsista + ", cognome Corsista=" + cognomeCorsista + ", codCorsista="
				+ codCorsista + ", precedentiFormativi=" + precedentiFormativi + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codCorsista, cognomeCorsista, nomeCorsista, precedentiFormativi);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corsista other = (Corsista) obj;
		return codCorsista == other.codCorsista && Objects.equals(cognomeCorsista, other.cognomeCorsista)
				&& Objects.equals(nomeCorsista, other.nomeCorsista) && precedentiFormativi == other.precedentiFormativi;
	}
	
	
}
