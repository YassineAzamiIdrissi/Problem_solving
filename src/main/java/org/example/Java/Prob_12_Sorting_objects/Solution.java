package org.example.Java.Prob_12_Sorting_objects;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<>();
        Checker checker = new Checker();
        while (testCases > 0) {
            System.out.println("Define student :: ");
            System.out.println("ID : ");
            int id = in.nextInt();
            System.out.println("First name : ");
            String fname = in.next();
            System.out.println("Cgpa : ");
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }
        studentList.sort(checker);
        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}
