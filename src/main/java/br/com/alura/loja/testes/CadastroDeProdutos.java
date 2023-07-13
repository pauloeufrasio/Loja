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
        cadastrarProduto();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao dao = new ProdutoDao(em);

            Produto p = dao.buscarPorId(1l);
            System.out.println(p.getPreco());

            List<Produto> todos = dao.buscarPorNomeDaCategoria("celulares");
            todos.forEach(p2-> System.out.println(p.getNome()));

            BigDecimal precoDoProduto = dao.buscarPrecoDoProdutoComNome("Xiaomi");
            System.out.println(precoDoProduto);

        }

    private static void cadastrarProduto() {
        Categoria celulares = new Categoria("celulares");
        Produto celular = new Produto("Xiaomi", "Muito legal", new BigDecimal(800), celulares);

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao dao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);
        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        dao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();


    }
}

