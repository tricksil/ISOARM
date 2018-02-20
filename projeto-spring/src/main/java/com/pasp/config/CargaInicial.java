package com.pasp.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.pasp.model.Perfil;
import com.pasp.model.Usuario;
import com.pasp.repository.PerfilRepository;
import com.pasp.repository.UsuarioRepository;

@Component
public class CargaInicial implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	PerfilRepository perfilRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		List<Perfil> perfis = perfilRepository.findAll();
		
		if(perfis.isEmpty()) {
			perfilRepository.save(new Perfil("ROLE_ADMIN"));
			perfilRepository.save(new Perfil("ROLE_OREIA"));
			
			Perfil perfil = perfilRepository.findByNome("ROLE_ADMIN");
			
			List<Perfil> perfisUsuario = new ArrayList<Perfil>();
			
			perfisUsuario.add(perfil);
			
			usuarioRepository.save(new Usuario("ADMIN", "admin", "123", perfisUsuario)); 
			
		}
		
	}

}
