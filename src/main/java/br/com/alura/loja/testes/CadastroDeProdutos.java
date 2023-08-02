package br.com.alura.loja.testes;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProdutos {

    public static void main(String[] args) {
        // Chamando o método para cadastrar um produto e uma categoria no banco de dados
        cadastrarProduto();

        // Obtendo o EntityManager
        EntityManager em = JPAUtil.getEntityManager();

        // Criando um ProdutoDao com o EntityManager
        ProdutoDao dao = new ProdutoDao(em);

        // Buscando um produto pelo id
        Produto p = dao.buscarPorId(1L);
        System.out.println(p.getPreco());

        // Buscando todos os produtos de uma determinada categoria e imprimindo os nomes
        List<Produto> todos = dao.buscarPorNomeDaCategoria("celulares");
        todos.forEach(p2 -> System.out.println(p.getNome()));

        // Buscando o preço de um produto pelo nome
        BigDecimal precoDoProduto = dao.buscarPrecoDoProdutoComNome("Xiaomi");
        System.out.println(precoDoProduto);
    }

    private static void cadastrarProduto() {
        // Criando uma nova categoria chamada "celulares"
        Categoria celulares = new Categoria("celulares");

        // Criando um novo produto com informações específicas e associando-o à categoria "celulares"
        Produto celular = new Produto("Xiaomi", "Muito legal", new BigDecimal(800), celulares);

        // Obtendo o EntityManager
        EntityManager em = JPAUtil.getEntityManager();

        // Criando instâncias do ProdutoDao e CategoriaDao com o EntityManager
        ProdutoDao dao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        // Iniciando uma transação
        em.getTransaction().begin();

        // Cadastrando a categoria "celulares" no banco de dados
        categoriaDao.cadastrar(celulares);

        // Cadastrando o produto "Xiaomi" no banco de dados
        dao.cadastrar(celular);

        // Comitando a transação
        em.getTransaction().commit();

        // Fechando o EntityManager
        em.close();
    }
}


