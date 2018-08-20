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
import br.edu.ufabc.VaiDeBike.model.repository.UsuarioRepository;

@Service
public class EmprestimoService {
	
	@Autowired
	private EmprestimoRepository emprestimoRepository;			
	
	@Autowired
	private BicicletaRepository bicicletaRepository;
	
	@Autowired
	private PontoRepository pontoRepository;
	
	@Autowired
	private UsuarioRepository ciclistaRepository;
	
	public void devolverBicicleta(Ponto ponto, Integer idEmprestimo) {
		Emprestimo emprestimo = emprestimoRepository.findById(idEmprestimo).get();
		//emprestimo.setPontoDevolucao(ponto);
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
			emprestimo.setPonto(ponto);
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
	
	public List<Bicicleta> findBicicletasByPonto(int idPonto){
		
		return bicicletaRepository.findByPonto(idPonto);		
	}
	
	public List<Emprestimo> findEmprestimosByCiclista(int idCiclista){
		
		return emprestimoRepository.findAllByCiclista(idCiclista);		
	}
	
	public Ponto findPontoById(int idPonto){
		
		return pontoRepository.findById(idPonto).get();		
	}
	
	public Ciclista findCiclistaById(int idCiclista){
		
		return ciclistaRepository.findById(idCiclista);		
	}
	
	public List<Ponto> findPontos(){
		
		return pontoRepository.findAll();		
	}
	
}
