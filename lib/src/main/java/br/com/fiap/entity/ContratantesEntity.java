package br.com.fiap.entity;

import br.com.fiap.dto.ContratantesDTO;
import br.com.fiap.dto.ProdutoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="T_CONTRATANTE")
public class ContratantesEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="nm_contratante")
	private String nomeFantasia;
	
	public ContratantesEntity() {}
	
	public ContratantesEntity(ContratantesDTO contratantes) {
		this.id = id;
		this.nomeFantasia = nomeFantasia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

}
