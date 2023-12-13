package br.com.gestor.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ProjetoDTO {

	private Long id;
	
	@NotBlank(message = "Preencha o Nome do Projeto")
	private String nome;
	
	@NotNull(message = "Preencha a Data de Inicio")
	private LocalDate dataInicio;

	@NotNull(message = "Preencha a Data de Previsao de Termino")
	private LocalDate dataPrevisao;

	@NotNull(message = "Preencha a Data de Termino")
	private LocalDate dataTemino;

	@NotBlank(message = "Preencha a Descrição")
	private String descricao;

	@NotBlank(message = "Preencha o Status")
	private String status;
	
	@NotNull(message = "Preencha o Valor Previsto de Orçamento")
	private BigDecimal orcamento;

	@NotBlank(message = "Preencha o Risco")
	private String risco;

	@NotNull
	private PessoaDTO gerente;
	
	public boolean isPermiteExclusao() {
		if(status.equals("INICIADO") ||
		   status.equals("EM ANDAMENTO") ||
		   status.equals("ENCERRADO")){
			return false;
		}
		return true;
	}
}
