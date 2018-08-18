package br.edu.ufabc.VaiDeBike.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ufabc.VaiDeBike.model.service.CadastroService;

@Controller
public class CadastroController {
	@Autowired
	private CadastroService cadastroService;
		
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	//@ResponseBody
	//public ModelAndView cadastroBanco() {
	//	ModelAndView mv = new ModelAndView("cadastroBanco");		
	//	return mv;
	//}	
	
	
	@RequestMapping(value = {"/cadastroCiclista"})
	public String cadastroCiclista() {
		return "cadastroCiclista";
	}
	
	@RequestMapping(value = {"/cadastroBicicleta"})
	public String cadastroBicicleta() {
		return "cadastroBicicleta";
	}
	
	@RequestMapping(value = {"/cadastraCiclista"}, method = RequestMethod.POST)
	public String cadastrarUsuario(@RequestParam String nome, @RequestParam String CPF, 
			@RequestParam String celular, @RequestParam String login, @RequestParam String senha) {
		
		cadastroService.cadastroCiclista(nome, CPF, celular, login, senha);
		
		return "index";
	}
	
	@RequestMapping(value = {"/cadastraBicicleta"}, method = RequestMethod.POST)
	public String cadastrarBicicleta(@RequestParam String modelo, @RequestParam String cor, 
			@RequestParam char status, @RequestParam int conservacao) {
		
		cadastroService.cadastroBicicleta(modelo, cor, status, conservacao);
		
		return "index";
	}
	
	
}
