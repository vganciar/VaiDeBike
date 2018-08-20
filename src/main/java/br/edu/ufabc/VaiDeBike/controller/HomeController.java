package br.edu.ufabc.VaiDeBike.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ufabc.VaiDeBike.model.entity.Ciclista;
import br.edu.ufabc.VaiDeBike.model.repository.PontoRepository;
import br.edu.ufabc.VaiDeBike.model.repository.UsuarioRepository;
import br.edu.ufabc.VaiDeBike.model.service.LoginService;

@Controller
public class HomeController {
	
	@Autowired
	private PontoRepository pontoRepository;
	
	@Autowired
	private UsuarioRepository ciclistaRepository;
	
	@Autowired
	private LoginService loginService;

	// pagina inicial com login e senha
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	// pagina de cadastro de usuario - ciclista
	@RequestMapping(value = { "/ciclista/cadastro" })
	public String exibeCadastroCiclista() {
		return "cadastroCiclista";
	}
	
	// pagina de pesquisa de ciclistas ADM
	@RequestMapping("/ciclista/list")
	public ModelAndView exibeListCiclistas(){
		
		List<Ciclista> ciclistas = ciclistaRepository.findAll("C");
		
		ModelAndView modelAndView = new ModelAndView("listCiclista");
		modelAndView.addObject("ciclistas", ciclistas);				

		return modelAndView;
	}

	// pagina de cadastro de bicicletas ADM
	@RequestMapping(value = { "/bicicleta/cadastro" })
	public ModelAndView exibeCadastroBicicleta() {
		ModelAndView mv = new ModelAndView("cadastroBicicleta");
		mv.addObject("pto", pontoRepository.findAll());
		return mv;
	}

	@ResponseBody
	@RequestMapping(value = { "/usuario/login" }, method = RequestMethod.POST)
	public String login(@RequestParam String login, @RequestParam String senha) {

		if (loginService.verificaLoginSenha(login, senha))
			return "ok";
		else
			return "fail";
	}

	@ResponseBody
	@RequestMapping(value = { "/usuario/validaLogin" }, method = RequestMethod.POST)
	public String valida(@RequestParam String login) {

		if (loginService.verificaLogin(login))
			return "ok";
		else
			return "fail";
	}

	@RequestMapping(value = { "/mapa" })
	public String mapa() {
		return "mapa";
	}

	@RequestMapping(value = { "/admin" })
	public String admin() {
		return "admin";
	}
}
