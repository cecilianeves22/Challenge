package br.com.fiap.dto;

import br.com.fiap.entity.ContratantesEntity;

public class ContratantesDTO {
	
	private String nomeFantasia;
	private int id;
	
	
	public ContratantesDTO(ContratantesEntity entity) {
		this.id = entity.getId();
		this.nomeFantasia = entity.getNomeFantasia();
	}
	
	public ContratantesDTO(int id, String nomeFantasia) {
		this.id = id;
		this.nomeFantasia = nomeFantasia;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
