package com.example.academia.controller;

import com.example.academia.entity.Aluno;
import com.example.academia.entity.Exercicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.academia.service.AlunoService;
import com.example.academia.service.ExercicioService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private ExercicioService exercicioService;

    // O Professor usa isso para confirmar que o aluno pagou
    @PatchMapping("/alunos/{id}/pagamento")
    public ResponseEntity<Void> atualizarPagamento(@PathVariable Long id, @RequestParam Boolean status) {
        Aluno aluno = alunoService.buscaPorId(id).orElseThrow();
        aluno.setMensalidadeEmdia(status);
        alunoService.salvar(aluno);
        return ResponseEntity.ok().build();
    }

    // O Professor usa isso para adicionar exercícios novos ao catálogo
    @PostMapping("/exercicios")
    public Exercicios cadastrarExercicio(@RequestBody Exercicios exercicio) {
        return exercicioService.cadastrar(exercicio);
    }
}