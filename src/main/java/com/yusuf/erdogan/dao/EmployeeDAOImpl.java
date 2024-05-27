package com.yusuf.erdogan.dao;

import com.yusuf.erdogan.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);

        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        TypedQuery<Employee> query = entityManager.createQuery("SELECT e from Employee e WHERE e.id =: id", Employee.class);
        query.setParameter("id", id);
        return query.getResultList().get(0);
    }

    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(int id) {
        Query query = entityManager.createQuery("DELETE FROM Employee WHERE id =: id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void delete(Employee employee) {
        entityManager.remove(employee);
    }
}
