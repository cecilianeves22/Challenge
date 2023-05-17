package br.com.fiap.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.fiap.dto.ContratoDTO;
import br.com.fiap.service.ContratoService;


public class ContratoController {
	
	@Autowired
	private ContratoService contratoService; 
	
	@GetMapping("/contrato")
	ResponseEntity<List<ContratoDTO>> all() {
		return ResponseEntity.ok(contratoService.getAllContrato());
	}
	
	@GetMapping("/contrato/{id}")
	ResponseEntity<List<ContratoDTO>> getProdutoId(@PathVariable Long id) {
		return ResponseEntity.ok(contratoService.getAllContratoID(id));
	}
	
	
	
	@PostMapping("/cadastroContrato")
	public ResponseEntity<ContratoDTO> newProduto(@RequestBody ContratoDTO newContrato) {
		contratoService.saveContrato(newContrato);
		return ResponseEntity.ok(newContrato);
	}
    
	
	@PutMapping("/contrato/{id}")
	public ResponseEntity<ContratoDTO> replaceProduto(@RequestBody ContratoDTO newContrato, @PathVariable Long id) {
		ContratoDTO contratoUpdated = contratoService.updateProduto(newContrato,id);
		return ResponseEntity.ofNullable(contratoUpdated);
	}
	
	@DeleteMapping("/contrato/{id}")
	public ResponseEntity<ContratoDTO> deleteProduto(@PathVariable Long id) {
		return ResponseEntity.ofNullable(contratoService.deleteProduto(id));
	}


}
