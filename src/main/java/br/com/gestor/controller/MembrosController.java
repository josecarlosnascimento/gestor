package br.com.gestor.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@GetMapping("/listagem-membros")
    public String listagemMembros(@ModelAttribute(name = "membro")@Valid MembroDTO membro, Model model) {
		model.addAttribute("membro", new MembroDTO());

		List<PessoaDTO> funcionarios = pessoaRepository.findByGerente(false)
				.stream().map(p-> PessoaMapper.MAPPER.toDTO(p)).collect(Collectors.toList());
		model.addAttribute("funcionarios", funcionarios);
		
		List<MembroModel> membros = membroRepository.findByProjetoId(membro.getProjeto().getId());

		List<Long> idsMembros = membros.stream().map(m -> m.getId()).collect(Collectors.toList());
		
		List<PessoaDTO> pessoasMembros = pessoaRepository.findByIdIn(idsMembros)
    	    						.stream()
    	    						.map(p-> PessoaMapper.MAPPER.toDTO(p))
    	    						.collect(Collectors.toList());
		
		pessoasMembros.forEach(p -> p.setMembro(true));
		model.addAttribute("membros", pessoasMembros);

        return "membros";
    }
}
