package com.pasp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pasp.model.Perfil;

public interface PerfilRepository extends MongoRepository<Perfil, String> {
	
	List<Perfil> findByNomeLikeIgnoreCase(String nome);

	Perfil findByNome(String nome);

}
