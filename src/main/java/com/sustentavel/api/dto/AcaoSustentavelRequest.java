package com.sustentavel.api.dto;

import com.sustentavel.api.model.CategoriaAcao;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record AcaoSustentavelRequest(
    @NotBlank @Size(max = 100) String titulo,
    @NotBlank @Size(max = 1000) String descricao,
    @NotNull CategoriaAcao categoria,
    @NotNull @PastOrPresent LocalDate dataRealizacao,
    @NotBlank @Size(max = 100) String responsavel
) {}