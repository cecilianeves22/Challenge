package br.com.fiap.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.entity.ContratantesEntity;

public interface ContratantesRepository extends JpaRepository<ContratantesEntity, Long>{

}
