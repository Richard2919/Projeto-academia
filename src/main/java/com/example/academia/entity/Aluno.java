package com.example.academia.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "alunos")
public class Aluno{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true, nullable = false, length = 14)
    private String cpf;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "data_cadastro", nullable = false, updatable = false)
    private LocalDate dataCadastro;

    //usado para que: garante que será definido no momento da persistência.
    @PrePersist
    public void prePersist(){
        this.dataCadastro = LocalDate.now();
    }

    @Column(length = 15)
    private String telefone;

    private Double peso;

    private Double altura;

    private Boolean mensalidadeEmdia;

    // Relacionamento: Um aluno pode ter várias fichas ao longo do tempo
    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)

    @JsonIgnore //usado para não causar loop infinitos
    private List<Ficha> fichas = new ArrayList<>();

    public Aluno(){
    }

    public Aluno(Long id, String nome, String cpf, LocalDate dataNascimento, String telefone, Double peso, Double altura, Boolean mensalidadeEmdia) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.peso = peso;
        this.altura = altura;
        this.mensalidadeEmdia = mensalidadeEmdia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Boolean getMensalidadeEmdia() {
        return mensalidadeEmdia;
    }

    public void setMensalidadeEmdia(Boolean mensalidadeEmdia) {
        this.mensalidadeEmdia = mensalidadeEmdia;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(List<Ficha> fichas) {
        this.fichas = fichas;
    }
}
