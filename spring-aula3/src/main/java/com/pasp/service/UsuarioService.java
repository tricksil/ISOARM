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

    public List<Usuario> listaUsuario(){   

        return this.usuarioRepository.findAll();
    }

    public List<Usuario> listaUsuario(Usuario usuario){
        this.usuarioRepository.save(usuario);
        return usuarioRepository.findAll();
    }

}
