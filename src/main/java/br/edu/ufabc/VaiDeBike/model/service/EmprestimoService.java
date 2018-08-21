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
import ch.qos.logback.core.status.Status;

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
	
	@Autowired
	private SessaoService sessao;
	
	public void devolverBicicleta(Integer idPonto, Integer idEmprestimo) {
		Emprestimo emprestimo = emprestimoRepository.findById(idEmprestimo).get();
		
		//emprestimo.setPontoDevolucao(ponto);
		emprestimo.setStatus("F");
		emprestimo.setDataDevolucao(new Date());		
		
		emprestimoRepository.save(emprestimo);
		
		Bicicleta bicicleta = new Bicicleta();
		bicicleta.setId(emprestimo.getBicicleta().getId());
		bicicleta.setCor(emprestimo.getBicicleta().getCor());
		bicicleta.setDataAquisicao(emprestimo.getBicicleta().getDataAquisicao());
		bicicleta.setModelo(emprestimo.getBicicleta().getModelo());
		bicicleta.setConservacao(emprestimo.getBicicleta().getConservacao());
		bicicleta.setStatus("D");
		bicicleta.setPonto(pontoRepository.findById(idPonto).get());
		
		bicicletaRepository.save(bicicleta);
	}
	
	public Boolean reservarBicicleta(Ponto ponto, Integer idBicicleta) {		
		Bicicleta bicicleta = bicicletaRepository.findById(idBicicleta).get();
		
		if (bicicleta.getStatus().equals("D") && emprestimoRepository.findEmprestimoAbertoByCiclista(sessao.getUsuarioLogado().getId()) == 0) {
			Emprestimo emprestimo = new Emprestimo();
			emprestimo.setBicicleta(bicicleta);
			emprestimo.setCiclista((Ciclista) sessao.getUsuarioLogado()); //usuario logado da sessao
			emprestimo.setDataEmprestimo(new Date());
			emprestimo.setPonto(ponto);
			emprestimo.setStatus("A");
			
			emprestimoRepository.save(emprestimo);
			
			bicicleta.setStatus("I");
			bicicletaRepository.save(bicicleta);
			
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
