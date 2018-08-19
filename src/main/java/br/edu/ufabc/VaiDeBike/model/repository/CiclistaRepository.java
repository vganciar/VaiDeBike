package br.edu.ufabc.VaiDeBike.model.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.ufabc.VaiDeBike.model.entity.Ciclista;

@Repository
public interface CiclistaRepository extends JpaRepository<Ciclista, Integer> {	
	
	@Query("SELECT u FROM Usuario u WHERE id = :id")
    public List<Ciclista> findById(@Param("id") int id);
	
	@Query("SELECT u FROM Usuario u WHERE login = :login")
    public Ciclista findOne(@Param("login") String login);
	
}