package br.com.fiap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.fiap.dto.ContratadosDTO;
import br.com.fiap.service.ContratadosService;


public class ContratadosController {

	@Autowired
	private ContratadosService contratadosService; 
	
	@GetMapping("/contratados")
	ResponseEntity<List<ContratadosDTO>> all() {
		return ResponseEntity.ok(contratadosService.getAllContratados());
	}
	
	@GetMapping("/contratados/{id}")
	ResponseEntity<List<ContratadosDTO>> getcContratantesId(@PathVariable Long id) {
		return ResponseEntity.ok(contratadosService.getAllContratadosId(id));
	}
	
	
	
	@PostMapping("/cadastroContratados")
	public ResponseEntity<ContratadosDTO> newContratantes(@RequestBody ContratadosDTO newContratados) {
		contratadosService.saveContratados(newContratados);
		return ResponseEntity.ok(newContratados);
	}
    
	
	@PutMapping("/contratados/{id}")
	public ResponseEntity<ContratadosDTO> replaceContratantes(@RequestBody ContratadosDTO newContratados, @PathVariable Long id) {
		ContratadosDTO contratadosUpdated = contratadosService.updateContratados(newContratados,id);
		return ResponseEntity.ofNullable(contratadosUpdated);
	}
	
	@DeleteMapping("/contratados/{id}")
	public ResponseEntity<ContratadosDTO> deleteContratantes(@PathVariable Long id) {
		return ResponseEntity.ofNullable(contratadosService.deleteContratados(id));
	}
}
