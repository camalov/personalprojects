package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.SkillDaoInter;
import com.company.entity.Skill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter {

    private Skill getSkill(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");

        return new Skill(id, name);
    }

    @Override
    public List<Skill> getAll() {
        List<Skill> result = new ArrayList<>();
        try ( Connection c = connect()) {
            Statement statement = c.createStatement();
            statement.execute("select * from skill");
            ResultSet rs = statement.getResultSet();

            while (rs.next()) {
                result.add(getSkill(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<Skill> getByName(String name) {
        List<Skill> result = new ArrayList<>();

        try ( Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select * from skill where name=?");
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                result.add(getSkill(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SkillDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SkillDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    @Override
    public int addSkill(Skill skill) {
        int result = -1;

        if (getByName(skill.getName()).size() > 0) {
            return result;
        }

        try ( Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into skill(name) values(?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, skill.getName());
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
    public boolean updateSkill(Skill skill) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
