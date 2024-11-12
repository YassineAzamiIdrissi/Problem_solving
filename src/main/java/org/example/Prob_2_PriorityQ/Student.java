package org.example.Prob_2_PriorityQ;

public class Student {
    private int id;
    private String name;
    private double cpga;

    public Student(int id, String name, double cpga) {
        this.id = id;
        this.name = name;
        this.cpga = cpga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCpga() {
        return cpga;
    }

    public void setCpga(double cpga) {
        this.cpga = cpga;
    }
}
