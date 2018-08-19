package br.edu.ufabc.VaiDeBike.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.ufabc.VaiDeBike.model.entity.Ponto;

@Repository
public interface PontoRepository extends JpaRepository<Ponto, Integer> {	

}
