package br.com.gestor.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestor.controller.dto.ProjetoDTO;
import br.com.gestor.model.PessoaModel;
import br.com.gestor.model.ProjetoModel;
import br.com.gestor.repository.PessoaRepository;
import br.com.gestor.repository.ProjetoRepository;
import br.com.gestor.service.mappers.ProjetoMapper;

@Service
public class ProjetoService {
	
	@Autowired
	private ProjetoRepository projectRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public ProjetoModel incluirProjetos(ProjetoDTO projetoDTO) {
		
		PessoaModel gerente = pessoaRepository.findById(projetoDTO.getGerente().getId()).get();
		ProjetoModel pro = ProjetoMapper.MAPPER.toModel(projetoDTO);
		pro.setPessoa(gerente);
		
		return projectRepository.save(pro);
	}
	
	public List<ProjetoDTO> listagem(){
		return projectRepository.findAll()
				.stream().map(p -> ProjetoMapper.MAPPER.toDTO(p))
				.collect(Collectors.toList());
	}
	
	public void removerProjeto(Long id) {
		projectRepository.deleteById(id);
	}

	public ProjetoDTO visualizar(Long id) {
		ProjetoDTO projeto = ProjetoMapper.MAPPER.toDTO(projectRepository.findById(id).get());
		return projeto;
	}
}
