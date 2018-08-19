package br.edu.ufabc.VaiDeBike.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.ufabc.VaiDeBike.model.entity.Ciclista;

public interface CiclistaRepository extends JpaRepository<Ciclista, Integer>{
	
	@Query("SELECT u FROM Usuario u WHERE id = :id")
    public Ciclista findById(@Param("id") int id);
	
	@Query("SELECT u FROM Usuario u WHERE login = :login")
    public Ciclista findByLogin(@Param("login") String login);	
}

