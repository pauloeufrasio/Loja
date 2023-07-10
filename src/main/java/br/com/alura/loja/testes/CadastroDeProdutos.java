package br.com.alura.loja.testes;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.util.JPAUtil;
import javax.persistence.EntityManager;

public class CadastroDeProdutos {

    public static void main(String[] args) {

        Categoria celulares = new Categoria("Celulares");

        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        em.persist(celulares);
        celulares.setNome("12121");

        em.flush(); // para sincronizar esses dados com o banco de dados
        em.clear();// para limpar todos os objetos da memória, ou seja, do PersistenceContext. Se realizássemos o clear() antes do flush() então perderíamos todas as nossas alterações.

        celulares = em.merge(celulares); // merge() salva e atualiza o objeto e retorna tal como ele foi salvo no banco de dados. Entenda, o merge atualiza o registro e não apenas insere ele no banco.
        celulares.setNome("4321");
        em.flush();
//        em.getTransaction().commit(); // Apos terminar comita transacao no banco de dados

//         em.close(); // fechando banco de dados
        em.remove(celulares); // Para excluir, temos a seguinte situação: do estado managed, podemos chamar o método remove() do EntityManager e ela passa para o estado REMOVED. Quando o commit() ou o flush() for chamado, ele vai sincronizar o remove() com o banco de dados disparando um delete]
        em.flush();


    }
}
