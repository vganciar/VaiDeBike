package br.edu.ufabc.VaiDeBike.model.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Repository;
@Repository
@Entity
@DiscriminatorValue("C")
public class Ciclista extends Usuario {

	private Date dataCadastro;
	
	@OneToMany(mappedBy = "ciclista")
	private Set<Emprestimo> emprestimos;

	public Set<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(Set<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}
