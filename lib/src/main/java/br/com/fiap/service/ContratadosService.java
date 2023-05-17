package br.com.fiap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fiap.dao.ContratadosRepository;
import br.com.fiap.dto.ContratadosDTO;
import br.com.fiap.entity.ContratadosEntity;


public class ContratadosService {
	
	@Autowired
	private ContratadosRepository contratadosRepository;
	
	public ContratadosDTO saveContratados(ContratadosDTO contratados) {
		ContratadosEntity contratadosEntity = new ContratadosEntity(contratados);
		contratadosRepository.save(contratadosEntity);
		return contratados;
	}

	public List<ContratadosDTO> getAllContratados() {
		return contratadosRepository.findAll().stream().map(entity -> new ContratadosDTO(entity)).toList();
	}
	
	public List<ContratadosDTO> getAllContratadosId(Long id) {
		return contratadosRepository.findAll().stream().map(entity -> new ContratadosDTO(entity)).toList();
	}
	public ContratadosDTO findById(Long id) {
		 Optional<ContratadosEntity> contratadosEntity = contratadosRepository.findById(id);
		 if(contratadosEntity.isPresent()) {
			 return new ContratadosDTO(contratadosEntity.get());
		 } 
		 return null;
	}
	
	public ContratadosDTO updateContratados(ContratadosDTO newContratados, Long id) {
		Optional<ContratadosEntity> contratadosEntityOptional = contratadosRepository.findById(id);
		if(contratadosEntityOptional.isPresent()) {
			ContratadosEntity contratadosEntity = contratadosEntityOptional.get();
			contratadosEntity.setNome(newContratados.getNome());
			return newContratados;
		}
		return null;
		
	}
	
	public ContratadosDTO deleteContratados(Long id) {
		Optional<ContratadosEntity> contratadosEntityOptional = contratadosRepository.findById(id);
		if(contratadosEntityOptional.isPresent()) {
			ContratadosEntity contratadosEntity = contratadosEntityOptional.get();
			contratadosRepository.delete(contratadosEntity);
			return new ContratadosDTO(contratadosEntity);
		}
		return null;
	}

}
