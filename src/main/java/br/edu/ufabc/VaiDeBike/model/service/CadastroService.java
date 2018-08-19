package br.edu.ufabc.VaiDeBike.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ufabc.VaiDeBike.model.entity.Bicicleta;
import br.edu.ufabc.VaiDeBike.model.entity.Ciclista;
import br.edu.ufabc.VaiDeBike.model.entity.Ponto;
import br.edu.ufabc.VaiDeBike.model.entity.Usuario;
import br.edu.ufabc.VaiDeBike.model.repository.BicicletaRepository;
import br.edu.ufabc.VaiDeBike.model.repository.CiclistaRepository;
import java.sql.Date;
import java.util.Optional;


@Service
public class CadastroService {
	
	@Autowired
	private CiclistaRepository ciclistaRepository;
	@Autowired
	private BicicletaRepository bibicletaRepository;
	
	public void cadastroCiclista(String nome, String CPF, String celular, String login, String senha) {
		
		Ciclista ciclista = new Ciclista();		
		ciclista.setNome(nome);
		ciclista.setCPF(CPF);
		ciclista.setCelular(celular);
		ciclista.setLogin(login);
		ciclista.setSenha(senha);
		Date dataCadastro = new Date(System.currentTimeMillis());  
		ciclista.setDataCadastro(dataCadastro);
		ciclistaRepository.save(ciclista);				
	}
	
	public void cadastroBicicleta(String modelo, String cor, char status, int conservacao, Ponto ponto) {
		
		Bicicleta bicicleta = new Bicicleta();
		bicicleta.setModelo(modelo);
		bicicleta.setCor(cor);
		bicicleta.setStatus(status);
		bicicleta.setConservacao(conservacao);
		Date dataAquisicao = new Date(System.currentTimeMillis());  
		bicicleta.setDataAquisicao(dataAquisicao);
		bicicleta.setPonto(ponto);
		bibicletaRepository.save(bicicleta);
	}
	
	//autenticacao
	public boolean verificaLoginSenha(String login, String senha) {
		Usuario us = new Usuario();
		us = ciclistaRepository.findOne(login);	
		if (us == null) {
			System.out.println("Usuario nao encontrado");
			return false;
		}
		else {
			if(senha.equals(us.getSenha())) return true;
			else return false;
		}	
	}
	
	//no cadastro, verifica se login ja foi usado
	public boolean verificaLogin(String login) {
		Usuario us = new Usuario();
		us = ciclistaRepository.findOne(login);	
		System.out.println("***********************"+us+"******************************");
		if (us == null) { 
			return true; //login livre
		}
		else {			
			return false; //login ja cadastrado
		}
	}
	
}
