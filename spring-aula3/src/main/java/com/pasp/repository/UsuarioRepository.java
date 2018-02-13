package com.pasp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pasp.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{

}
