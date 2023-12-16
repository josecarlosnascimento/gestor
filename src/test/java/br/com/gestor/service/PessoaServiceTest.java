package br.com.gestor.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.gestor.controller.dto.PessoaDTO;
import br.com.gestor.model.PessoaModel;
import br.com.gestor.repository.PessoaRepository;
import br.com.gestor.service.mappers.PessoaMapper;

@SpringBootTest
public class PessoaServiceTest {
	
	@Value("${cadastro.pessoa.url}")
	private String urlCadastroPessoa;
	
	@InjectMocks
	PessoaService pessoaService;
	
	@Mock
	PessoaRepository pessoaRepository;
	
	@Mock
	PessoaMapper modelMapper;
	
	@Mock
	RestTemplate restTemplate;
	
	@Test
	void inserirPessoas_sucesso() {
		
		var pessoaDTO = inserirPessoa();
		var pessoaDTORetorno = pessoaDTO;
		pessoaDTORetorno.setId(1L);
		
		when(restTemplate.postForEntity(urlCadastroPessoa, pessoaDTO, PessoaDTO.class))
						.thenReturn(ResponseEntity.ok(pessoaDTORetorno));
		
		try {
			pessoaService.inserirPessoas(pessoaDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(true, pessoaDTORetorno.getId() > 0);
	}

	@Test
	void listagem_sucesso() {
		when(pessoaRepository.findAll()).thenReturn(listaPessoas());
		List<PessoaDTO> listagemPessoas = pessoaService.listagem();
		assertEquals(true, listagemPessoas.size() > 0);
	}
	
	private List<PessoaModel> listaPessoas(){
		List<PessoaModel> pessoas = new ArrayList<>();
		PessoaModel pessoa = new PessoaModel();
		pessoa.setCpf("000.000.000-91");
		pessoa.setNome("Pedro da Silva");
		pessoa.setGerente(false);
		pessoa.setDataNascimento(LocalDate.now());
		pessoa.setId(1L);
		
		pessoas.add(pessoa);
		return pessoas;
	}

	private PessoaDTO inserirPessoa(){
		PessoaDTO pessoa = new PessoaDTO();
		pessoa.setCpf("000.000.000-91");
		pessoa.setNome("Pedro da Silva");
		pessoa.setGerente(false);
		pessoa.setDataNascimento(LocalDate.now());
		return pessoa;
	}
}
