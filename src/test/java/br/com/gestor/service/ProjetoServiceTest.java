package br.com.gestor.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import br.com.gestor.controller.dto.PessoaDTO;
import br.com.gestor.controller.dto.ProjetoDTO;
import br.com.gestor.model.PessoaModel;
import br.com.gestor.model.ProjetoModel;
import br.com.gestor.repository.PessoaRepository;
import br.com.gestor.repository.ProjetoRepository;
import br.com.gestor.service.mappers.ProjetoMapper;

@SpringBootTest
public class ProjetoServiceTest {
	
	@InjectMocks
	ProjetoService projetoService;
	
	@Mock
	ProjetoRepository projetoRepository;
	
	@Mock
	PessoaRepository pessoaRepository;
	
	@Mock
	ProjetoMapper modelMapper;
	
	@Mock
	RestTemplate restTemplate;
	
	@Test
	void inserirProjeto_sucesso() {
		
		var projetoDTO = inserirProjeto();
		var projetoDTORetorno = projetoDTO;
		projetoDTORetorno.setId(1L);
		
		when(pessoaRepository.findById(projetoDTO.getGerente().getId())).thenReturn(Optional.of(getGerenteModel()));
		
		projetoService.incluirProjetos(projetoDTO);
		
		assertEquals(true, projetoDTORetorno.getId() >= 0);
	}

	@Test
	void listagem_sucesso() {
		when(projetoRepository.findAll()).thenReturn(listarProjetos());
		List<ProjetoDTO> listagemProjetos = projetoService.listagem();
		assertEquals(true, listagemProjetos.size() >= 0);
	}
	
	@Test
	void removerProjeto() {
		projetoService.removerProjeto(1L);
	}

	void visualizar(Long id) {
		when(projetoRepository.findById(id).get()).thenReturn(listarProjetos().get(0));
		projetoService.visualizar(1L);
	}
	
	private List<ProjetoModel> listarProjetos(){
		List<ProjetoModel> projetos = new ArrayList<>();
		ProjetoModel projeto = new ProjetoModel();
		projeto.setId(1L);
		projeto.setNome("Projeto Manager");
		projeto.setDataInicio(LocalDate.now());
		projeto.setDataPrevisao(LocalDate.now());
		projeto.setDataTemino(LocalDate.now());
		projeto.setDescricao("Gerir outros projetos");
		projeto.setStatus("EM ABERTO");
		projeto.setOrcamento(new BigDecimal(200000));
		projeto.setRisco("MEDIO");
		return projetos;
	}

	private ProjetoDTO inserirProjeto(){
		ProjetoDTO projeto = new ProjetoDTO();
		projeto.setId(1L);
		projeto.setNome("Projeto Manager");
		projeto.setDataInicio(LocalDate.now());
		projeto.setDataPrevisao(LocalDate.now());
		projeto.setDataTemino(LocalDate.now());
		projeto.setDescricao("Gerir outros projetos");
		projeto.setStatus("EM ABERTO");
		projeto.setOrcamento(new BigDecimal(200000));
		projeto.setRisco("MEDIO");
		projeto.setGerente(getGerenteDTO());
		return projeto;
	}
	
	private PessoaDTO getGerenteDTO(){
		PessoaDTO pessoa = new PessoaDTO();
		pessoa.setCpf("000.000.000-91");
		pessoa.setNome("Pedro da Silva");
		pessoa.setGerente(false);
		pessoa.setDataNascimento(LocalDate.now());
		return pessoa;
	}
	
	private PessoaModel getGerenteModel(){
		PessoaModel pessoa = new PessoaModel();
		pessoa.setCpf("000.000.000-91");
		pessoa.setNome("Pedro da Silva");
		pessoa.setGerente(false);
		pessoa.setDataNascimento(LocalDate.now());
		pessoa.setId(1L);
		return pessoa;
	}
}
