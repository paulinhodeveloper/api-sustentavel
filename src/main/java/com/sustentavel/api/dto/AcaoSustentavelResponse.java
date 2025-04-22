package com.sustentavel.api.dto;

import com.sustentavel.api.model.CategoriaAcao;
import java.time.LocalDate;

public record AcaoSustentavelResponse(
    Long id,
    String titulo,
    String descricao,
    CategoriaAcao categoria,
    LocalDate dataRealizacao,
    String responsavel
) {}