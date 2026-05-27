package com.sistemalogin.security.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.sistemalogin.security.model.UsuarioRepository;

@Service
public class UsuarioDetailsService implements UserDetailsService{
    
    // Injeção para acessar os dados do usuário que estão no BD para autenticação.
    @Autowired 
    private UsuarioRepository usuarioRepository;

    // Método que será chamado SS para carregar os detalhes do usuário com base no nome do usuário(neste caso, será o e-mail) fornecido na autenticação
    public UserDetais carregarDadosPorEmail(String email) {
        
    }


}
