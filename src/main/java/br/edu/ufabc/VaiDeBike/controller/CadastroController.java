package br.edu.ufabc.VaiDeBike.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import br.edu.ufabc.VaiDeBike.model.entity.Ponto;
import br.edu.ufabc.VaiDeBike.model.entity.Usuario;
import br.edu.ufabc.VaiDeBike.model.repository.CiclistaRepository;
import br.edu.ufabc.VaiDeBike.model.repository.PontoRepository;
import br.edu.ufabc.VaiDeBike.model.service.CadastroService;
import br.edu.ufabc.VaiDeBike.model.service.SessaoService;

@Controller
public class CadastroController {
	@Autowired
	private CadastroService cadastroService;
	@Autowired
	private PontoRepository pontoRepository;
	@Autowired
	private CiclistaRepository ciclistaRepository;
	@Autowired 
	public SessaoService sessao;
	
	//pagina inicial com login e senha
	@RequestMapping("/") 
	public String index() {
		return "index";
	}	

	//pagina de cadastro de usuario - ciclista
	@RequestMapping(value = {"/cadastroCiclista"}) 
	public String cadastroCiclista() {
		return "cadastroCiclista";
	}
	
	//pagina de cadastro de bicicletas
	@RequestMapping(value = {"/cadastroBicicleta"})
	public ModelAndView cadastroBicicleta() {
		ModelAndView mv = new ModelAndView("cadastroBicicleta");	
		mv.addObject("pto", pontoRepository.findAll());
		return mv;
	}
	
	@RequestMapping(value = {"/cadastraCiclista"}, method = RequestMethod.POST)
	public String cadastrarUsuario(@RequestParam String nome, @RequestParam String CPF, 
			@RequestParam String celular, @RequestParam String login, @RequestParam String senha) {
		
		cadastroService.cadastroCiclista(nome, CPF, celular, login, senha);
		
		return "menu";
	}
	
	@RequestMapping(value = {"/cadastraBicicleta"}, method = RequestMethod.POST)
	public String cadastrarBicicleta(@RequestParam String modelo, @RequestParam String cor, 
			@RequestParam char status, @RequestParam int conservacao, @RequestParam Ponto ponto) {
		
		cadastroService.cadastroBicicleta(modelo, cor, status, conservacao, ponto);
		
		return "cadastroBicicleta";
	}
	
	@ResponseBody
	@RequestMapping(value = {"/Usuario/login"}, method = RequestMethod.POST)
	public String login(@RequestParam String login, @RequestParam String senha) throws Exception {
				
		if(cadastroService.verificaLoginSenha(login, senha)) {
			Usuario us = new Usuario();
			us = ciclistaRepository.findOne(login);
			sessao.logarUser(us);
			System.out.println("LOGADOO**************" + sessao.getUserLogado().getId()+", "+sessao.getUserLogado().getNome());
			return "ok";
			}
		else return "fail";
	}
	
	@ResponseBody
	@RequestMapping(value = {"/Usuario/validaLogin"}, method = RequestMethod.POST)
	public String valida(@RequestParam String login) {		
		if(cadastroService.verificaLogin(login)) return "ok";
		else return "fail";
	}	
	
	//pagina intermediaria temporaria
	@RequestMapping(value = {"/menu"})
	public ModelAndView menu() {
		ModelAndView mv = new ModelAndView("menu");	
		mv.addObject("us", sessao.getUserLogado());
		return mv;
	}
	
	@RequestMapping(value = {"/logout"})   //pagina intermediaria temporaria
	public String logout() throws Exception {
		sessao.logout();
		System.out.println("deslogado ******************");
		System.out.println(sessao.getUserLogado());
		return "index";
	}
	
}
