package br.com.isidrocorp.dashboard.dto;

import java.time.LocalDate;

public class IntervaloDatas {
	private LocalDate dataInicio;
	private LocalDate dataFim;
	
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	public LocalDate getDataFim() {
		return dataFim;
	}
	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}
	
	

}
