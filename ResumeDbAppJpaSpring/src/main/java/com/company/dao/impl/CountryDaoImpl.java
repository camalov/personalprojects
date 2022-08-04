package com.company.dao.impl;

import com.company.dao.inter.CountryDaoInter;
import com.company.entity.Country;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CountryDaoImpl implements CountryDaoInter {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Country> getAll() {
        Query query = em.createNamedQuery("Country.findAll", Country.class);
        List<Country> countries = query.getResultList();

        return countries;
    }
}
