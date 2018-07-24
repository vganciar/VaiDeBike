package br.edu.ufabc.VaiDeBike.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Emprestimo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Date dataEmprestimo;
	
	private Date dataDevolucao;
	
	private String status;
	
	@ManyToOne
	@JoinColumn(name="idBicicleta")
	private Bicicleta bicicleta;
	
	@ManyToOne
	@JoinColumn(name="idCiclista")
	private Ciclista ciclista;
	
	@ManyToOne
	@JoinColumn(name="idPonto")
	private Ponto pontoEmprestimo;
	
	@ManyToOne
	@JoinColumn(name="idPonto")
	private Ponto pontoDevolucao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Bicicleta getBicicleta() {
		return bicicleta;
	}

	public void setBicicleta(Bicicleta bicicleta) {
		this.bicicleta = bicicleta;
	}

	public Ciclista getCiclista() {
		return ciclista;
	}

	public void setCiclista(Ciclista ciclista) {
		this.ciclista = ciclista;
	}

	public Ponto getPontoEmprestimo() {
		return pontoEmprestimo;
	}

	public void setPontoEmprestimo(Ponto pontoEmprestimo) {
		this.pontoEmprestimo = pontoEmprestimo;
	}

	public Ponto getPontoDevolucao() {
		return pontoDevolucao;
	}

	public void setPontoDevolucao(Ponto pontoDevolucao) {
		this.pontoDevolucao = pontoDevolucao;
	}			
}
