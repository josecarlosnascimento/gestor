package br.com.gestor.controller.dto;

import java.util.List;

import lombok.Data;

@Data
public class MembroDTO {

	private Long id;
	
	private ProjetoDTO projeto;

	private List<PessoaDTO> pessoas;
}
