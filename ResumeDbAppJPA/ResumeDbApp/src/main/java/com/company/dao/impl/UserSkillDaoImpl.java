package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserSkillDaoInter;
import com.company.entity.Skill;
import com.company.entity.User;
import com.company.entity.UserSkill;
import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserSkillDaoImpl extends AbstractDAO implements UserSkillDaoInter {

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
        int id = rs.getInt("user_skill_id");
        int userId = rs.getInt("id");
        int skillId = rs.getInt("skill_id");
        String skillName = rs.getString("skill_name");
        int power = rs.getInt("power");

        return new UserSkill(id, new User(userId), new Skill(skillId, skillName), power);
    }

    @Override
    public List<UserSkill> getUserSkillById(int userId, int skillId) {
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
                    + "us.skill_id=? and us.user_id=?");
            stmt.setInt(1, skillId);
            stmt.setInt(2, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                result.add(getUserSkill(rs));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public int addUserSkill(UserSkill userSkill) {
        int result = -1;
        int count = getUserSkillById(userSkill.getUser().getId(), userSkill.getSkill().getId()).size();

        if (count > 0) {
            return result;
        }

        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into user_skill(user_id, skill_id, power) values(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, userSkill.getUser().getId());
            stmt.setInt(2, userSkill.getSkill().getId());
            stmt.setInt(3, userSkill.getPower());
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();

            while (rs.next()) {
                result = (int) rs.getInt(1);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateUserSkill(UserSkill userSkill) {
        boolean result = true;

        int count = getUserSkillById(userSkill.getUser().getId(), userSkill.getSkill().getId()).size();

        if (count > 0) {
            return false;
        }

        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update user_skill set skill_id=?, power=? where id=?");

            stmt.setInt(1, userSkill.getSkill().getId());
            stmt.setInt(2, userSkill.getPower());
            stmt.setInt(3, userSkill.getId());

            stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return result;
    }

    @Override
    public boolean remove(int userId) {
        boolean result = false;

        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("delete from user_skill where user_id in(?)");

            stmt.setInt(1, userId);
            result = stmt.execute();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean removeSelectedItems(int[] userSkillsId) {
        boolean result = false;
        int[] selectedUserSkillsId = userSkillsId;

        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("delete from user_skill where id in(?)");

            for (int i = 0; i < selectedUserSkillsId.length; i++) {
                stmt.setInt(1, selectedUserSkillsId[i]);
                result = stmt.execute();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
