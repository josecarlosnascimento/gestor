package br.com.gestor.service.mappers;

import br.com.gestor.controller.dto.PessoaDTO;
import br.com.gestor.controller.dto.ProjetoDTO;
import br.com.gestor.model.PessoaModel;
import br.com.gestor.model.ProjetoModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-13T18:21:32-0300",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 1.3.1200.v20200916-0645, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class ProjetoMapperImpl implements ProjetoMapper {

    @Override
    public ProjetoDTO toDTO(ProjetoModel projetoModel) {
        if ( projetoModel == null ) {
            return null;
        }

        ProjetoDTO projetoDTO = new ProjetoDTO();

        projetoDTO.setGerente( pessoaModelToPessoaDTO( projetoModel.getPessoa() ) );
        projetoDTO.setDataInicio( projetoModel.getDataInicio() );
        projetoDTO.setDataPrevisao( projetoModel.getDataPrevisao() );
        projetoDTO.setDataTemino( projetoModel.getDataTemino() );
        projetoDTO.setDescricao( projetoModel.getDescricao() );
        projetoDTO.setId( projetoModel.getId() );
        projetoDTO.setNome( projetoModel.getNome() );
        projetoDTO.setOrcamento( projetoModel.getOrcamento() );
        projetoDTO.setRisco( projetoModel.getRisco() );
        projetoDTO.setStatus( projetoModel.getStatus() );

        return projetoDTO;
    }

    @Override
    public ProjetoModel toModel(ProjetoDTO projetoDTO) {
        if ( projetoDTO == null ) {
            return null;
        }

        ProjetoModel projetoModel = new ProjetoModel();

        projetoModel.setDataInicio( projetoDTO.getDataInicio() );
        projetoModel.setDataPrevisao( projetoDTO.getDataPrevisao() );
        projetoModel.setDataTemino( projetoDTO.getDataTemino() );
        projetoModel.setDescricao( projetoDTO.getDescricao() );
        projetoModel.setId( projetoDTO.getId() );
        projetoModel.setNome( projetoDTO.getNome() );
        projetoModel.setOrcamento( projetoDTO.getOrcamento() );
        projetoModel.setRisco( projetoDTO.getRisco() );
        projetoModel.setStatus( projetoDTO.getStatus() );

        return projetoModel;
    }

    protected PessoaDTO pessoaModelToPessoaDTO(PessoaModel pessoaModel) {
        if ( pessoaModel == null ) {
            return null;
        }

        PessoaDTO pessoaDTO = new PessoaDTO();

        pessoaDTO.setId( pessoaModel.getId() );
        pessoaDTO.setNome( pessoaModel.getNome() );
        pessoaDTO.setDataNascimento( pessoaModel.getDataNascimento() );
        pessoaDTO.setCpf( pessoaModel.getCpf() );
        pessoaDTO.setGerente( pessoaModel.isGerente() );

        return pessoaDTO;
    }
}
