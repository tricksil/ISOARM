package com.pasp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import com.pasp.service.MyUserDetailService;

@Configuration
public class OAuth2ServerConfiguration {
	
	private static final String RESOURCE_ID = "restservice";
	
	@Configuration
	@EnableResourceServer
	protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
		
		public void configure (ResourceServerSecurityConfigurer resource) {
			resource
					.resourceId(RESOURCE_ID);
		}
		
		public void configure (HttpSecurity http) throws Exception{
			http	
					.logout()
					.invalidateHttpSession(true)
					.clearAuthentication(true)
					.and().authorizeRequests()
					.antMatchers("/usuario/**").hasAnyRole("ADMIN", "OREIA")
					.antMatchers("/perfil/**").hasAnyRole("ADMIN", "OREIA")					
					.anyRequest().denyAll()
					.antMatchers(HttpMethod.OPTIONS, "/**").permitAll();
		}
		
	}
	
	@Configuration
	@EnableAuthorizationServer
	protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter{

		private TokenStore  tokenStore = new InMemoryTokenStore();
		
		@Autowired
		@Qualifier("authenticationManagerBean")
		private AuthenticationManager authenticationManager;
		
		@Autowired
		private MyUserDetailService userDetailService;
		
		public void configure (AuthorizationServerEndpointsConfigurer endpoints) {
			endpoints.tokenStore(this.tokenStore)
					.authenticationManager(this.authenticationManager)
					.userDetailsService(userDetailService);
					
		}
		
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
			clients 
					.inMemory()
					.withClient("cliente")
					.authorizedGrantTypes("password", "authorization_code", "refresh_token").scopes("bar", "read", "write")
					.refreshTokenValiditySeconds(2592000)
					.resourceIds("restservice")
					.secret("123")
					.accessTokenValiditySeconds(200000988);
		}
		
		@Bean
		@Primary
		public DefaultTokenServices tokenServices() {
			DefaultTokenServices  tokenServices  = new DefaultTokenServices();
			
			tokenServices.setSupportRefreshToken(true);
			tokenServices.setTokenStore(tokenStore);
			return tokenServices;
		}
		
	}
	
}
