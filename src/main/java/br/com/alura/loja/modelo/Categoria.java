package br.com.alura.loja.modelo;

import javax.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {

    // Identificador único da categoria (chave primária)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Nome da categoria
    @Column(name = "nome")
    private String nome;

    // Construtor padrão necessário para o JPA
    public Categoria() {}

    // Construtor que recebe o nome da categoria como parâmetro
    public Categoria(String nome) {
        this.nome = nome;
    }

    // Método para obter o nome da categoria
    public String getNome() {
        return nome;
    }

    // Método para definir o nome da categoria
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método para obter o ID da categoria (chave primária)
    public Long getId() {
        return id;
    }

    // Método para definir o ID da categoria (chave primária)
    public void setId(Long id) {
        this.id = id;
    }
}
