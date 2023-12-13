package br.com.gestor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gestor.model.MembroModel;

@Repository
public interface MembroRepoitory extends JpaRepository<MembroModel, Long>{

	List<MembroModel> findByProjetoId(Long idProjeto);
	
}
