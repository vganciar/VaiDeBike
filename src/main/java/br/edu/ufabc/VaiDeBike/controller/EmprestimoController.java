package br.edu.ufabc.VaiDeBike.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ufabc.VaiDeBike.model.entity.Bicicleta;
import br.edu.ufabc.VaiDeBike.model.entity.Ciclista;
import br.edu.ufabc.VaiDeBike.model.entity.Emprestimo;
import br.edu.ufabc.VaiDeBike.model.entity.Ponto;
import br.edu.ufabc.VaiDeBike.model.service.EmprestimoService;

@Controller
public class EmprestimoController {
	
	private EmprestimoService emprestimoService;
	
	@Autowired
	public EmprestimoController(EmprestimoService emprestimoService) {		
		this.emprestimoService = emprestimoService;
	}
	
	@RequestMapping("/")
	public String exibeMapa(){		
		return "mapa";
	}
	
	@RequestMapping("/emprestimo/{ponto}")
	public ModelAndView exibeEmprestimo(@PathVariable("ponto") String idPonto){
		
		List<Bicicleta> bicicletas = emprestimoService.findBicicletasByPonto(Integer.parseInt(idPonto));		
		Ponto ponto = emprestimoService.findPontoById(Integer.parseInt(idPonto));
		
		ModelAndView modelAndView = new ModelAndView("emprestimo");
		modelAndView.addObject("bicicletas", bicicletas);
		modelAndView.addObject("ponto", ponto);		

		return modelAndView;
	}
	
	@RequestMapping("/devolucao/{ciclista}")
	public ModelAndView exibeDevolucao(@PathVariable("ciclista") String idCiclista){
		
		List<Emprestimo> emprestimos = emprestimoService.findEmprestimosByCiclista(Integer.parseInt(idCiclista));		
		List<Ponto> pontos = emprestimoService.findPontos();
		Ciclista ciclista = emprestimoService.findCiclistaById(Integer.parseInt(idCiclista));
		
		ModelAndView modelAndView = new ModelAndView("devolucao");
		modelAndView.addObject("pontos", pontos);
		modelAndView.addObject("emprestimos", emprestimos);
		modelAndView.addObject("ciclista", ciclista);		

		return modelAndView;
	}
	
	@RequestMapping(value = "/reservar/{bicicleta}", method = RequestMethod.POST)
	public String reservarBicicleta(Ponto ponto, @PathVariable("bicicleta") String idBicicleta){
		
		emprestimoService.reservarBicicleta(ponto, Integer.parseInt(idBicicleta));
		
		return "mapa";
	}
	
	@RequestMapping(value = "/devolver/{emprestimo}", method = RequestMethod.POST)
	public String devolverBicicleta(Ponto ponto, @PathVariable("emprestimo") String idEmprestimo){
		
		emprestimoService.devolverBicicleta(ponto, Integer.parseInt(idEmprestimo));
		
		return "mapa";
	}
}
