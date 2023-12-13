package br.com.gestor.controller.dto;

import lombok.Data;

@Data
public class MembroDTO {

	private Long id;
	
	private PessoaDTO pessoa;
	
	private ProjetoDTO projeto;
}
