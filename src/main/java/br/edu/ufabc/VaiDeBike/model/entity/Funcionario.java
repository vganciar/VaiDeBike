package br.edu.ufabc.VaiDeBike.model.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Funcionario extends Usuario {

	private Date dataAdmissao;

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
}
