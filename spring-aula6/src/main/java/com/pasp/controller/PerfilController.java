package com.pasp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pasp.model.Perfil;
import com.pasp.service.PerfilService;

@RestController
public class PerfilController {
	
	@Autowired
	private PerfilService perfilService;
	
	@RequestMapping(value = "/perfil", method = RequestMethod.GET)
	public List<Perfil> listarPerfil(){
		return this.perfilService.listarPerfil();
	}
	
	@RequestMapping(value = "/perfil/{page}/{count}", method = RequestMethod.GET)
	public Page<Perfil> listaPaginada(@PathVariable int page, @PathVariable int count){
		return this.perfilService.listaPaginada(count, page);
	}
	
	@RequestMapping(value = "/perfil/{nome}/nome", method = RequestMethod.GET)
	public List<Perfil> buscarPorNome(@PathVariable String nome){
		return this.perfilService.buscarPorNome(nome);
	}
	
	@RequestMapping(value = "/perfil/{id}", method = RequestMethod.GET)
	public Perfil getById(@PathVariable String id){
		return this.perfilService.getById(id);
	}
	
	@RequestMapping(value = "/perfil", method = RequestMethod.POST)
	public Perfil salvarPerfil(@RequestBody Perfil perfil) {
		return this.perfilService.salvarPerfil(perfil);
	}
	
	@RequestMapping(value = "/perfil", method = RequestMethod.PUT)
	public Perfil editarPerfil(@RequestBody Perfil perfil) {
		return this.perfilService.salvarPerfil(perfil);
	}
	
	@RequestMapping(value = "/perfil/{id}", method = RequestMethod.DELETE)
	public void deletarPerfil(@PathVariable String id) {
		this.perfilService.deletarPerfil(id);
	}

}
