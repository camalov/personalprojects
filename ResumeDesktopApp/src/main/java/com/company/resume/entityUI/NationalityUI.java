package com.company.resume.entityUI;

import com.company.entity.Country;
import com.company.entity.User;

public class NationalityUI extends Country {

    public NationalityUI(int id, String name, String nationality) {
        super(id, name, nationality);
    }

    public NationalityUI(Country c) {
        this(c.getId(), c.getName(), c.getNationality());
    }

    public NationalityUI(User u) {
        this(u.getNationality().getId(), u.getBirthplace().getName(), u.getBirthplace().getNationality());
    }

    @Override
    public String toString() {
        return getNationality();
    }
}
