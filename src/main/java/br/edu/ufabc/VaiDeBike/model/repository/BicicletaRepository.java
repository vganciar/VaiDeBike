package br.edu.ufabc.VaiDeBike.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufabc.VaiDeBike.model.entity.Bicicleta;

public interface BicicletaRepository extends JpaRepository<Bicicleta, Integer> {

}
