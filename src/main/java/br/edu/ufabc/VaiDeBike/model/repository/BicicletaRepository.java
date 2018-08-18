package br.edu.ufabc.VaiDeBike.model.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.ufabc.VaiDeBike.model.entity.Bicicleta;

@Repository
public interface BicicletaRepository extends JpaRepository<Bicicleta, Integer> {	
	
	@Query("SELECT b FROM Bicicleta b WHERE id_ponto = :idPonto")
    public List<Bicicleta> findByPonto(@Param("idPonto") int idPonto);
}