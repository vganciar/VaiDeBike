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
	
	private char status;
	
	@ManyToOne
	@JoinColumn(name="idBicicleta")
	private Bicicleta bicicleta;
	
	@ManyToOne
	@JoinColumn(name="idCiclista")
	private Ciclista ciclista;
	
	@ManyToOne
	@JoinColumn(name="idPonto")
	private Ponto ponto;

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

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
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

	public Ponto getPonto() {
		return ponto;
	}

	public void setPonto(Ponto ponto) {
		this.ponto = ponto;
	}
		
}
