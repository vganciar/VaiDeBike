package br.edu.ufabc.VaiDeBike.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.ufabc.VaiDeBike.model.entity.Emprestimo;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer>{	
	
	@Query("SELECT e FROM Emprestimo e WHERE id_ciclista = :idCiclista")
    public List<Emprestimo> findAllByCiclista(@Param("idCiclista") int idCiclista);
}
