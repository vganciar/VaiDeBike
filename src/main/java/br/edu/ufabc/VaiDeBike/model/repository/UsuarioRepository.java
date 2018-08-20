package br.edu.ufabc.VaiDeBike.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.ufabc.VaiDeBike.model.entity.Ciclista;
import br.edu.ufabc.VaiDeBike.model.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	@Query("SELECT u FROM Usuario u WHERE id = :id")
    public Ciclista findById(@Param("id") int id);
	
	@Query("SELECT u FROM Usuario u WHERE login = :login")
    public Ciclista findByLogin(@Param("login") String login);
	
	@Query("SELECT u FROM Usuario u WHERE tipo = :tipo ORDER BY nome")
    public List<Ciclista> findAll(@Param("tipo") String tipo);
}

