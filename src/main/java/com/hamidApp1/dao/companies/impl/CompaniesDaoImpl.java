package com.hamidApp1.dao.companies.impl;

import com.hamidApp1.dao.companies.CompaniesQueryDao;
import com.hamidApp1.model.companies.Companies;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Component
public class CompaniesDaoImpl implements CompaniesQueryDao {

    @PersistenceUnit
    protected EntityManagerFactory emf;
    @PersistenceContext
    protected EntityManager em;
    @Override
    public List<Companies> findAll() {
        TypedQuery<Companies> usersQuery = em.createQuery("SELECT u FROM com.hamidApp1.model.companies.Companies u", Companies.class);
        List<Companies> usersRes = usersQuery.getResultList();
        System.out.println("Users: " + usersRes);
        System.out.println("Done...");
        return usersRes;
    }
}
