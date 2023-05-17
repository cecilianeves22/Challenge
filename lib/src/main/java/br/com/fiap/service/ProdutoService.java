package br.com.fiap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fiap.dao.ProdutoRepository;
import br.com.fiap.dto.ProdutoDTO;
import br.com.fiap.entity.ProdutoEntity;

public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public ProdutoDTO saveProduto(ProdutoDTO produto) {
		ProdutoEntity produtoEntity = new ProdutoEntity(produto);
		produtoRepository.save(produtoEntity);
		return produto;
	}

	public List<ProdutoDTO> getAllProduto() {
		return produtoRepository.findAll().stream().map(entity -> new ProdutoDTO(entity)).toList();
	}
	
	public ProdutoDTO findById(Long id) {
		 Optional<ProdutoEntity> produtoEntity = produtoRepository.findById(id);
		 if(produtoEntity.isPresent()) {
			 return new ProdutoDTO(produtoEntity.get());
		 } 
		 return null;
	}
	
	public ProdutoDTO updateProduto(ProdutoDTO newProduto, Long id) {
		Optional<ProdutoEntity> produtoEntityOptional = produtoRepository.findById(id);
		if(produtoEntityOptional.isPresent()) {
			ProdutoEntity produtoEntity = produtoEntityOptional.get();
			produtoEntity.setNome(newProduto.getNome());
			produtoEntity.setPreco(newProduto.getPreco());
			produtoEntity.setDescricao(newProduto.getDescricao());
			produtoEntity.setTipo(newProduto.getTipo());
			return newProduto;
		}
		return null;
		
	}
	
	public ProdutoDTO deleteProduto(Long id) {
		Optional<ProdutoEntity> produtoEntityOptional = produtoRepository.findById(id);
		if(produtoEntityOptional.isPresent()) {
			ProdutoEntity produtoEntity = produtoEntityOptional.get();
			produtoRepository.delete(produtoEntity);
			return new ProdutoDTO(produtoEntity);
		}
		return null;
	}

	public List<ProdutoDTO> getAllProdutoID(Long id) {
		return produtoRepository.findAll().stream().map(entity -> new ProdutoDTO(entity)).toList();
	}

}
