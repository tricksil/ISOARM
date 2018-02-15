package com.pasp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    public Usuario salvarUsuario(Usuario usuario){
        return this.usuarioRepository.save(usuario);
    }

}
