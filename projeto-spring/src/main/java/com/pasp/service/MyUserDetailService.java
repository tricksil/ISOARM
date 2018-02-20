package com.pasp.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pasp.model.Usuario;
import com.pasp.repository.UsuarioRepository;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(username);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario ou senha inválidos");
		}		
		return new MyUserRepositoryDetails(usuario);
	}	
	
	@SuppressWarnings("serial")
	private final static class MyUserRepositoryDetails extends Usuario implements UserDetails {

		public MyUserRepositoryDetails(Usuario usuario) {
			super(usuario);	
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			
			return getPerfis();
		}

		@Override
		public String getPassword() {
			
			return getSenha();
		}

		@Override
		public String getUsername() {
			
			return getEmail();
		}

		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return true;
		}

	}

}
