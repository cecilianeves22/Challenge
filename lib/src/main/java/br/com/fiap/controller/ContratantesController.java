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

import br.com.fiap.dto.ContratantesDTO;
import br.com.fiap.service.ContratantesService;;

public class ContratantesController {
	@Autowired
	private ContratantesService contratantesService; 
	
	@GetMapping("/contratantes")
	ResponseEntity<List<ContratantesDTO>> all() {
		return ResponseEntity.ok(contratantesService.getAllContratantes());
	}
	
	@GetMapping("/contratantes/{id}")
	ResponseEntity<List<ContratantesDTO>> getcContratantesId(@PathVariable Long id) {
		return ResponseEntity.ok(contratantesService.getAllContratantesId(id));
	}
	
	
	
	@PostMapping("/cadastroContratantes")
	public ResponseEntity<ContratantesDTO> newContratantes(@RequestBody ContratantesDTO newContratantes) {
		contratantesService.saveContratantes(newContratantes);
		return ResponseEntity.ok(newContratantes);
	}
    
	
	@PutMapping("/contratantes/{id}")
	public ResponseEntity<ContratantesDTO> replaceContratantes(@RequestBody ContratantesDTO newContratantes, @PathVariable Long id) {
		ContratantesDTO contratantesUpdated = contratantesService.updateContratantes(newContratantes,id);
		return ResponseEntity.ofNullable(contratantesUpdated);
	}
	
	@DeleteMapping("/contratantes/{id}")
	public ResponseEntity<ContratantesDTO> deletevContratantes(@PathVariable Long id) {
		return ResponseEntity.ofNullable(contratantesService.deleteContratantes(id));
	}

	
}
