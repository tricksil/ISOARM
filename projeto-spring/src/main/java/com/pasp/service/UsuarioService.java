package com.pasp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pasp.model.Usuario;
import com.pasp.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuario(){   
        return this.usuarioRepository.findAll();
    }
    
    public Page<Usuario> listaPaginada(int count, int page){
    	Pageable pages = new PageRequest(page, count);
    	return usuarioRepository.findAll(pages);
    }
    
    public List<Usuario> buscarPorNome(String nome){   
        return this.usuarioRepository.findByNomeLikeIgnoreCase(nome);
    }
    
    public Usuario findByEmail(String email) {
    	Usuario usuario = this.usuarioRepository.findByEmail(email);
    	usuario.setSenha("");
    	return usuario;
    }
    
    public Usuario getById(String id){   

        return this.usuarioRepository.findOne(id);
    }

    public Usuario salvarUsuario(Usuario usuario){
        return this.usuarioRepository.save(usuario);
    }
    
    public void deletarUsuario(String id){
    	this.usuarioRepository.delete(id);
    }

}
