package br.com.gestor.service.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.gestor.controller.dto.PessoaDTO;
import br.com.gestor.model.PessoaModel;

@Mapper(componentModel = "spring")
public interface PessoaMapper {
	
	PessoaMapper MAPPER = Mappers.getMapper(PessoaMapper.class);

	PessoaDTO toDTO(PessoaModel pessoaModel);

	PessoaModel toModel(PessoaDTO pessoaDTO);

}
