package br.com.gestor.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import br.com.gestor.controller.dto.PessoaDTO;
import br.com.gestor.controller.dto.ProjetoDTO;
import br.com.gestor.repository.PessoaRepository;
import br.com.gestor.service.ProjetoService;
import br.com.gestor.service.mappers.PessoaMapper;

@Controller
@RequestMapping("/projetos")
public class ProjetoController {
	
	@Autowired
	private ProjetoService projectService;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
    @GetMapping
    public String paginaIncluirProjetos(Model model) {
    	model.addAttribute("projeto", new ProjetoDTO());
    	List<PessoaDTO> pessoas = pessoaRepository.findByGerente(true)
    						.stream().map(p-> PessoaMapper.MAPPER.toDTO(p)).collect(Collectors.toList());
    	model.addAttribute("gerentes", pessoas);
    	return "/projetos";
    }

	@PostMapping
    public ModelAndView incluirProjetos(@ModelAttribute(name = "projeto")@Valid ProjetoDTO projeto,
    																			BindingResult result,
    																			Model m) {
        ModelAndView mv = new ModelAndView("projetos", "projeto", projeto);
        List<PessoaDTO> pessoas = pessoaRepository.findByGerente(true)
        		.stream().map(p-> PessoaMapper.MAPPER.toDTO(p)).collect(Collectors.toList());
        if(result.hasErrors()){
            mv.addObject("gerentes", pessoas);
        }else {
        	var projetoModel = projectService.incluirProjetos(projeto);
        	
        	if(projetoModel.getId() > 0) {
        		mv = new ModelAndView("projetos", "projeto", new ProjetoDTO());
        		mv.addObject("projetoAdicionado", true);
                mv.addObject("gerentes", pessoas);
        	}
        }
        return mv;
    }

    @GetMapping("/listagem-projetos")
    public String buscarProjetos(ModelMap model) {
    	model.put("projetos",projectService.listagem());
        return "listagem-projetos";
    }
    
    @GetMapping("/{id}")
    public RedirectView removerProjetos(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
    	projectService.removerProjeto(id);
    	RedirectView redirectView = new RedirectView("listagem-projetos", true);
        redirectAttributes.addFlashAttribute("codigo", id);
        redirectAttributes.addFlashAttribute("projetoRemovido", true);
        return redirectView;
    }

    @GetMapping("/buscar")
    public String buscar(@RequestParam Long id, Model model) {
    	model.addAttribute("projeto", projectService.visualizar(id));
    	List<PessoaDTO> gerentes = pessoaRepository.findAll()
				.stream().map(p-> PessoaMapper.MAPPER.toDTO(p)).collect(Collectors.toList());
    	model.addAttribute("gerentes", gerentes);
    	return "/projetos";
    }
}
