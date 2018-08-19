package br.edu.ufabc.VaiDeBike.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ufabc.VaiDeBike.model.entity.Bicicleta;
import br.edu.ufabc.VaiDeBike.model.entity.Ciclista;
import br.edu.ufabc.VaiDeBike.model.entity.Ponto;
import br.edu.ufabc.VaiDeBike.model.entity.Usuario;
import br.edu.ufabc.VaiDeBike.model.repository.BicicletaRepository;
import br.edu.ufabc.VaiDeBike.model.repository.CiclistaRepository;
import java.sql.Date;
import java.util.Optional;


@Service
public class CadastroService {
	
	@Autowired
	private CiclistaRepository ciclistaRepository;
	@Autowired
	private BicicletaRepository bibicletaRepository;
	
	public void cadastrarCiclista(String nome, String CPF, String celular, String login, String senha) {
		
		Ciclista ciclista = new Ciclista();		
		ciclista.setNome(nome);
		ciclista.setCPF(CPF);
		ciclista.setCelular(celular);
		ciclista.setLogin(login);
		ciclista.setSenha(senha);
		Date dataCadastro = new Date(System.currentTimeMillis());  
		ciclista.setDataCadastro(dataCadastro);
		ciclistaRepository.save(ciclista);				
	}
	
	public void cadastrarBicicleta(String modelo, String cor, String status, int conservacao, Ponto ponto) {
		
		Bicicleta bicicleta = new Bicicleta();
		bicicleta.setModelo(modelo);
		bicicleta.setCor(cor);
		bicicleta.setStatus(status);
		bicicleta.setConservacao(conservacao);
		Date dataAquisicao = new Date(System.currentTimeMillis());  
		bicicleta.setDataAquisicao(dataAquisicao);
		bicicleta.setPonto(ponto);
		bibicletaRepository.save(bicicleta);
	}
}
