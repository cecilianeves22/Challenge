package br.com.fiap.entity;

import br.com.fiap.dto.ContratadosDTO;
import br.com.fiap.dto.ContratantesDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="T_CONTRATADOS")
public class ContratadosEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="nm_contratados")
	private String nome;
	
	public ContratadosEntity() {}
	
	public ContratadosEntity(ContratadosDTO contratados) {
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
