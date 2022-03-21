package com.milano.businesscomponent.model;

public class Docente {
	private String NomeDocente;
	private String cognomeDocente;
	private String cvDocente;
	private long codDocente;
	
	
	public Docente() {
	}
	public Docente(String nomeDocente, String cognomeDocente, String cvDocente, long codDocente) {
		NomeDocente = nomeDocente;
		this.cognomeDocente = cognomeDocente;
		this.cvDocente = cvDocente;
		this.codDocente = codDocente;
	}

	public String getNomeDocente() {
		return NomeDocente;
	}
	public void setNomeDocente(String nomeDocente) {
		NomeDocente = nomeDocente;
	}
	public String getCognomeDocente() {
		return cognomeDocente;
	}
	public void setCognomeDocente(String cognomeDocente) {
		this.cognomeDocente = cognomeDocente;
	}
	public String getCvDocente() {
		return cvDocente;
	}
	public void setCvDocente(String cvDocente) {
		this.cvDocente = cvDocente;
	}
	public long getCodDocente() {
		return codDocente;
	}
	public void setCodDocente(long codDocente) {
		this.codDocente = codDocente;
	}
	@Override
	public String toString() {
		return "NomeDocente: " + NomeDocente + ", cognomeDocente: " + cognomeDocente + ", cvDocente: " + cvDocente
				+ ", codDocente: " + codDocente ;
	}
	
	
}
