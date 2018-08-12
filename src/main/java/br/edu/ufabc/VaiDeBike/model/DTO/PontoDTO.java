package br.edu.ufabc.VaiDeBike.model.DTO;

import java.time.LocalTime;

public class PontoDTO {
	
	private int id;
	
	private int bicicletasDisponiveis;
	
	private String endereco;
	
	private String latitude;
	
	private String longitude;
	
	private String nome;
	
	private String horaIncial;
	
	private String horaFinal;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	

	public int getBicicletasDisponiveis() {
		return bicicletasDisponiveis;
	}

	public void setBicicletasDisponiveis(int bicicletasDisponiveis) {
		this.bicicletasDisponiveis = bicicletasDisponiveis;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getHoraIncial() {
		return horaIncial;
	}

	public void setHoraIncial(String horaIncial) {
		this.horaIncial = horaIncial;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}
	
}
