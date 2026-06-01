package com.sistemalogin.security.security;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sistemalogin.security.model.Usuario;
import com.sistemalogin.security.model.UsuarioRepository;

@Configuration
public class ConfiguracaoSeguranca {
   // 1- AUTENTICAÇÃO - Cadastro Novo, Login realizado(?)
   @Bean 
   public UserDetailsService userDetailsService(UsuarioRepository usuarioRepository) {
        return username -> {
           Usuario usuario = usuarioRepository.findByNome(username)
            .orElseThrow(() -> new UsernameNotFoundException(
                " Usuário não encontrado " + username));
            return new User(
               usuario.getNome(),
               usuario.getSenha(),
               Collections.singleton(
                new SimpleGrantedAuthority("ROLE_USER")
               )
            );                
        };
        // username
        // password
        // role
   }


   
   // 2- AUTORIZAÇÃO

}
