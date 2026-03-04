package com.example.academia.repository;

import com.example.academia.entity.Exercicios;
import com.example.academia.entity.GrupoMuscular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExercicioRepository extends JpaRepository<Exercicios, Long> {

    // Busca exercícios pelo grupo muscular (Ex: PEITO, PERNAS)
    List<Exercicios> findByGrupoMuscular(GrupoMuscular grupo);

    // Busca pelo nome popular para facilitar a pesquisa no app
    List<Exercicios> findByNomePopularContainingIgnoreCase(String nome);
}
