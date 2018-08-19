package br.edu.ufabc.VaiDeBike.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufabc.VaiDeBike.model.entity.Ciclista;

public interface CiclistaRepository extends JpaRepository<Ciclista, Integer>{

}
