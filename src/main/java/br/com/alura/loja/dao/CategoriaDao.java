package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDao {

    private EntityManager em;

    // Construtor da classe CategoriaDao que recebe um EntityManager como argumento
    public CategoriaDao(EntityManager em) {
        this.em = em;
    }

    // Método para cadastrar uma nova categoria no banco de dados
    public void cadastrar(Categoria categoria) {
        this.em.persist(categoria);
    }

    // Método para atualizar os dados de uma categoria existente no banco de dados
    public void aualizar(Categoria categoria) {
        this.em.merge(categoria);
    }

    // Método para remover uma categoria do banco de dados
    public void remover(Categoria categoria) {
        // Precisamos fazer o merge da entidade antes de removê-la, pois ela pode estar no estado detached
        // e para remover uma entidade, ela precisa estar no estado managed.
        categoria = em.merge(categoria); // importante lembrar de reatribuir a categoria após o merge
        this.em.remove(categoria);
    }
}

