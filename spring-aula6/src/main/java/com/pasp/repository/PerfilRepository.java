package com.pasp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pasp.model.Perfil;

public interface PerfilRepository extends MongoRepository<Perfil, String> {

}
