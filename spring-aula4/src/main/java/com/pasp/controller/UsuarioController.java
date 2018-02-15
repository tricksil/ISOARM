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
    public List<Usuario> listarUsuario(){
        return this.usuarioService.listarUsuario();
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    public Usuario salvarUsuario(@RequestBody Usuario usuario){
        return this.usuarioService.salvarUsuario(usuario);
    }
    
    @RequestMapping(value = "/usuario", method = RequestMethod.PUT)
    public Usuario editarUsuario(@RequestBody Usuario usuario){
        return this.usuarioService.salvarUsuario(usuario);
    }

}
