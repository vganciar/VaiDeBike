package br.edu.ufabc.VaiDeBike.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ufabc.VaiDeBike.model.entity.Bicicleta;
import br.edu.ufabc.VaiDeBike.model.entity.Ponto;
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
	public ModelAndView exibeEmprestimo(@PathVariable("ponto") String idPonto){
		
		List<Bicicleta> bicicletas = emprestimoService.getBicicletasPorPonto(Integer.parseInt(idPonto));		
		
		ModelAndView modelAndView = new ModelAndView("emprestimo");
		modelAndView.addObject("bicicletas", bicicletas);

		return modelAndView;
	}
	
	@RequestMapping(value = "/reserva/{bicicleta}", method = RequestMethod.POST)
	public String reservarBicicleta(Ponto ponto, @PathVariable("bicicleta") String idBicicleta){
		
		emprestimoService.reservarBicicleta(ponto, Integer.parseInt(idBicicleta));
		
		return "mapa";
	}
	
	/*public ModelAndView listar(){
	List<ContaCorrente> contas = contaCorrenteService.findAll();
	
	ModelAndView modelAndView = new ModelAndView("pesquisarContas");
	modelAndView.addObject("contas", contas);
	
	return modelAndView;
}*/

}
