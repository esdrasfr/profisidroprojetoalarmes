package br.com.isidrocorp.dashboard.dto;

public class VolumeAlarmes {
	private String nomeAlarme;
	private long   quantidade;
	
	
	public VolumeAlarmes(String nomeAlarme, long quantidade) {
		this.nomeAlarme = nomeAlarme;
		this.quantidade = quantidade;
	}
	
	public String getNomeAlarme() {
		return nomeAlarme;
	}
	public void setNomeAlarme(String nomeAlarme) {
		this.nomeAlarme = nomeAlarme;
	}
	public long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}
	
	

}
