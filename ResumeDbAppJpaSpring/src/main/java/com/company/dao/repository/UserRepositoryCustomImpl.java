package com.company.dao.repository;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.entity.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository("userRepositoryCustom")
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    private static BCrypt.Hasher crypt = BCrypt.withDefaults();
//    private static BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();

    @Override
//    @Cacheable(value = "users")
    public List<User> getAll() {
        return getAll(null, null, null);
    }

    @Override
//    @Cacheable(value = "users")
    public List<User> getAll(String name, String surname, Integer nationalityId) {
        String jpql = "select u from User u where 1=1 ";

        if (name != null && !name.trim().isEmpty()) {
            jpql += "and u.name= :name ";
        }

        if (surname != null && !surname.trim().isEmpty()) {
            jpql += "and u.surname= :surname ";
        }

        if (nationalityId != null) {
            jpql += "and u.nationality.id= :nId";
        }

        Query query = em.createQuery(jpql, User.class);

        if (name != null && !name.trim().isEmpty()) {
            query.setParameter("name", name);
        }

        if (surname != null && !surname.trim().isEmpty()) {
            query.setParameter("surname", surname);
        }

        if (nationalityId != null) {
            query.setParameter("nId", nationalityId);
        }

        List<User> users = query.getResultList();

        return users;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        Query query = em.createQuery("select u from User u where u.email= :email and u.password= :password", User.class);
        query.setParameter("email", email);
        query.setParameter("password", password);

        List<User> users = query.getResultList();

        if (users.size() == 1) {
            return users.get(0);
        }

        return null;
    }

    public User findByEmailAndPasswordWithCriteriBuilder(String email, String password) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> postRoot = query.from(User.class);
        CriteriaQuery<User> where = query.where(cb.equal(postRoot.get("email"), email), cb.equal(postRoot.get("password"), password));

        Query executingQuery = em.createQuery(query);

        List<User> users = executingQuery.getResultList();

        if (users.size() == 1) {
            return users.get(0);
        }

        return null;
    }

    //With JPQL
    @Override
    public User findByEmail(String email) {
        Query query = em.createQuery("select u from User u where u.email= :email", User.class);
        query.setParameter("email", email);

        List<User> users = query.getResultList();


        if (users.size() == 1) {
            return users.get(0);
        }

        return null;
    }

    /*
    // findByEmailWithCriteriaBuilder
    @Override
    public User findByEmail(String email) {
        EntityManager em = em();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> postRoot = query.from(User.class);
        CriteriaQuery<User> where = query.where(cb.equal(postRoot.get("email"), email));

        Query executingQuery = em.createQuery(query);

        List<User> users = executingQuery.getResultList();

        em.close();

        if (users.size() == 1) {
            return users.get(0);
        }

        return null;
    }

    @Override // With NativeQuery
    public User findByEmail(String email) {
        EntityManager em = em();

        Query query = em.createNativeQuery("select * from user where email=?", User.class);
        query.setParameter(1, email);

        List<User> users = query.getResultList();

        em.close();

        if (users.size() == 1) {
            return users.get(0);
        }

        return null;
    }

    /*
    @Override // With NamedQuery
    public User findByEmail(String email) {
        EntityManager em = em();

        Query query = em.createNamedQuery("User.findByEmail", User.class);
        query.setParameter("email", email);

        List<User> users = query.getResultList();

        em.close();

        if (users.size() == 1) {
            return users.get(0);
        }

        return null;
    }
     */
    @Override
    public User getById(int userId) {
        User result = em.find(User.class, userId);
        return result;
    }

    @Override
    public boolean addUser(User u) {
        u.setPassword(crypt.hashToString(7, u.getPassword().toCharArray()));
//        u.setPassword(crypt.encode(u.getPassword()));

        em.persist(u);

        return true;
    }

    @Override
    public boolean updateUser(User u) {
        u.setPassword("12345");
        u.setPassword(crypt.hashToString(7, u.getPassword().toCharArray()));
//        u.setPassword(crypt.encode(u.getPassword()));

        em.merge(u);

        return true;
    }

    @Override
    @CacheEvict(value = "users", allEntries = true)
    public boolean remove(int id) {
        User u = em.find(User.class, id);

        em.remove(u);

        return true;
    }

    /*
public static byte[] hashPassword(String pass) {
    BCrypt.Hasher bCrypt = BCrypt.withDefaults();
    byte[] hashedPass = bCrypt.hash(7, pass.toCharArray());

    return hashedPass;
}
     */

    public static void main(String args[]) {
/*
        User u = new User(0, "test", "test", "test@mail.com", "test", "asdsad", "baku", null, null, null);
        u.setBirthplace(new Country(1, "", ""));
        u.setNationality(new Country(1, "", ""));
        u.setPassword("12345");

        UserServiceInter userDao = Context.instanceUserDao();
        userDao.addUser(u);


        byte[] hashedPass = hashPassword("12345");
        String value = new String(hashedPass);
        System.out.println(value);

        BCrypt.Hasher crypt = BCrypt.withDefaults();

 */
        byte[] hashedPass = crypt.hash(7, "12345".toCharArray());
        String value = new String(hashedPass);
        System.out.println(value);

    }


}
