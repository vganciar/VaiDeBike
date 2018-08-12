package br.edu.ufabc.VaiDeBike.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.ufabc.VaiDeBike.model.entity.Bicicleta;

public interface BicicletaRepository extends JpaRepository<Bicicleta, Integer> {
	
	@Query("select * from Bicicleta where ponto = ?1")
    List<Bicicleta> findAllByPonto(int idPonto);
}
