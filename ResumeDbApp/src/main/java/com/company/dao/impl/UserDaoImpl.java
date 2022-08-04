package com.company.dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.dao.inter.UserSkillDaoInter;
import com.company.entity.Country;
import com.company.entity.Skill;
import com.company.entity.User;
import com.company.entity.UserSkill;
import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserDaoInter;
import com.company.main.Context;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        try (Connection c = connect()) {
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
        List<User> result = new ArrayList<>();
        try (Connection c = connect()) {
            String sql = "SELECT "
                    + "u.*, "
                    + "n.nationality, "
                    + "c.name birthplace "
                    + "FROM "
                    + "USER u "
                    + "LEFT JOIN country n ON u.nationality_id = n.id "
                    + "LEFT JOIN country c ON u.birthplace_id = c.id "
                    + "where 1=1 ";

            if (name != null && !name.trim().isEmpty()) {
                sql += "and u.name=? ";
            }

            if (surname != null && !surname.trim().isEmpty()) {
                sql += "and u.surname=? ";
            }

            if (nationalityId != null) {
                sql += "and u.nationality_id=? ";
            }

            PreparedStatement stmt = c.prepareStatement(sql);

            int i = 1;
            if (name != null && !name.trim().isEmpty()) {
                stmt.setString(i, name);
                i++;
            }

            if (surname != null && !surname.trim().isEmpty()) {
                stmt.setString(i, surname);
                i++;
            }

            if (nationalityId != null) {
                stmt.setInt(i, nationalityId);
            }

            stmt.execute();
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
    public User findByEmailAndPassword(String email, String password) {
        User result = null;
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select * from user where email=? and password=?");
            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) {
                return null;
            }

            result = getUserSimple(rs);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public User findByEmail(String email) {
        User result = null;
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select * from user where email=?");
            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) {
                return null;
            }

            result = getUserSimple(rs);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public User getById(int userId) {
        User result = null;
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("SELECT "
                    + "u.*, "
                    + "n.nationality, "
                    + "c.name birthplace "
                    + "FROM "
                    + "USER u "
                    + "LEFT JOIN country n ON u.nationality_id = n.id "
                    + "LEFT JOIN country c ON u.birthplace_id = c.id where u.id=" + userId);
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                result = getUser(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean addUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into "
                    + "user(name, surname, email, password, phone, profile_description, adress, birthdate, birthplace_id, nationality_id) "
                    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, crypt.hashToString(7, u.getPassword().toCharArray()));
            stmt.setString(5, u.getPhone());
            stmt.setString(6, u.getProfileDesc());
            stmt.setString(7, u.getAdress());
            stmt.setDate(8, u.getBirthdate());
            stmt.setInt(9, u.getBirthplace().getId());
            stmt.setInt(10, u.getNationality().getId());

            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update user set name=?, surname=?, email=?, phone=?, profile_description=?, "
                    + "adress=?, birthdate=?, birthplace_id=?, nationality_id=? where id= ?");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getPhone());
            stmt.setString(5, u.getProfileDesc());
            stmt.setString(6, u.getAdress());
            stmt.setDate(7, u.getBirthdate());
            stmt.setInt(8, u.getBirthplace().getId());
            stmt.setInt(9, u.getNationality().getId());
            stmt.setInt(10, u.getId());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(int id) {
        try (Connection c = connect();) {
            Statement stmt = c.createStatement();

            UserSkillDaoInter userSkillDao = Context.instanceUserSkillDao();
            EmploymentHistoryDaoInter employmentHistoryDao = Context.instanceEmploymentHistoryDao();

            userSkillDao.remove(id);
            employmentHistoryDao.remove(id);

            return stmt.execute("delete from user where id=" + id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) {
        List<UserSkill> result = new ArrayList<>();
        try (Connection c = connect()) {
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
        User u = new User(0, "test", "test", "test@mail.com", "test", "asdsad", "baku", null, null, null);
        u.setBirthplace(new Country(1, "", ""));
        u.setNationality(new Country(1, "", ""));
        u.setPassword("12345");
        UserDaoInter userDao = Context.instanceUserDao();
        userDao.addUser(u);
    }
}
