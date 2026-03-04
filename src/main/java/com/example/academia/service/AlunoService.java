package com.example.academia.service;

import com.example.academia.entity.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.academia.repository.AlunoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    //salvar ou att aluno
    public Aluno salvar(Aluno aluno){
        Optional<Aluno> alunoExistente = alunoRepository.findByCpf(aluno.getCpf());
        if(alunoExistente.isPresent() && !alunoExistente.get().getId().equals(aluno.getId())){
            throw new RuntimeException("Já existe um aluno com esse CPF cadastrado");
        }
        return alunoRepository.save(aluno);
    }

    //lista todos os alunos
    public List<Aluno> listarTodos(){
        return alunoRepository.findAll();
    }

    // Busca por id
    public Optional<Aluno> buscaPorId(Long id){
        return alunoRepository.findById(id);
    }

    // Deleta aluno
    public void deletar(Long id){
        alunoRepository.deleteById(id);
    }
}
