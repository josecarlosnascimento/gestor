package br.com.gestor.controller.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {
	
	private Long id;
	
	@NotBlank(message = "Preencha o Nome da Pessoa")
	private String nome;
	
	@NotNull(message = "Preencha a Data de Nascimento da pessoa")
	private LocalDate dataNascimento;
	
	@NotBlank(message = "Preencha o CPF")
	private String cpf;
	
	private boolean gerente;
	
	private boolean membro;
	
}
