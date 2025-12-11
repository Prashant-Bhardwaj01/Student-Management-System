package com.devops.studentmgmt.repository;

import com.devops.studentmgmt.model.Student;
import com.devops.studentmgmt.util.DBConnection;

import java.sql.*;
import java.util.*;

public class StudentRepository {

    public Student save(Student student) {
        String sql = "INSERT INTO students VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, student.getId());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getAge());
            ps.executeUpdate();
            return student;

        } catch (Exception e) { throw new RuntimeException(e); }
    }

    public Student findById(String id) {
        String sql = "SELECT * FROM students WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                return new Student(rs.getString("id"), rs.getString("name"), rs.getInt("age"));
            return null;

        } catch (Exception e) { throw new RuntimeException(e); }
    }

    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next())
                list.add(new Student(rs.getString("id"), rs.getString("name"), rs.getInt("age")));
            return list;

        } catch (Exception e) { throw new RuntimeException(e); }
    }

    public void deleteById(String id) {
        String sql = "DELETE FROM students WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            ps.executeUpdate();

        } catch (Exception e) { throw new RuntimeException(e); }
    }

    public void updateStudent(String id, String name, int age) {
    String sql = "UPDATE students SET name=?, age=? WHERE id=?";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setString(3, id);
        ps.executeUpdate();

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

}