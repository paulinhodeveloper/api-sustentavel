package com.sustentavel.api.repository;

import com.sustentavel.api.model.AcaoSustentavel;
import com.sustentavel.api.model.CategoriaAcao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcaoSustentavelRepository extends JpaRepository<AcaoSustentavel, Long> {
    List<AcaoSustentavel> findByCategoria(CategoriaAcao categoria);
}