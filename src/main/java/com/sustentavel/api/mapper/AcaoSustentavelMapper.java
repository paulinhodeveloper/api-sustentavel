package com.sustentavel.api.mapper;

import com.sustentavel.api.dto.*;
import com.sustentavel.api.model.AcaoSustentavel;

public class AcaoSustentavelMapper {

    public static AcaoSustentavel toEntity(AcaoSustentavelRequest dto) {
        AcaoSustentavel acao = new AcaoSustentavel();
        acao.setTitulo(dto.titulo());
        acao.setDescricao(dto.descricao());
        acao.setCategoria(dto.categoria());
        acao.setDataRealizacao(dto.dataRealizacao());
        acao.setResponsavel(dto.responsavel());
        return acao;
    }

    public static AcaoSustentavelResponse toResponse(AcaoSustentavel acao) {
        return new AcaoSustentavelResponse(
            acao.getId(),
            acao.getTitulo(),
            acao.getDescricao(),
            acao.getCategoria(),
            acao.getDataRealizacao(),
            acao.getResponsavel()
        );
    }
}