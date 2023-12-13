package br.com.gestor.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "membro")
public class MembroModel {
	
	@Id
	private Long id;
	
	@OneToOne
	private PessoaModel pessoa;
	
	@OneToOne
	private ProjetoModel projeto;

}



