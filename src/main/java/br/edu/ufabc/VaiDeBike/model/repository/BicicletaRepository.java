package br.edu.ufabc.VaiDeBike.model.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.edu.ufabc.VaiDeBike.model.entity.Bicicleta;

public interface BicicletaRepository extends JpaRepository<Bicicleta, Integer> {	
	
	@Query("SELECT b FROM Bicicleta b WHERE id_ponto = :idPonto AND status = 'D'")
    public List<Bicicleta> findByPonto(@Param("idPonto") int idPonto);
}

