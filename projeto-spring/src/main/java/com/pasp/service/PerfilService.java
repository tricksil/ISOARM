package com.pasp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pasp.model.Perfil;
import com.pasp.repository.PerfilRepository;

@Service
public class PerfilService {
	@Autowired
	PerfilRepository perfilRepository;

    public List<Perfil> listarPerfil(){   
        return this.perfilRepository.findAll();
    }
    
    public Page<Perfil> listaPaginada(int count, int page){
    	Pageable pages = new PageRequest(page, count);
    	return this.perfilRepository.findAll(pages);
    }
    
    public List<Perfil> buscarPorNome(String nome){   
        return this.perfilRepository.findByNomeLikeIgnoreCase(nome);
    }
    
    public Perfil getById(String id){   

        return this.perfilRepository.findOne(id);
    }

    public Perfil salvarPerfil(Perfil perfil){
        return this.perfilRepository.save(perfil);
    }
    
    public void deletarPerfil(String id){
    	this.perfilRepository.delete(id);
    }
}
