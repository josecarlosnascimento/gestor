package br.com.gestor.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import br.com.gestor.controller.dto.PessoaDTO;
import br.com.gestor.repository.PessoaRepository;
import br.com.gestor.service.PessoaService;
import br.com.gestor.service.mappers.PessoaMapper;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
    @GetMapping("/listagem-pessoas")
    public String buscarProjetos(ModelMap model) {
    	model.put("pessoas", pessoaService.listagem());
        return "listagem-pessoas";
    }
	
    @GetMapping("/buscar")
    public String buscar(@RequestParam Long id, ModelMap model) {
    	List<PessoaDTO> pessoas = pessoaRepository.findAll()
    						.stream().map(p-> PessoaMapper.MAPPER.toDTO(p)).collect(Collectors.toList());
    	model.addAttribute("pessoas", pessoas);
    	return "/pessoas";
    }
	
    @PostMapping
    public RedirectView incluirPessoas(@ModelAttribute(name = "pessoa") PessoaDTO pessoa, RedirectAttributes redirectAttributes) {
    	RedirectView redirectView = new RedirectView("pessoas", true);
        redirectAttributes.addFlashAttribute("pessoa", pessoaService.inserirPessoas(pessoa));
        redirectAttributes.addFlashAttribute("pessoaAdicionada", true);
        return redirectView;
    }

}
