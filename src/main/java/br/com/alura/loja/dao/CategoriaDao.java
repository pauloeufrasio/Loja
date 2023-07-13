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

    public void remover(Categoria categoria) { //
        categoria = em.merge(categoria); // importantíssimo lembrar de reatribuir. Estamos fazendo merge(), mas não guardamos a entidade mergeada, a entidade que está no estado managed, então, estamos mexendo na categoria que ainda está detached, por isso, precisamos reatribuir. Podemos fazer desta maneira, categoria = em.merge(categoria);, só para garantir que a entidade está managed.
        this.em.remove(categoria);

    }
}
