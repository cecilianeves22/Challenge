package br.com.fiap.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.entity.ContratadosEntity;

public interface ContratadosRepository extends JpaRepository<ContratadosEntity, Long> {

}
