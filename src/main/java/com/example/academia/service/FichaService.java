package com.example.academia.service;


import com.example.academia.entity.Aluno;
import com.example.academia.entity.Ficha;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.academia.repository.AlunoRepository;
import com.example.academia.repository.FichaRepository;

import java.util.List;

@Service
public class FichaService {

    @Autowired
    FichaRepository fichaRepository;

    @Autowired
    AlunoRepository alunoRepository;

    @Transactional//Usei essa anotação porque estamos lidando com uma operação que afeta a consistência.
    // Se algo der errado ao salvar os exercícios da ficha, o banco faz o "rollback" e não salva uma ficha vazia.
    public Ficha criarFichaParaAluno(Long alunoId, Ficha novaFicha){
        //verifica se o aluno existe
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + alunoId));

        //vincular ficha ao aluno
        novaFicha.setAluno(aluno);

        return fichaRepository.save(novaFicha);
    }

    public List<Ficha> listarFichasdoAluno(Long alunoId){
        return fichaRepository.findByAlunoId(alunoId);
    }
}
