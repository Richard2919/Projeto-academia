package com.example.academia.repository;

import com.example.academia.entity.Ficha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FichaRepository extends JpaRepository<Ficha, Long> {

    // Busca todas as fichas de um aluno específico pelo ID dele
    List<Ficha> findByAlunoId(Long alunoId);
}
