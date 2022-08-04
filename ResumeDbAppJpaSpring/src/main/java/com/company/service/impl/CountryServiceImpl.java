package com.company.service.impl;

import com.company.dao.inter.CountryDaoInter;
import com.company.entity.Country;
import com.company.service.inter.CountryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CountryServiceImpl implements CountryServiceInter {

    @Autowired
    CountryDaoInter countryDao;

    @Override
    public List<Country> getAll() {
        return countryDao.getAll();
    }
}
