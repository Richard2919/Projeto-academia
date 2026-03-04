package com.example.academia.repository;

import com.example.academia.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    //busca personalizada por cpf
    Optional<Aluno> findByCpf(String cpf); //funciona como um select do SQL

    List<Aluno> findByNomeContainingIgnoreCase(String nome); //usado para buscar o campo nome e tenha valor
                                                            // e ignore letras maiusculas e minusculas

    List<Aluno> findByMensalidadeEmdiaTrueAndDataVencimentoBefore(LocalDate data);

}
