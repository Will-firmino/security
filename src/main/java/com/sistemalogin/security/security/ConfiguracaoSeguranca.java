package com.sistemalogin.security.security;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.web.SecurityFilterChain;

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
   }

   // 2- AUTORIZAÇÃO - O que o usuário pode acessar (ROLE_USER, ROLE_ADMIN)
   @Bean
   public SecurityFilterChain chain(HttpSecurity http) throws Exception {
      
      return http
         .authorizeHttpRequests(auth -> auth
            .requestMatchers("/", "/cadastro", "/css/**").permitAll()
            .anyRequest().authenticated())

         .formLogin(login -> login
            .loginPage("/login")
            .defaultSuccessUrl("/area-logada", true).permitAll())
         
         .logout(logout -> logout
            .logoutSuccessUrl("/login?logout").permitAll())
         
         .build();      
   }

}
