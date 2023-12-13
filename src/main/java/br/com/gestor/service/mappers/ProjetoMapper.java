package br.com.gestor.service.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.gestor.controller.dto.ProjetoDTO;
import br.com.gestor.model.ProjetoModel;

@Mapper(componentModel = "spring")
public interface ProjetoMapper {
	
	ProjetoMapper MAPPER = Mappers.getMapper(ProjetoMapper.class);

	@Mapping(source = "pessoa.id", target = "gerente.id")
	@Mapping(source = "pessoa.nome", target = "gerente.nome")
	@Mapping(source = "pessoa.dataNascimento", target = "gerente.dataNascimento")
	@Mapping(source = "pessoa.cpf", target = "gerente.cpf")
	@Mapping(source = "pessoa.gerente", target = "gerente.gerente")
	ProjetoDTO toDTO(ProjetoModel projetoModel);

	ProjetoModel toModel(ProjetoDTO projetoDTO);

}
