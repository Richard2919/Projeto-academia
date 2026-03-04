package com.example.academia.repository;

import com.example.academia.entity.ItemTreino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ItemTreinoRepository extends JpaRepository<ItemTreino, Long> {

    List<ItemTreino> findByFichaId(Long fichaId);
}
