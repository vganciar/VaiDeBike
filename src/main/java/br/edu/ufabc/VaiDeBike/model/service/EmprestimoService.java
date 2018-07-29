package br.edu.ufabc.VaiDeBike.model.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufabc.VaiDeBike.model.entity.Bicicleta;
import br.edu.ufabc.VaiDeBike.model.entity.Ciclista;
import br.edu.ufabc.VaiDeBike.model.entity.Emprestimo;
import br.edu.ufabc.VaiDeBike.model.entity.Ponto;
import br.edu.ufabc.VaiDeBike.model.repository.BicicletaRepository;
import br.edu.ufabc.VaiDeBike.model.repository.EmprestimoRepository;
import br.edu.ufabc.VaiDeBike.model.repository.PontoRepository;

@Service
public class EmprestimoService {
	
	private EmprestimoRepository emprestimoRepository;			
	private BicicletaRepository bicicletaRepository;	
	
	@Autowired
	public EmprestimoService(BicicletaRepository bicicletaRepository, PontoRepository pontoRepository, EmprestimoRepository emprestimoRepository) {
		this.bicicletaRepository = bicicletaRepository;		
		this.emprestimoRepository = emprestimoRepository;
	}
	
	public void devolverBicicleta(Ponto ponto, Integer emprestimoId) {
		Emprestimo emprestimo = emprestimoRepository.findById(emprestimoId).get();
		emprestimo.setPontoDevolucao(ponto);
		emprestimo.setStatus("F");
		emprestimo.setDataDevolucao(new Date());
		
		emprestimoRepository.save(emprestimo);
		
		Bicicleta bicicleta = emprestimo.getBicicleta();
		bicicleta.setStatus("D");
		bicicleta.setPonto(ponto);
		
		bicicletaRepository.save(bicicleta);
	}
	
	public Boolean reservarBicicleta(Ponto ponto, Integer bicicletaId) {		
		Bicicleta bicicleta = bicicletaRepository.findById(bicicletaId).get();
		
		if (bicicleta.getStatus().equals("D")) {
			bicicleta.setStatus("I");
			bicicletaRepository.save(bicicleta);
			
			Emprestimo emprestimo = new Emprestimo(); 
			
			Ciclista ciclista = new Ciclista();
			ciclista.setId(1);
			
			emprestimo.setBicicleta(bicicleta);
			emprestimo.setCiclista(ciclista); //usuario logado da sessao
			emprestimo.setDataEmprestimo(new Date());
			emprestimo.setPontoEmprestimo(ponto);
			emprestimo.setStatus("A");
			
			emprestimoRepository.save(emprestimo);
			
			return true;
		}
		
		return false;				
	}
}
