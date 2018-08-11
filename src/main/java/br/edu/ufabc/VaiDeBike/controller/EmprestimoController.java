package br.edu.ufabc.VaiDeBike.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.ufabc.VaiDeBike.model.service.EmprestimoService;

@Controller
public class EmprestimoController {
	
	private EmprestimoService emprestimoService;
	
	@Autowired
	public EmprestimoController(EmprestimoService emprestimoService) {		
		this.emprestimoService = emprestimoService;
	}
	
	@RequestMapping("/mapa")
	public String exibeMapa(){		
		return "mapa";
	}
	
	@RequestMapping("/emprestimo/{ponto}")
	public String reservarBicicleta(@PathVariable("ponto") String ponto){
		
		return "emprestimo";
	}
	
	/*public ModelAndView listar(){
	List<ContaCorrente> contas = contaCorrenteService.findAll();
	
	ModelAndView modelAndView = new ModelAndView("pesquisarContas");
	modelAndView.addObject("contas", contas);
	
	return modelAndView;
}*/

}