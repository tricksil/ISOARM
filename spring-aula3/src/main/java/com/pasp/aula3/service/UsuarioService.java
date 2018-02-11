package com.pasp.aula3.service;

import com.pasp.aula3.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    public List<Usuario> listaUsuario(){
        List<Usuario> usuarioLista = new ArrayList<Usuario>();

        usuarioLista.add(new Usuario("Patrick", "patrick@gmail.com", 21));
        usuarioLista.add(new Usuario("Gabriel", "gabriel@gmail.com",20));
        usuarioLista.add(new Usuario("Bruno", "bruno@gmail.com", 19));

        return usuarioLista;
    }

    public List<Usuario> listaUsuario(Usuario usuario){
        List<Usuario> usuarioLista = new ArrayList<Usuario>();

        usuarioLista.add(new Usuario("Patrick", "patrick@gmail.com", 21));
        usuarioLista.add(new Usuario("Gabriel", "gabriel@gmail.com",20));
        usuarioLista.add(new Usuario("Bruno", "bruno@gmail.com", 19));
        usuarioLista.add(usuario);

        return usuarioLista;
    }

}
