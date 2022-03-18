package com.milano.businesscomponent.model;

public class CorsoCorsista {
		private long codCorso;
		private long codCorsista;
		private String commentiCorso;
		
		
		public String getCommentiCorso() {
			return commentiCorso;
		}
		public void setCommentiCorso(String commentiCorso) {
			this.commentiCorso = commentiCorso;
		}
		public long getCodCorsista() {
			return codCorsista;
		}
		public void setCodCorsista(long codCorsista) {
			this.codCorsista = codCorsista;
		}
		public long getCodCorso() {
			return codCorso;
		}
		public void setCodCorso(long codCorso) {
			this.codCorso = codCorso;
		}
		
		@Override
		public String toString() {
			return "CorsoCorsista [codCorsista=" + codCorsista + ", codCorso=" + codCorso + "]";
		}
		
		
		
		
		
		
}
