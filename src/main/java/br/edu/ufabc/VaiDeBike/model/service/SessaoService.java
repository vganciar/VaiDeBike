package br.edu.ufabc.VaiDeBike.model.service;
import org.springframework.stereotype.Service;
import br.edu.ufabc.VaiDeBike.model.entity.Usuario;

@Service
public class SessaoService {
	
    private Usuario usuarioLogado;
         
    public void login(Usuario usuario) {
        if(getUsuarioLogado() == null) { 
        	this.usuarioLogado = usuario;
       } 
    }
    
    public void logout() {
        if( getUsuarioLogado() != null ) {
        	this.usuarioLogado = null;
       } 
    }
 
    public Usuario getUsuarioLogado() {
        return this.usuarioLogado; 
    }
        
}
