package br.edu.ufabc.VaiDeBike.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufabc.VaiDeBike.model.entity.Ciclista;
import br.edu.ufabc.VaiDeBike.model.repository.UsuarioRepository;

@Service
public class LoginService {
	
	@Autowired
	private UsuarioRepository ciclistaRepository;
	
	// autenticacao
	public boolean verificaLoginSenha(String login, String senha) {
		Ciclista ciclista = new Ciclista();
		ciclista = ciclistaRepository.findByLogin(login);
		
		if (ciclista != null && senha.equals(ciclista.getSenha())) {
			
			return true;
		}
		
		return false;
		
	}

	// verifica se login ja foi usado
	public boolean verificaLogin(String login) {
		Ciclista ciclista = new Ciclista();
		ciclista = ciclistaRepository.findByLogin(login);
		
		if (ciclista == null) {
			return true; // login livre
		} else {
			return false; // login ja cadastrado
		}
	}
}
