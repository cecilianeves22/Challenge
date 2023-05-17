package br.com.fiap.dto;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.fiap.entity.ContratoEntity;

public class ContratoDTO {
	
	private int id;
	private Calendar dataInicio;
	private Calendar dataFim;
	
	public ContratoDTO(ContratoEntity entity) {
		this.id = entity.getId();
		this.dataInicio = entity.getDataInicio();
		this.dataFim = entity.getDataFim();
	}

	public ContratoDTO(int id,GregorianCalendar gregorianCalendar, GregorianCalendar gregorianCalendar1) {
		this.id = id;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataFim() {
		return dataFim;
	}

	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}

}
