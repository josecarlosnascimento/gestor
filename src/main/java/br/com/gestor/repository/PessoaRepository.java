package br.com.gestor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gestor.model.PessoaModel;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, Long>{

	List<PessoaModel> findByIdIn(List<Long> id);
	
	List<PessoaModel> findByGerente(boolean gerente);

}
