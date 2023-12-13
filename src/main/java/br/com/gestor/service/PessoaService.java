package br.com.gestor.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.gestor.controller.dto.PessoaDTO;
import br.com.gestor.repository.PessoaRepository;
import br.com.gestor.service.mappers.PessoaMapper;

@Service
public class PessoaService {

	@Value("${cadastro.pessoa.url}")
	private String urlCadastroPessoa;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public PessoaDTO inserirPessoas(PessoaDTO pessoa) {
		ResponseEntity<PessoaDTO> entity = restTemplate.postForEntity(urlCadastroPessoa, pessoa, PessoaDTO.class);
		return entity.getBody();
	}
	
	public List<PessoaDTO> listagem(){
		return pessoaRepository.findAll()
				.stream().map(p -> PessoaMapper.MAPPER.toDTO(p))
				.collect(Collectors.toList());
	}
}
