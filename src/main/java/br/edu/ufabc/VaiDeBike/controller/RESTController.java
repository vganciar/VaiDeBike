package br.edu.ufabc.VaiDeBike.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.ufabc.VaiDeBike.model.service.EmprestimoService;

@RestController
public class RESTController {
	
	private EmprestimoService emprestimoService;
	
	@Autowired
	public RESTController(EmprestimoService emprestimoService) {		
		this.emprestimoService = emprestimoService;
	}
	
	@RequestMapping("/pontos")
	public String getPontos()
	{		
		ObjectMapper mapper = new ObjectMapper();
		String jsonPontos = "";
		
		try {
			jsonPontos = mapper.writeValueAsString(emprestimoService.getPontos());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonPontos;
	}

}
