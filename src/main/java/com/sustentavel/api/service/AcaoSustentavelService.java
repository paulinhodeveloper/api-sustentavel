package com.sustentavel.api.service;

import com.sustentavel.api.dto.*;
import com.sustentavel.api.exception.RecursoNaoEncontradoException;
import com.sustentavel.api.mapper.AcaoSustentavelMapper;
import com.sustentavel.api.model.AcaoSustentavel;
import com.sustentavel.api.model.CategoriaAcao;
import com.sustentavel.api.repository.AcaoSustentavelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AcaoSustentavelService {

    private final AcaoSustentavelRepository repository;

    public AcaoSustentavelService(AcaoSustentavelRepository repository) {
        this.repository = repository;
    }

    public List<AcaoSustentavelResponse> listarTodos() {
        return repository.findAll().stream()
            .map(AcaoSustentavelMapper::toResponse)
            .collect(Collectors.toList());
    }

    public AcaoSustentavelResponse buscarPorId(Long id) {
        AcaoSustentavel acao = repository.findById(id)
            .orElseThrow(() -> new RecursoNaoEncontradoException("Ação com ID " + id + " não encontrada."));
        return AcaoSustentavelMapper.toResponse(acao);
    }

    public List<AcaoSustentavelResponse> listarPorCategoria(CategoriaAcao categoria) {
        return repository.findByCategoria(categoria)
            .stream()
            .map(AcaoSustentavelMapper::toResponse)
            .collect(Collectors.toList());
    }

    public AcaoSustentavelResponse salvar(AcaoSustentavelRequest dto) {
        AcaoSustentavel acao = AcaoSustentavelMapper.toEntity(dto);
        return AcaoSustentavelMapper.toResponse(repository.save(acao));
    }

    public AcaoSustentavelResponse atualizar(Long id, AcaoSustentavelRequest dto) {
        AcaoSustentavel existente = repository.findById(id)
            .orElseThrow(() -> new RecursoNaoEncontradoException("Ação com ID " + id + " não encontrada."));

        existente.setTitulo(dto.titulo());
        existente.setDescricao(dto.descricao());
        existente.setCategoria(dto.categoria());
        existente.setDataRealizacao(dto.dataRealizacao());
        existente.setResponsavel(dto.responsavel());

        return AcaoSustentavelMapper.toResponse(repository.save(existente));
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Ação com ID " + id + " não encontrada para exclusão.");
        }
        repository.deleteById(id);
    }
}