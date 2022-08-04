package com.company.dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.entity.Country;
import com.company.entity.Skill;
import com.company.entity.User;
import com.company.entity.UserSkill;
import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserDaoInter;
import com.company.main.Context;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UserDaoImpl extends AbstractDAO implements UserDaoInter {

    private static BCrypt.Hasher crypt = BCrypt.withDefaults();

    private User getUser(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        String profileDesc = rs.getString("profile_description");
        String adress = rs.getString("adress");
        Date birthdate = rs.getDate("birthdate");
        int nationalityId = rs.getInt("nationality_id");
        int birthplaceId = rs.getInt("birthplace_id");
        String nationalityStr = rs.getString("nationality");
        String birthplaceStr = rs.getString("birthplace");
        Country nationality = new Country(nationalityId, null, nationalityStr);
        Country birthplace = new Country(birthplaceId, birthplaceStr, null);

        return new User(id, name, surname, email, phone, profileDesc, adress, birthdate, nationality, birthplace);
    }

    private User getUserSimple(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String email = rs.getString("email");
        String password = rs.getString("password");
        String phone = rs.getString("phone");
        String profileDesc = rs.getString("profile_description");
        String adress = rs.getString("adress");
        Date birthdate = rs.getDate("birthdate");
        int nationalityId = rs.getInt("nationality_id");
        int birthplaceId = rs.getInt("birthplace_id");

        User user = new User(id, name, surname, email, phone, profileDesc, adress, birthdate, null, null);
        user.setPassword(password);

        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        try ( Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("SELECT "
                    + "u.*, "
                    + "n.nationality, "
                    + "c.name birthplace "
                    + "FROM "
                    + "USER u "
                    + "LEFT JOIN country n ON u.nationality_id = n.id "
                    + "LEFT JOIN country c ON u.birthplace_id = c.id");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                User u = getUser(rs);
                result.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public List<User> getAll(String name, String surname, Integer nationalityId) {
        EntityManager em = em();

        String jpql = "select u from User u where 1=1 ";

//        List<User> result = new ArrayList<>();

        /*
        String sql = "SELECT "
                + "u.*, "
                + "n.nationality, "
                + "c.name birthplace "
                + "FROM "
                + "USER u "
                + "LEFT JOIN country n ON u.nationality_id = n.id "
                + "LEFT JOIN country c ON u.birthplace_id = c.id "
                + "where 1=1 ";
         */
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

        em.close();

        return users;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        EntityManager em = em();

        Query query = em.createQuery("select u from User u where u.email= :email and u.password= :password", User.class);
        query.setParameter("email", email);
        query.setParameter("password", password);

        List<User> users = query.getResultList();

        em.close();

        if (users.size() == 1) {
            return users.get(0);
        }

        return null;
    }

    public User findByEmailAndPasswordWithCriteriBuilder(String email, String password) {
        EntityManager em = em();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> postRoot = query.from(User.class);
        CriteriaQuery<User> where = query.where(cb.equal(postRoot.get("email"), email), cb.equal(postRoot.get("password"), password));

        Query executingQuery = em.createQuery(query);

        List<User> users = executingQuery.getResultList();

        em.close();

        if (users.size() == 1) {
            return users.get(0);
        }

        return null;
    }

    //With JPQL
    @Override
    public User findByEmail(String email) {
        EntityManager em = em();

        Query query = em.createQuery("select u from User u where u.email= :email", User.class);
        query.setParameter("email", email);

        List<User> users = query.getResultList();

        em.close();

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
        EntityManager em = em();

        User result = em.find(User.class, userId);

        em.close();

        return result;
    }

    @Override
    public boolean addUser(User u) {
        EntityManager em = em();

        u.setPassword(crypt.hashToString(7, u.getPassword().toCharArray()));

        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        em.close();

        return true;
    }

    @Override
    public boolean updateUser(User u) {
        EntityManager em = em();

        u.setPassword("12345");
        u.setPassword(crypt.hashToString(7, u.getPassword().toCharArray()));

        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();
        em.close();

        return true;
    }

    @Override
    public boolean remove(int id) {
        EntityManager em = em();

        User u = em.find(User.class, id);

        em.getTransaction().begin();
        em.remove(u);
        em.getTransaction().commit();
        em.close();

        return true;
    }

    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) {
        List<UserSkill> result = new ArrayList<>();
        try ( Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("SELECT "
                    + "u.*, "
                    + "us.id user_skill_id, "
                    + "us.skill_id, "
                    + "us.power, "
                    + "s.`name` skill_name "
                    + "FROM "
                    + "user_skill us "
                    + "LEFT JOIN USER u ON u.id = us.user_id "
                    + "LEFT JOIN skill s ON s.id = us.skill_id "
                    + "WHERE "
                    + "us.user_id=?");
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                UserSkill us = getUserSkill(rs);
                result.add(us);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    private UserSkill getUserSkill(ResultSet rs) throws SQLException {
        int userId = rs.getInt("id");
        int skillId = rs.getInt("skill_id");
        String skillName = rs.getString("skill_name");
        int power = rs.getInt("power");

        return new UserSkill(null, new User(userId), new Skill(skillId, skillName), power);
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

        UserDaoInter userDao = Context.instanceUserDao();
        userDao.addUser(u);
         */

        byte[] hashedPass = hashPassword("12345");
        String value = new String(hashedPass);
        System.out.println(value);

    }

}
