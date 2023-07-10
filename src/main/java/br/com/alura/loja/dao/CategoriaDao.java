package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDao {

    private EntityManager em;

    // Construtor classe dao com EntityManager como argumento
    public CategoriaDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Categoria categoria) {
        this.em.persist(categoria);
    }

    public void aualizar(Categoria categoria) { //
        this.em.merge(categoria);

    }
}
