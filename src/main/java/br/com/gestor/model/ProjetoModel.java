package br.com.gestor.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "projeto")
public class ProjetoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private LocalDate dataInicio;
	private LocalDate dataPrevisao;
	private LocalDate dataTemino;
	
	private String descricao;
	private String status;
	private BigDecimal orcamento;
	private String risco;
	
	@ManyToOne
	@JoinColumn(name = "gerente_id")
	private PessoaModel pessoa;


}