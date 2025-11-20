package com.example.main;

import com.example.dao.StudentDAO;
import com.example.entity.Student;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        // 1️⃣ CREATE
        Student s1 = new Student(101, "Ravi", "Hyderabad");
        Student s2 = new Student(102, "Priya", "Chennai");
        dao.saveStudent(s1);
        dao.saveStudent(s2);

        // 2️⃣ READ (Single)
        dao.getStudentById(101);

        // 3️⃣ READ (All)
        List<Student> list = dao.getAllStudents();
        System.out.println("📋 All Students:");
        for (Student s : list) {
            System.out.println(s);
        }

        // 4️⃣ UPDATE
        Student sUpdate = dao.getStudentById(101);
        sUpdate.setCity("Bangalore");
        dao.updateStudent(sUpdate);

        // 5️⃣ DELETE
        dao.deleteStudent(102);
    }
}
