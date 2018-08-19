package br.edu.ufabc.VaiDeBike.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufabc.VaiDeBike.model.entity.Usuario;
import br.edu.ufabc.VaiDeBike.model.repository.CiclistaRepository;

@Service
public class LoginService {
	
	@Autowired
	private CiclistaRepository ciclistaRepository;
	
	// autenticacao
	public boolean verificaLoginSenha(String login, String senha) {
		Usuario us = new Usuario();
		us = ciclistaRepository.findByLogin(login);
		if (us == null) {
			System.out.println("Usuario nao encontrado");
			return false;
		} else {
			if (senha.equals(us.getSenha()))
				return true;
			else
				return false;
		}
	}

	// verifica se login ja foi usado
	public boolean verificaLogin(String login) {
		Usuario us = new Usuario();
		us = ciclistaRepository.findByLogin(login);
		
		if (us == null) {
			return true; // login livre
		} else {
			return false; // login ja cadastrado
		}
	}
}
