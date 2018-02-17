package com.pasp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pasp.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{
	
	List<Usuario> findByNomeLikeIgnoreCase(String nome);
	
	Usuario findByEmail(String email);

}
