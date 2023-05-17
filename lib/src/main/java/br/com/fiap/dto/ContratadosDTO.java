package br.com.fiap.dto;

import br.com.fiap.entity.ContratadosEntity;

public class ContratadosDTO {
	
	private int id;
	private String nome;
	
	public ContratadosDTO(ContratadosEntity entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		
	}
	
	public ContratadosDTO(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
