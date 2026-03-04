package com.example.academia.controller;


import com.example.academia.entity.Ficha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.academia.service.FichaService;

import java.util.List;

@RestController
@RequestMapping("/api/fichas")
public class FichaController {
    @Autowired
    private FichaService fichaService;

    @PostMapping("/aluno/{alunoId}")
    public ResponseEntity<Ficha> criarFicha(@PathVariable Long alunoId, @RequestBody Ficha ficha) {
        try {
            Ficha novaFicha = fichaService.criarFichaParaAluno(alunoId, ficha);
            return ResponseEntity.ok(novaFicha);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Necessidade: Listar todas as fichas de um aluno específico
    @GetMapping("/aluno/{alunoId}")
    public List<Ficha> listarPorAluno(@PathVariable Long alunoId) {
        return fichaService.listarFichasdoAluno(alunoId);
    }
}
