package com.company.resume.util;

import com.company.dao.inter.CountryDaoInter;
import com.company.entity.Country;
import com.company.main.Context;

import java.util.List;

public class CountryRequestUtil {

    public static List<Country> getAll() {
        CountryDaoInter countryDao = Context.instanceCountryDao();
        List<Country> countries = countryDao.getAll();
        return countries;
    }

}
