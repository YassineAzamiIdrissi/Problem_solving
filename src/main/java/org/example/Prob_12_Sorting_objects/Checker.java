package org.example.Prob_12_Sorting_objects;

import java.util.Comparator;

public class Checker implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        int cgpa_comp = Double.compare(s2.getCgpa(), s1.getCgpa());
        if (cgpa_comp != 0) return cgpa_comp;
        int firstName_comp = s1.getFname().compareTo(s2.getFname());
        if (firstName_comp != 0) return firstName_comp;

        return Integer.compare(s1.getId(), s2.getId());
    }
}
