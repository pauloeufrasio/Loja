package br.com.alura.loja.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    // precisamos criar outro objeto, que é o EntityManagerFactory. Nos padrões de projeto, "design patterns", existe esse padrão de projeto chamado factory, e, há uma factory para isolar a criação do EntityManager
    private static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("loja"); // Classe responsavel pelo método estatico createEntityManagerFactory
    // Toda vez que desejarmos acessar o banco de dados, seja para salvar, excluir, atualizar, carregar, fazer um select, ou qualquer outra operação que quisermos fazer no banco de dados com a JPA, nós utilizaremos a interface EntityManager
    public static EntityManager getEntityManager(){
        return FACTORY.createEntityManager();
    }

}
