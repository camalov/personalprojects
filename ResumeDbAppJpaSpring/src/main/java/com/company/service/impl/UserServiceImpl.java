package com.company.service.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.dao.repository.UserRepositoryCustom;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserServiceInter {

    @Autowired
    @Qualifier("userRepository")
    private UserRepositoryCustom userDao;

    private static BCrypt.Hasher crypt = BCrypt.withDefaults();

    @Override
    public List<User> getAll() {
        return getAll(null, null, null);
    }

    @Override
    public List<User> getAll(String name, String surname, Integer nationalityId) {
        return userDao.getAll(name, surname, nationalityId);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return userDao.findByEmailAndPassword(email, password);
    }

    //With JPQL
    @Override
    public User findByEmail(String email) {
        User user = userDao.findByEmail(email);

        return user;
    }

    @Override
    public User getById(int userId) {
        return userDao.getById(userId);
    }

    @Override
    public boolean addUser(User u) {
        return userDao.addUser(u);
    }

    @Override
    public boolean updateUser(User u) {
        return userDao.updateUser(u);
    }

    @Override
    public boolean remove(int id) {
        return userDao.remove(id);
    }

    public static byte[] hashPassword(String pass) {
        BCrypt.Hasher bCrypt = BCrypt.withDefaults();
        byte[] hashedPass = bCrypt.hash(7, pass.toCharArray());

        return hashedPass;
    }

    public static void main(String args[]) {
        /*
        User u = new User(0, "test", "test", "test@mail.com", "test", "asdsad", "baku", null, null, null);
        u.setBirthplace(new Country(1, "", ""));
        u.setNationality(new Country(1, "", ""));
        u.setPassword("12345");

        UserServiceInter userDao = Context.instanceUserDao();
        userDao.addUser(u);
         */

        byte[] hashedPass = hashPassword("12345");
        String value = new String(hashedPass);
        System.out.println(value);

    }

}
