package br.com.fiap.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.entity.ContratoEntity;

public interface ContratoRepository extends JpaRepository<ContratoEntity, Long>{

}
