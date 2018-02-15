package com.pasp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pasp.model.Usuario;
import com.pasp.service.UsuarioService;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public List<Usuario> listaUsuario(){
        return this.usuarioService.listaUsuario();
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    public List<Usuario> listaUsuario(@RequestBody Usuario usuario){
        return this.usuarioService.listaUsuario(usuario);
    }

}
