package br.com.gestor.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "pessoa")
public class PessoaModel {
	
	@Id
	private Long id;
	
	private String nome;
	
	private LocalDate dataNascimento;
	
	private String cpf;
	
	private boolean gerente;

}
