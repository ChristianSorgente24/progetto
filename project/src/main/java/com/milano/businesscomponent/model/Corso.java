package com.milano.businesscomponent.model;

import java.util.Date;
import java.util.Objects;

import com.milano.architecture.dao.DAOConstants;

public class Corso implements DAOConstants {

	private long codCorso;
	private String nomeCorso;
	private Date dataInizioCorso;
	private Date dataFineCorso;
	private Double costoCorso;
	private String aulaCorso;
	private long codDocente;

	public Corso(long codCorso, String nomeCorso, Date dataInizioCorso, Date dataFineCorso, Double costoCorso,
			String aulaCorso, long codDocente) {
		super();
		this.codCorso = codCorso;
		this.nomeCorso = nomeCorso;
		this.dataInizioCorso = dataInizioCorso;
		this.dataFineCorso = dataFineCorso;
		this.costoCorso = costoCorso;
		this.aulaCorso = aulaCorso;
		this.codDocente = codDocente;
	}

	public Corso() {
		super();
	}

	public long getCodCorso() {
		return codCorso;
	}

	public void setCodCorso(long codCorso) {
		this.codCorso = codCorso;
	}

	public String getNomeCorso() {
		return nomeCorso;
	}

	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}

	public Date getDataInizioCorso() {
		return dataInizioCorso;
	}

	public void setDataInizioCorso(Date dataInizioCorso) {
		this.dataInizioCorso = dataInizioCorso;
	}

	public Date getDataFineCorso() {
		return dataFineCorso;
	}

	public void setDataFineCorso(Date dataFineCorso) {
		this.dataFineCorso = dataFineCorso;
	}

	public Double getCostoCorso() {
		return costoCorso;
	}

	public void setCostoCorso(Double costoCorso) {
		this.costoCorso = costoCorso;
	}


	public String getAulaCorso() {
		return aulaCorso;
	}

	public void setAulaCorso(String aulaCorso) {
		this.aulaCorso = aulaCorso;
	}

	public Long getCodDocente() {
		return codDocente;
	}

	public void setCodDocente(Long codDocente) {
		this.codDocente = codDocente;
	}

	public boolean isTerminato() {
		Date oggi = new Date();
		return dataFineCorso.before(oggi);
	}
	
	@Override
	public String toString() {
		return "Corso [codCorso=" + codCorso + ", nomeCorso=" + nomeCorso + ", dataInizioCorso=" + dataInizioCorso
				+ ", dataFineCorso=" + dataFineCorso + ", costoCorso=" + costoCorso + ", commentiCorso=" + ", aulaCorso=" + aulaCorso + ", codDocente=" + codDocente + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(aulaCorso, codCorso, codDocente, costoCorso, dataFineCorso, dataInizioCorso, nomeCorso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;
		return Objects.equals(aulaCorso, other.aulaCorso) && codCorso == other.codCorso
				&& codDocente == other.codDocente && Objects.equals(costoCorso, other.costoCorso)
				&& Objects.equals(dataFineCorso, other.dataFineCorso)
				&& Objects.equals(dataInizioCorso, other.dataInizioCorso) && Objects.equals(nomeCorso, other.nomeCorso);
	}
	
	
	
}
