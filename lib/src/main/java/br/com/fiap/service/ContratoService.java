package br.com.fiap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fiap.dao.ContratoRepository;
import br.com.fiap.dto.ContratoDTO;
import br.com.fiap.entity.ContratoEntity;

public class ContratoService {
	
	@Autowired
	private ContratoRepository contratoRepository;
	
	public ContratoDTO saveContrato(ContratoDTO contrato) {
		ContratoEntity contratoEntity = new ContratoEntity(contrato);
		contratoRepository.save(contratoEntity);
		return contrato;
	}

	public List<ContratoDTO> getAllContrato() {
		return contratoRepository.findAll().stream().map(entity -> new ContratoDTO(entity)).toList();
	}
	
	public ContratoDTO findById(Long id) {
		 Optional<ContratoEntity> contratoEntity = contratoRepository.findById(id);
		 if(contratoEntity.isPresent()) {
			 return new ContratoDTO(contratoEntity.get());
		 } 
		 return null;
	}
	
	public ContratoDTO updateProduto(ContratoDTO newContrato, Long id) {
		Optional<ContratoEntity> contratoEntityOptional = contratoRepository.findById(id);
		if(contratoEntityOptional.isPresent()) {
			ContratoEntity contratoEntity = contratoEntityOptional.get();
			contratoEntity.setId(newContrato.getId());
			contratoEntity.setDataInicio(newContrato.getDataInicio());
			contratoEntity.setDataFim(newContrato.getDataFim());;
			return newContrato;
		}
		return null;
		
	}
	
	public ContratoDTO deleteProduto(Long id) {
		Optional<ContratoEntity> contratoEntityOptional = contratoRepository.findById(id);
		if(contratoEntityOptional.isPresent()) {
			ContratoEntity contratoEntity = contratoEntityOptional.get();
			contratoRepository.delete(contratoEntity);
			return new ContratoDTO(contratoEntity);
		}
		return null;
	}

	public List<ContratoDTO> getAllContratoID(Long id) {
		return contratoRepository.findAll().stream().map(entity -> new ContratoDTO(entity)).toList();
	}

}
