package br.com.gestor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gestor.model.ProjetoModel;

@Repository
public interface ProjetoRepository extends JpaRepository<ProjetoModel, Long>{

}
