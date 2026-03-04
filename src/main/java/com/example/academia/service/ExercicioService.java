package com.example.academia.service;


import com.example.academia.entity.Exercicios;
import com.example.academia.entity.GrupoMuscular;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.academia.repository.ExercicioRepository;

import java.util.List;

@Service
public class ExercicioService {

    @Autowired
    private ExercicioRepository exercicioRepository;

    // Cadastra um novo exercicio no catalogo
    public Exercicios cadastrar(Exercicios exercicio){
        return exercicioRepository.save(exercicio);
    }

    // Lista todos os exercicios disponiveis
    List<Exercicios> listarTodos(){
        return exercicioRepository.findAll();
    }

    // Busca exercicios por grupo(ex: buscar todos de PEITO)
    public List<Exercicios> buscarPorGrupo(GrupoMuscular grupo){
        return exercicioRepository.findByGrupoMuscular(grupo);
    }


}
