package br.com.gestor.controller.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {
	
	private Long id;
	private String nome;
	private LocalDate dataNascimento;
	private String cpf;
	private boolean gerente;
	
	private boolean membro;
	
}
