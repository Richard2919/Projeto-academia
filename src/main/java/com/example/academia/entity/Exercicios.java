package com.example.academia.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "exercicios")
public class Exercicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nomeTecnico;

    @Column(nullable = false)
    private String nomePopular;

   @Enumerated(EnumType.STRING)
   @Column(name = "grupo_muscular")
   private GrupoMuscular grupoMuscular;

    public Exercicios(){
    }

    public Exercicios(String nomeTecnico, String nomePopular, GrupoMuscular grupoMuscular) {
        this.nomeTecnico = nomeTecnico;
        this.nomePopular = nomePopular;
        this.grupoMuscular = grupoMuscular;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeTecnico() {
        return nomeTecnico;
    }

    public void setNomeTecnico(String nomeTecnico) {
        this.nomeTecnico = nomeTecnico;
    }

    public String getNomePopular() {
        return nomePopular;
    }

    public void setNomePopular(String nomePopular) {
        this.nomePopular = nomePopular;
    }

    public GrupoMuscular getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(GrupoMuscular grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }
}
