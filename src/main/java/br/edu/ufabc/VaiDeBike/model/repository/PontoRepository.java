package br.edu.ufabc.VaiDeBike.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufabc.VaiDeBike.model.entity.Ponto;

public interface PontoRepository extends JpaRepository<Ponto, Integer>{

}
