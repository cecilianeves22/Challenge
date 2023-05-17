package br.com.fiap.entity;

import java.util.Calendar;

import br.com.fiap.dto.ContratoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="T_CONTRATO")
public class ContratoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="dt_inicio")
	private Calendar dataInicio;
	
	@Column(name="dt_fim")
	private Calendar dataFim;
	
	public ContratoEntity() {}
	
	public ContratoEntity(ContratoDTO contrato) {
		this.dataInicio = dataInicio;
		this.dataFim = dataFim; 
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
