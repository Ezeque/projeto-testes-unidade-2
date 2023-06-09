package com.pds.planit.dao;

import com.pds.planit.entity.Tarefa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class TarefaDAOImpl implements TarefaDAO{

    private EntityManager entityManager;

    @Autowired
    public TarefaDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Tarefa tarefa) {
        entityManager.persist(tarefa);

    }

    public void edit(Tarefa tarefa){
        entityManager.merge(tarefa);
    }

    @Override
    public Tarefa findById(int id) {
        return entityManager.find(Tarefa.class, id);
    }

    @Override
    public Tarefa findByName(String nome) {
        return entityManager.find(Tarefa.class, nome);
    }

    @Override
    public List<Tarefa> findAll() {
        TypedQuery<Tarefa> query = entityManager.createQuery("FROM Tarefa", Tarefa.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Tarefa tarefa) {
        entityManager.merge(tarefa);
    }

    @Override
    public void delete(int id) {
        Tarefa tarefa = entityManager.find(Tarefa.class, id);

        entityManager.remove(tarefa);
    }
}
