package br.edu.ufabc.VaiDeBike.model.entity;

import java.util.Date;
import java.util.Set;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Repository;
@Repository
@Entity
@DiscriminatorValue("F")
public class Funcionario extends Usuario {

	private Date dataAdmissao;

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
}
