package com.example.a88481.studentmanage.DAL;

import com.example.a88481.studentmanage.Model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 88481 on 2017/3/18 0018.
 */

public class StudentService {
    private static List<Student> students = new ArrayList<Student>();

    public static List<Student> getStudents(){
        return students;
    }

    public static void add(Student student){
        students.add(student);
    }

    public static void delete(int index){
        students.remove(index);
    }

    public static void delete(Student student){
        students.remove(student);
    }

    public static void update(int index,Student student){
        students.set(index,student);
    }
}
