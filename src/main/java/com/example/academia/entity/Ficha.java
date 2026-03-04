package com.example.academia.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fichas")
public class Ficha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String objetivo; //ex: hipertrofia, etc

    private LocalDate dataInicio;

    private LocalDate dataRevisao; //quando treino deve ser trocado

    @Column(columnDefinition = "TEXT")
    private String observacoesMedicas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id", nullable = false)
    @JsonIgnore
    private Aluno aluno;

    @OneToMany(mappedBy = "ficha", cascade = CascadeType.ALL)
    private List<ItemTreino> exercicios = new ArrayList<>();

    public Ficha(){
    }

    public Ficha(Long id, String objetivo, LocalDate dataInicio, LocalDate dataRevisao, String observacoesMedicas, Aluno aluno) {
        this.id = id;
        this.objetivo = objetivo;
        this.dataInicio = dataInicio;
        this.dataRevisao = dataRevisao;
        this.observacoesMedicas = observacoesMedicas;
        this.aluno = aluno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataRevisao() {
        return dataRevisao;
    }

    public void setDataRevisao(LocalDate dataRevisao) {
        this.dataRevisao = dataRevisao;
    }

    public String getObservacoesMedicas() {
        return observacoesMedicas;
    }

    public void setObservacoesMedicas(String observacoesMedicas) {
        this.observacoesMedicas = observacoesMedicas;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void addExercicio(ItemTreino item){
        if(item != null) {
            this.exercicios.add(item);
            item.setFicha(this);// Sincroniza o lado "ManyToOne"
        }
    }

    public void removeExercicio(ItemTreino item){
        this.exercicios.remove(item);
        item.setFicha(null); //remove a referência para que o JPA saiba que a ligação acabou
    }

    public List<ItemTreino> getExercicios() {
        return exercicios;
    }

    public void setExercicios(List<ItemTreino> exercicios) {
        this.exercicios = exercicios;
    }
}
