package com.lesson5;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional

//транзакциями тут занимается Спринг
public class DAO {
    @PersistenceContext // эта аннотация связывает наш entityManager с бином Споринга
    // entityManagerFactory тут dependencyInjection

    //используем дополнительную библиотеку которая позволяет работать с БД
    //позволяет создавать кастомные запросы типа  entityManager.createQuery

    //мы не думаем о закрытии сессии
    private EntityManager entityManager;// entityManager это сущность Hibernate


    public Item save(Item item) {
        entityManager.persist(item);//метод persist - сохранение, merge - update
        //detach - analog delete
        return item;
    }
}
