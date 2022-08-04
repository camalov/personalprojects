package com.company.resume.entityUI;

import com.company.entity.Country;
import com.company.entity.User;

public class CountryUI extends Country {

    public CountryUI(int id, String name, String nationality) {
        super(id, name, nationality);
    }

    public CountryUI(Country c) {
        this(c.getId(), c.getName(), c.getNationality());
    }

    public CountryUI(User u) {
        this(u.getBirthplace().getId(), u.getBirthplace().getName(), u.getBirthplace().getNationality());
    }

    @Override
    public String toString() {
        return getName();
    }
}
