package br.edu.ufabc.VaiDeBike.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import br.edu.ufabc.VaiDeBike.model.entity.Ponto;
<<<<<<< HEAD
=======
import br.edu.ufabc.VaiDeBike.model.entity.Usuario;
import br.edu.ufabc.VaiDeBike.model.repository.CiclistaRepository;
import br.edu.ufabc.VaiDeBike.model.repository.PontoRepository;
>>>>>>> master
import br.edu.ufabc.VaiDeBike.model.service.CadastroService;
import br.edu.ufabc.VaiDeBike.model.service.SessaoService;

@Controller
public class CadastroController {
<<<<<<< HEAD
=======
	@Autowired
	private CadastroService cadastroService;
	
	@Autowired 
	public SessaoService sessao;
		
	@RequestMapping(value = {"/ciclista/cadastrar"}, method = RequestMethod.POST)
	public RedirectView cadastrarUsuario(@RequestParam String nome, @RequestParam String CPF, @RequestParam String celular, @RequestParam String login, @RequestParam String senha) {		
		
		cadastroService.cadastrarCiclista(nome, CPF, celular, login, senha);		

		return new RedirectView("/");
	}
	
	@RequestMapping(value = {"/bicicleta/cadastrar"}, method = RequestMethod.POST)
	public RedirectView cadastrarBicicleta(@RequestParam String modelo, @RequestParam String cor, @RequestParam String status, @RequestParam int conservacao, @RequestParam Ponto ponto) {
		
		cadastroService.cadastrarBicicleta(modelo, cor, status, conservacao, ponto);
		
		return new RedirectView("/bicicleta/cadastro");
	}
	
	@RequestMapping(value = {"/logout"})   //pagina intermediaria temporaria
	public String logout() throws Exception {
		sessao.logout();
		System.out.println("deslogado ******************");
		System.out.println(sessao.getUserLogado());
		
		return "index";
	}
}
