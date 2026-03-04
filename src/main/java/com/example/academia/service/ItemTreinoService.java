package com.example.academia.service;

import com.example.academia.entity.ItemTreino;
import com.example.academia.repository.ItemTreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItemTreinoService {

    @Autowired
    private ItemTreinoRepository itemTreinoRepository;

   //Salva a personalização (carga/rep) de um exercício
    public ItemTreino salvar(ItemTreino item) {
        return itemTreinoRepository.save(item);
    }

    // Lista exercícios de uma ficha específica para o aluno ver
    public List<ItemTreino> listarPorFicha(Long fichaId) {
        return itemTreinoRepository.findByFichaId(fichaId);
    }

    // Atualiza apenas a carga ou repetição (ajuste do professor)
    public ItemTreino atualizarCarga(Long id, String novaCarga) {
        ItemTreino item = itemTreinoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item de treino não encontrado"));
        item.setCarga(novaCarga);
        return itemTreinoRepository.save(item);
    }
}