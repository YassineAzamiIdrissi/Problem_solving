package org.example.Java.Prob_2_PriorityQ;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Priorities {
    PriorityQueue<Student> queue = new PriorityQueue<>
            ((s1, s2) -> {
                int cgpa_comparison = Double.compare(
                        s2.getCpga(), s1.getCpga()
                );
                int id_comparison = Integer.compare(
                        s1.getId(), s2.getId()
                );
                int name_comparison = s1.getName().
                        compareTo(s2.getName());

                if (cgpa_comparison != 0) {
                    System.out.println("BY cgpa");
                    return cgpa_comparison;
                }
                if (name_comparison != 0) {
                    System.out.println("BY name");
                    return name_comparison;
                }

                System.out.println("id name");
                return id_comparison;
            }
            );

    public ArrayList<Student> getStudents(List<String> events) {
        for (var event : events) {
            if (event.contains("ENTER ")) {
                String[] parts = event.split(" ");
                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);
                Student student = new Student(id, name, cgpa);
                queue.add(student);
            } else if (event.equals("SERVED")) {
                queue.poll();
            }
        }
        ArrayList<Student> students = new ArrayList<>();
        while (!queue.isEmpty()) {
            students.add(queue.poll());
        }
        return students;
    }

    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        System.out.println("Insert element :: :: :: ::");
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();
        int i = 1;
        while (totalEvents-- != 0) {
            System.out.println("element " + i);
            String event = scan.nextLine();
            events.add(event);
            ++i;
        }

        ArrayList<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}
