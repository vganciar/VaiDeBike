package br.edu.ufabc.VaiDeBike.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emprestimo")
public class EmprestimoController {
	
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
