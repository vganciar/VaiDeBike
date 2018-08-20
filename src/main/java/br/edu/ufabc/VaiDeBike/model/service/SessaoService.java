package br.edu.ufabc.VaiDeBike.model.service;
import org.springframework.stereotype.Service;
import br.edu.ufabc.VaiDeBike.model.entity.Usuario;

@Service
public class SessaoService {
	
    private Usuario usuario;
         
    public void logarUser(Usuario usuario) throws Exception {
        if(getUserLogado() == null) { 
        	this.usuario = usuario;
       } else {
            throw new Exception("Ja existe um usuario logado.");
        }
    }
    
    public void logout() throws Exception{
        if( getUserLogado() != null ) {
        	this.usuario = null;
        } else {
            throw new Exception("Nao ha usuario logado.");
        }
    }
 
    public Usuario getUserLogado() {
        return this.usuario; 
    }
        
}
