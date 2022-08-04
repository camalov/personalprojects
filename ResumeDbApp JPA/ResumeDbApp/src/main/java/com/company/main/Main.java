package com.company.main;

import com.company.dao.inter.UserDaoInter;

import java.sql.SQLException;

public class Main {
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException { // loosely coupling, thightly coupling
//        SkillDaoInter skillDao = Context.instanceSkillDao();
//        CountryDaoInter countryDao = Context.instanceCountryDao();
        /*
//        List<User> user = userDao.getAll();
//        System.out.println("list : " + user);
        User u = userDao.getById(5);
//        userDao.addUser(u);
        System.out.println(u);
        u.setName("Azay");
        u.setSurname("Cəlilov");
        u.setEmail("celilov@gmail.com");
        u.setPhone("+994515153227");
        userDao.updateUser(u);
         */
        
        UserDaoInter userDao = Context.instanceUserDao();
        System.out.println(userDao.getById(1).getName());
        
    }
    
}
