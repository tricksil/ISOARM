package com.pasp.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pasp.model.Usuario;
import com.pasp.service.UsuarioService;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public List<Usuario> listarUsuario(){
        return this.usuarioService.listarUsuario();
    }
    
    @RequestMapping(value = "/usuario/{page}/{count}", method = RequestMethod.GET)
    public Page<Usuario> listaPaginada(@PathVariable int page, @PathVariable int count){
        return this.usuarioService.listaPaginada(count, page);
    }
    
    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
    public Usuario getById(@PathVariable String id){
        return this.usuarioService.getById(id);
    }
    
    @RequestMapping(value = "/usuario/{nome}/nome", method = RequestMethod.GET)
    public List<Usuario> buscarPorNome(@PathVariable String nome){
        return this.usuarioService.buscarPorNome(nome);
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    public Usuario salvarUsuario(@RequestBody Usuario usuario){
        return this.usuarioService.salvarUsuario(usuario);
    }
    
    @RequestMapping(value = "/usuario", method = RequestMethod.PUT)
    public Usuario editarUsuario(@RequestBody Usuario usuario){
        return this.usuarioService.salvarUsuario(usuario);
    }
    
    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
    public void deletarUsuario(@PathVariable String id){
        this.usuarioService.deletarUsuario(id);
    }
    
    @RequestMapping(value = "/usuario/logado", method = RequestMethod.GET)
    @ResponseBody
    public Usuario currentUserName(Principal principal) {    	    	
    	return this.usuarioService.findByEmail(principal.getName());
    }
    

}
