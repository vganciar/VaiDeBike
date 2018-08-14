package br.edu.ufabc.VaiDeBike.model.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufabc.VaiDeBike.model.DTO.PontoDTO;
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
	private PontoRepository pontoRepository;
	
	@Autowired
	public EmprestimoService(BicicletaRepository bicicletaRepository, PontoRepository pontoRepository, EmprestimoRepository emprestimoRepository) {
		this.bicicletaRepository = bicicletaRepository;		
		this.emprestimoRepository = emprestimoRepository;
		this.pontoRepository = pontoRepository;
	}
	
	public void devolverBicicleta(Ponto ponto, Integer idEmprestimo) {
		Emprestimo emprestimo = emprestimoRepository.findById(idEmprestimo).get();
		emprestimo.setPontoDevolucao(ponto);
		emprestimo.setStatus("F");
		emprestimo.setDataDevolucao(new Date());
		
		emprestimoRepository.save(emprestimo);
		
		Bicicleta bicicleta = emprestimo.getBicicleta();
		bicicleta.setStatus("D");
		bicicleta.setPonto(ponto);
		
		bicicletaRepository.save(bicicleta);
	}
	
	public Boolean reservarBicicleta(Ponto ponto, Integer idBicicleta) {		
		Bicicleta bicicleta = bicicletaRepository.findById(idBicicleta).get();
		
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
	
	public List<PontoDTO> getPontos(){
		
		List<Ponto> pontos = pontoRepository.findAll();
		
		List<PontoDTO> pontosDTO = new ArrayList<PontoDTO>();
		
		for (Ponto ponto: pontos) {
			PontoDTO pontoDTO = new PontoDTO();
			
			pontoDTO.setId(ponto.getId());
			pontoDTO.setEndereco(ponto.getEndereco());
			pontoDTO.setLatitude(ponto.getLatitude());
			pontoDTO.setLongitude(ponto.getLongitude());
			pontoDTO.setNome(ponto.getNome());
			pontoDTO.setHoraInicial(ponto.getHoraInicial());
			pontoDTO.setHoraFinal(ponto.getHoraFinal());
			
			int count = 0;
			
			for (Bicicleta bicicleta : ponto.getBicicletas()) {
				if (bicicleta.getStatus().equals(("D"))) {
					count++;
				}
			}
			
			pontoDTO.setBicicletasDisponiveis(count);
			
			pontosDTO.add(pontoDTO);
		} 		
		
		return pontosDTO;
	}
	
	public List<Bicicleta> getBicicletasPorPonto(int idPonto){
		
		return bicicletaRepository.findByPonto(idPonto);		
	} 	
	
	public Ponto findPontoById(int idPonto){
		
		return pontoRepository.findById(idPonto).get();
		
	}
}
