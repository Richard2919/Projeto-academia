package com.example.academia.controller;

import com.example.academia.entity.Aluno;
import com.example.academia.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/financeiro")
public class FinanceiroController {

    @Autowired
    private AlunoService alunoService;

    // Listar apenas alunos com mensalidade pendente
    @GetMapping("/pendentes")
    public List<Aluno> listarInadimplentes() {
        return alunoService.listarTodos().stream()
                .filter(aluno -> !aluno.getMensalidadeEmdia())
                .collect(Collectors.toList());
    }

    //  Professor dar baixa no pagamento (alterar para true)
    @PatchMapping("/confirmar-pagamento/{id}")
    public Aluno confirmarPagamento(@PathVariable Long id) {
        Aluno aluno = alunoService.buscaPorId(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        aluno.setMensalidadeEmdia(true);
        return alunoService.salvar(aluno);
    }
}