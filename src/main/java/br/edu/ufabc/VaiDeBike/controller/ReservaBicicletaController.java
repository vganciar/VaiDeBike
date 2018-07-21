package br.edu.ufabc.VaiDeBike.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vaidebike")
public class ReservaBicicletaController {
	//private ContaCorrenteService contaCorrenteService;
	
	/*@Autowired
	public ReservaBicicletaController(ContaCorrenteService contaCorrenteService) {
		this.contaCorrenteService = contaCorrenteService;
	}*/
	
	@RequestMapping("/mapa")
	public String exibeMapa(){
		
		return "reservaBicicleta";
	}
	/*public ModelAndView listar(){
		List<ContaCorrente> contas = contaCorrenteService.findAll();
		
		ModelAndView modelAndView = new ModelAndView("pesquisarContas");
		modelAndView.addObject("contas", contas);
		
		return modelAndView;
	}*/
}
