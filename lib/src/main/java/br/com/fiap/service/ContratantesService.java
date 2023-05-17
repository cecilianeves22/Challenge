package br.com.fiap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fiap.dao.ContratantesRepository;
import br.com.fiap.dto.ContratantesDTO;
import br.com.fiap.entity.ContratantesEntity;

public class ContratantesService {

	@Autowired
	private ContratantesRepository contratantesRepository;
	
	public ContratantesDTO saveContratantes(ContratantesDTO contratantes) {
		ContratantesEntity contratantesEntity = new ContratantesEntity(contratantes);
		contratantesRepository.save(contratantesEntity);
		return contratantes;
	}

	public List<ContratantesDTO> getAllContratantes() {
		return contratantesRepository.findAll().stream().map(entity -> new ContratantesDTO(entity)).toList();
	}
	
	public List<ContratantesDTO> getAllContratantesId(Long id) {
		return contratantesRepository.findAll().stream().map(entity -> new ContratantesDTO(entity)).toList();
	}
	public ContratantesDTO findById(Long id) {
		 Optional<ContratantesEntity> contratantesEntity = contratantesRepository.findById(id);
		 if(contratantesEntity.isPresent()) {
			 return new ContratantesDTO(contratantesEntity.get());
		 } 
		 return null;
	}
	
	public ContratantesDTO updateContratantes(ContratantesDTO newContratantes, Long id) {
		Optional<ContratantesEntity> contratantesEntityOptional = contratantesRepository.findById(id);
		if(contratantesEntityOptional.isPresent()) {
			ContratantesEntity contrantantesEntity = contratantesEntityOptional.get();
			 contrantantesEntity.setNomeFantasia(newContratantes.getNomeFantasia());
			return newContratantes;
		}
		return null;
		
	}
	
	public ContratantesDTO deleteContratantes(Long id) {
		Optional<ContratantesEntity> contratantesEntityOptional = contratantesRepository.findById(id);
		if(contratantesEntityOptional.isPresent()) {
			ContratantesEntity contratantesEntity = contratantesEntityOptional.get();
			contratantesRepository.delete(contratantesEntity);
			return new ContratantesDTO(contratantesEntity);
		}
		return null;
	}

	
}
