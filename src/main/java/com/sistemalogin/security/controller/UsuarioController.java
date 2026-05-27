package com.sistemalogin.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistemalogin.security.model.Usuario;
import com.sistemalogin.security.model.UsuarioRepository;

@Controller

public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    // Get -> Página Index // Essa página pode ser acessada por qualquer pessoa
    @GetMapping("/") // localhost:8080 -> Get
    public String index() {
        return "index";
    }

    // Get -> Página de Cadastro
    @GetMapping("/cadastro") // localhost:8080/cadastro -> Get
    public String cadastroUsuario(Model model) {
        model.addAttribute("usuario",new Usuario());
        return "cadastro";
    }

    // Post -> Cadastro de Usuário
    @PostMapping("/cadastro") // localhost:8080/cadastro -> Post -> Quando eu clicar no botão
    public String cadastroRealizado(Model model) {
        return "redirect:/logado";
    }

    
    // Get -> Página Logada
    @GetMapping("/logado") 
    public String areaLogada() {
        return "logado";
    }
    

    
}
