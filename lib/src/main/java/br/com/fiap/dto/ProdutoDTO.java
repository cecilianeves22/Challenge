package br.com.fiap.dto;

import br.com.fiap.entity.ProdutoEntity;

public class ProdutoDTO {
	
	private int id;
	private String nome;
	private Long preco;
	private String descricao;
	private String tipo;
	
	public ProdutoDTO(ProdutoEntity entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.preco = entity.getPreco();
		this.descricao = entity.getDescricao();
		this.tipo = entity.getTipo();
		}
	
	public ProdutoDTO(int id, String nome, Long preco, String descricao, String tipo) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.tipo = tipo;
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

	public Long getPreco() {
		return preco;
	}

	public void setPreco(Long preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}



