package br.edu.ufabc.VaiDeBike.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import br.edu.ufabc.VaiDeBike.model.entity.Ponto;
import br.edu.ufabc.VaiDeBike.model.repository.PontoRepository;
import br.edu.ufabc.VaiDeBike.model.service.CadastroService;

@Controller
public class CadastroController {
	
	@Autowired	
	private CadastroService cadastroService;	
		
	@RequestMapping(value = {"/ciclista/cadastrar"}, method = RequestMethod.POST)
	public String cadastrarUsuario(@RequestParam String nome, @RequestParam String CPF, 
			@RequestParam String celular, @RequestParam String login, @RequestParam String senha) {
		
		cadastroService.cadastrarCiclista(nome, CPF, celular, login, senha);
		
		return "menu";
	}
	
	@RequestMapping(value = {"/bicicleta/cadastrar"}, method = RequestMethod.POST)
	public String cadastrarBicicleta(@RequestParam String modelo, @RequestParam String cor, 
			@RequestParam String status, @RequestParam int conservacao, @RequestParam Ponto ponto) {
		
		cadastroService.cadastrarBicicleta(modelo, cor, status, conservacao, ponto);
		
		return "cadastroBicicleta";
	}
}
