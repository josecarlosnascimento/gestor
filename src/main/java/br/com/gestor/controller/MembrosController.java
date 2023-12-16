package br.com.gestor.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gestor.controller.dto.MembroDTO;
import br.com.gestor.controller.dto.PessoaDTO;
import br.com.gestor.controller.dto.ProjetoDTO;
import br.com.gestor.model.MembroModel;
import br.com.gestor.repository.MembroRepoitory;
import br.com.gestor.repository.PessoaRepository;
import br.com.gestor.repository.ProjetoRepository;
import br.com.gestor.service.mappers.PessoaMapper;
import br.com.gestor.service.mappers.ProjetoMapper;

@Controller
@RequestMapping("/membros")
public class MembrosController {
	
	@Autowired
	private ProjetoRepository projetoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private MembroRepoitory membroRepository;
	
	@GetMapping
	public String inicializando(Model model) {
		model.addAttribute("membro", new MembroDTO());
		
		List<ProjetoDTO> projetos = projetoRepository.findAll()
				.stream().map(p-> ProjetoMapper.MAPPER.toDTO(p)).collect(Collectors.toList());;
				model.addAttribute("projetos", projetos);
				
				return "membros";
	}

	@GetMapping("/listagem-membros/{idProjeto}")
    public ModelAndView listagemMembros(@PathVariable Long idProjeto, @ModelAttribute(name = "membro")@Valid MembroDTO membro, Model model) {
		
		
        ModelAndView mv = new ModelAndView("membros", "membro", membro);

		List<PessoaDTO> funcionarios = pessoaRepository.findByGerente(false)
				.stream().map(p-> PessoaMapper.MAPPER.toDTO(p)).collect(Collectors.toList());
		
		List<MembroModel> membros = membroRepository.findByProjetoId(idProjeto);

		List<Long> idsMembros = membros.stream().map(m -> m.getId()).collect(Collectors.toList());
		
		List<PessoaDTO> pessoasMembros = pessoaRepository.findByIdIn(idsMembros)
    	    						.stream()
    	    						.map(p-> PessoaMapper.MAPPER.toDTO(p))
    	    						.collect(Collectors.toList());
		
		pessoasMembros.forEach(p -> p.setMembro(true));
		
		List<PessoaDTO> todos = new ArrayList<>();
		todos.addAll(funcionarios);
		todos.addAll(pessoasMembros);
		
		membro.setPessoas(todos);

		mv.addObject("membros", membro.getPessoas());
        return mv;
    }
	
	@PostMapping
    public ModelAndView incluirProjetos(@ModelAttribute @Valid MembroDTO membro,
    																			BindingResult result,
    																			Model m,
    																			HttpServletRequest request) {

        ModelAndView mv = new ModelAndView("membros", "membro", membro);
        return mv;
    }
}
