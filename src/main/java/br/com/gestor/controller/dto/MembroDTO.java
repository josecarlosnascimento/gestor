package br.com.gestor.controller.dto;

import java.util.Set;

import lombok.Data;

@Data
public class MembroDTO {

	private Long id;
	
	private ProjetoDTO projeto;

	private Set<PessoaDTO> pessoas;
}
