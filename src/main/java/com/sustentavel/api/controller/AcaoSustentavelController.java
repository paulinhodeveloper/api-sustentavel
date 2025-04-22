package com.sustentavel.api.controller;

import com.sustentavel.api.dto.*;
import com.sustentavel.api.service.AcaoSustentavelService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/acoes")
public class AcaoSustentavelController {

    private final AcaoSustentavelService service;

    public AcaoSustentavelController(AcaoSustentavelService service) {
        this.service = service;
    }

    @GetMapping
    public List<AcaoSustentavelResponse> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcaoSustentavelResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<AcaoSustentavelResponse> criar(@Valid @RequestBody AcaoSustentavelRequest dto) {
        return ResponseEntity.ok(service.salvar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcaoSustentavelResponse> atualizar(@PathVariable Long id, @Valid @RequestBody AcaoSustentavelRequest dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}