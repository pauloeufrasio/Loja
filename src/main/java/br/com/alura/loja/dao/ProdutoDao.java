package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoDao {

    private EntityManager em;

    // Construtor da classe ProdutoDao que recebe um EntityManager como argumento
    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    // Método para cadastrar um novo produto no banco de dados
    public void cadastrar(Produto produto) {
        this.em.persist(produto);
    }

    // Método para buscar um produto pelo seu ID no banco de dados
    public Produto buscarPorId(long id) {
        return em.find(Produto.class, id);
    }

    // Método para buscar todos os produtos no banco de dados
    public List<Produto> buscarTodos() {
        String jpql = "SELECT p FROM Produto p"; // Consulta JPQL para buscar todos os produtos
        return em.createQuery(jpql, Produto.class).getResultList();
    }

    // Método para buscar produtos pelo nome no banco de dados
    public List<Produto> buscarPorNome(String nome) {
        String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome"; // Consulta JPQL para buscar produtos pelo nome
        return em.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    // Método para buscar produtos pelo nome da categoria no banco de dados
    public List<Produto> buscarPorNomeDaCategoria(String nome) {
        String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome"; // Consulta JPQL para buscar produtos pelo nome da categoria
        return em.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    // Método para buscar o preço do produto com um determinado nome de categoria no banco de dados
    public BigDecimal buscarPrecoDoProdutoComNome(String nome) {
        String jpql = "SELECT p.preco FROM Produto p WHERE p.categoria.nome = :nome"; // Consulta JPQL para buscar o preço do produto pelo nome da categoria
        return em.createQuery(jpql, BigDecimal.class)
                .setParameter("nome", nome)
                .getSingleResult();
    }
}

