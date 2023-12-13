package br.com.gestor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.gestor.controller.dto.PessoaDTO;

@Controller
public class MenuController {
	
	@GetMapping("/listagem-pessoas")
    public String listarPessoas() {
        return "listagem-pessoas";
    }

    @GetMapping("/pessoas")
    public String incluirPessoas(Model model) {
    	model.addAttribute("pessoa", new PessoaDTO());
    	return "/pessoas";
    }
    
    @GetMapping("/listagem-projetos")
    public String listarProjetos(Model model) {
    	return "/listagem-projetos";
    }


}
