package br.com.gestor.service.mappers;

import br.com.gestor.controller.dto.PessoaDTO;
import br.com.gestor.model.PessoaModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-13T18:21:31-0300",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 1.3.1200.v20200916-0645, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class PessoaMapperImpl implements PessoaMapper {

    @Override
    public PessoaDTO toDTO(PessoaModel pessoaModel) {
        if ( pessoaModel == null ) {
            return null;
        }

        PessoaDTO pessoaDTO = new PessoaDTO();

        pessoaDTO.setCpf( pessoaModel.getCpf() );
        pessoaDTO.setDataNascimento( pessoaModel.getDataNascimento() );
        pessoaDTO.setGerente( pessoaModel.isGerente() );
        pessoaDTO.setId( pessoaModel.getId() );
        pessoaDTO.setNome( pessoaModel.getNome() );

        return pessoaDTO;
    }

    @Override
    public PessoaModel toModel(PessoaDTO pessoaDTO) {
        if ( pessoaDTO == null ) {
            return null;
        }

        PessoaModel pessoaModel = new PessoaModel();

        pessoaModel.setCpf( pessoaDTO.getCpf() );
        pessoaModel.setDataNascimento( pessoaDTO.getDataNascimento() );
        pessoaModel.setGerente( pessoaDTO.isGerente() );
        pessoaModel.setId( pessoaDTO.getId() );
        pessoaModel.setNome( pessoaDTO.getNome() );

        return pessoaModel;
    }
}
