package br.com.alura.loja.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    // Criando o objeto EntityManagerFactory, que é responsável por criar instâncias do EntityManager
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("loja");

    // Método estático que retorna um EntityManager para interagir com o banco de dados
    public static EntityManager getEntityManager() {
        // Cria e retorna uma instância do EntityManager
        return FACTORY.createEntityManager();
    }
}
