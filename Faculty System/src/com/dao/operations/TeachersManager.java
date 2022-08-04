package com.dao.operations;

import com.dao.objects.Teacher;
import com.operations.mysql.MySQLConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TeachersManager extends MySQLConnection {

    PreparedStatement preparedStatement = null;
    Statement statement = null;

    public ArrayList<Teacher> getTeachers() {
        getConnect();
        String executeQuery = "Select * From teachers";
        ArrayList<Teacher> teachers = new ArrayList<>();

        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(executeQuery);

            while (resultSet.next()) {
                int id = resultSet.getInt("teacherID");
                String photoUrl = resultSet.getString("teacherPhoto");
                String teacherName = resultSet.getString("teacherName");
                String teacherSurname = resultSet.getString("teacherSurname");
                String date = resultSet.getString("teacherBirthDate");
                String teacherGraduateWT = resultSet.getString("teacherGraduateWT");
                int gender = resultSet.getInt("gender");
                String languages = resultSet.getString("languages");
                String scientificName = resultSet.getString("scientificName");
                String academicDegree = resultSet.getString("academicDegree");
                String department = resultSet.getString("department");
                String articleLocal = resultSet.getString("articleLocal");
                String articleOverseas = resultSet.getString("articleOverseas");
                String tezis = resultSet.getString("tezis");
                String foreignCountries = resultSet.getString("foreignCountries");
                teachers.add(new Teacher(
                        id,
                        photoUrl,
                        teacherName,
                        teacherSurname,
                        date,
                        teacherGraduateWT,
                        gender,
                        languages,
                        scientificName,
                        academicDegree,
                        department,
                        articleLocal,
                        articleOverseas,
                        tezis,
                        foreignCountries
                ));
            }

        } catch (SQLException ex) {
            System.out.println("Məlumatların oxunulması zamanı xəta");
            ex.printStackTrace();
        } finally {
            disconnect();
        }
        return teachers;
    }

    public boolean addTeacher(
            String imgURL,
            String name,
            String surname,
            String birthDate,
            String GraduateWT,
            int gender,
            ArrayList<String> languages,
            String academicDegree,
            String scientificName,
            String department,
            String loacalArticle,
            String overseasArticle,
            String tezis,
            String foreignCountries
    ) {
        getConnect();
        String insertQuery = "Insert Into teachers "
                + "(teacherPhoto, "
                + "teacherName, "
                + "teacherSurname, "
                + "teacherBirthDate, "
                + "teacherGraduateWT, "
                + "gender, "
                + "languages, "
                + "academicDegree, "
                + "scientificName, "
                + "department, "
                + "articleLocal, "
                + "articleOverseas, "
                + "tezis, "
                + "foreignCountries) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            String languagesString = String.valueOf(languages);

            preparedStatement = conn.prepareStatement(insertQuery);
            preparedStatement.setString(1, imgURL);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, surname);
            preparedStatement.setString(4, birthDate);
            preparedStatement.setString(5, GraduateWT);
            preparedStatement.setInt(6, gender);
            preparedStatement.setString(7, languagesString);
            preparedStatement.setString(8, academicDegree);
            preparedStatement.setString(9, scientificName);
            preparedStatement.setString(10, department);
            preparedStatement.setString(11, loacalArticle);
            preparedStatement.setString(12, overseasArticle);
            preparedStatement.setString(13, tezis);
            preparedStatement.setString(14, foreignCountries);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Müəllim haqqında məlumatların yazılmsı zamanı xəta.");
            ex.printStackTrace();
        } finally {
            disconnect();
        }
        return false;
    }

    public boolean updateTeacher(
            int id,
            String imgURL,
            String name,
            String surname,
            String birthDate,
            String GraduateWT,
            int gender,
            ArrayList<String> languages,
            String academicDegree,
            String scientificName,
            String department,
            String localArticle,
            String overseasArticle,
            String tezis,
            String foreignCountries
    ) {
        getConnect();

        String updateQuery = "Update teachers Set "
                + "teacherPhoto = ?, "
                + "teacherName = ?, "
                + "teacherSurname = ?, "
                + "teacherBirthDate = ?, "
                + "teacherGraduateWT = ?, "
                + "gender = ?, "
                + "languages = ?, "
                + "academicDegree = ?, "
                + "scientificName = ?, "
                + "department = ?, "
                + "articleLocal = ?, "
                + "articleOverseas = ?, "
                + "tezis = ?, "
                + "foreignCountries = ? "
                + "Where teacherID = ?";

        try {
            String languagesString = String.valueOf(languages);
            System.out.println(
id + "\n"
            );

            preparedStatement = conn.prepareStatement(updateQuery);
            preparedStatement.setString(1, imgURL);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, surname);
            preparedStatement.setString(4, birthDate);
            preparedStatement.setString(5, GraduateWT);
            preparedStatement.setInt(6, gender);
            preparedStatement.setString(7, languagesString);
            preparedStatement.setString(8, academicDegree);
            preparedStatement.setString(9, scientificName);
            preparedStatement.setString(10, department);
            preparedStatement.setString(11, localArticle);
            preparedStatement.setString(12, overseasArticle);
            preparedStatement.setString(13, tezis);
            preparedStatement.setString(14, foreignCountries);
            preparedStatement.setInt(15, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TeachersManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return false;
    }

    public boolean deleteTeacher(ArrayList<Integer> selectedRows) {
        getConnect();
        String deleteQuery = "Delete from teachers Where teacherID = ?";

        try {
            preparedStatement = conn.prepareStatement(deleteQuery);
            for (int teacherID : selectedRows) {
                preparedStatement.setInt(1, teacherID);
                preparedStatement.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
            System.out.println("Müəllim silinərkən xəta baş verdi.");
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
