package com.example.academia.entity;

import jakarta.persistence.*;

@Entity
public class ItemTreino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercicios_id", nullable = false)
    private Exercicios exercicios; //qual exercicio? (ex: supino)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ficha_id")
    private Ficha ficha; //a qual ficha pertence

    private Integer series;
    private Integer repeticoes;
    private String carga;
    private Integer tempoDescanso;
    private String observacoes;

    public ItemTreino(){
    }

    public ItemTreino(Long id, Exercicios exercicios, Ficha ficha, Integer series, Integer repeticoes, String carga, Integer tempoDescanso, String observacoes) {
        this.id = id;
        this.exercicios = exercicios;
        this.ficha = ficha;
        this.series = series;
        this.repeticoes = repeticoes;
        this.carga = carga;
        this.tempoDescanso = tempoDescanso;
        this.observacoes = observacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Exercicios getExercicios() {
        return exercicios;
    }

    public void setExercicios(Exercicios exercicios) {
        this.exercicios = exercicios;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public Integer getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(Integer repeticoes) {
        this.repeticoes = repeticoes;
    }

    public String getCarga() {
        return carga;
    }

    public void setCarga(String carga) {
        this.carga = carga;
    }

    public Integer gettempoDescanso() {
        return tempoDescanso;
    }

    public void settempoDescanso(Integer tempoDescanso) {
        this.tempoDescanso = tempoDescanso;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
