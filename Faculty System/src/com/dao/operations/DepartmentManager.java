package com.dao.operations;

import com.dao.objects.Department;
import com.operations.mysql.MySQLConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DepartmentManager extends MySQLConnection {

    PreparedStatement preparedStatement = null;
    Statement statement = null;

    public ArrayList<Department> getDepartments() {
        getConnect();
        String executeQuery = "Select * From department";
        ArrayList<Department> departmentList = new ArrayList<>();
        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(executeQuery);

            while (resultSet.next()) {
                int id = resultSet.getInt("departmentID");
                String name = resultSet.getString("departmentName");
                int teacherCount = resultSet.getInt("teacherCount");
                int groupCount = resultSet.getInt("groupCount");
                int studentCount = resultSet.getInt("studentCount");
                int subjectCount = resultSet.getInt("subjectCount");
                departmentList.add(new Department(id, name, teacherCount, groupCount, studentCount, subjectCount));
            }

        } catch (SQLException ex) {
            System.out.println("Əməliyyatın icrası zamanı xəta baş verdi.");
            ex.printStackTrace();
        } finally {
            // disconnect();
        }

        return departmentList;
    }

    public boolean addDepartment(String departmentName) {
        getConnect();
        String updateQuery
                = "Insert Into department (departmentName) Values (?)";
        try {
            preparedStatement = conn.prepareStatement(updateQuery);
            preparedStatement.setString(1, departmentName);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Əlavə edilə bilmədi.");
        } finally {
            disconnect();
        }
        return false;
    }

    public boolean updateDepartment(int departmentID, String departmentName) {
        getConnect();
        String updateQuery = "Update department Set departmentName = ? Where departmentID = ?";

        try {
            preparedStatement = conn.prepareStatement(updateQuery);
            preparedStatement.setString(1, departmentName);
            preparedStatement.setInt(2, departmentID);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Kafedra haqqında məlumatlar yenilənərkən xəta baş verdi.");
        } finally {
            disconnect();
        }
        return false;
    }

    public boolean deleteDepartment(int deletedDepartmentID) {
        getConnect();
        String deleteQuery = "Delete From department Where departmentID = ?";
        try {
            preparedStatement = conn.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, deletedDepartmentID);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Silinmə zamanı xəta.");
        } finally {
            disconnect();
        }
        return false;
    }

    @Override
    public void disconnect() {
        try {
            conn.setAutoCommit(false);
            conn.rollback();
            conn.close();
            if (statement != null) {
                statement.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException ex) {
            System.out.println("Bağlantının dayandırılması zamanı xəta : SQLException");
        } catch (NullPointerException ex) {
            System.out.println("Bağlantının dayandırılması zamanı xəta : NullPointerxception");
        }
    }
}
