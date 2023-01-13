package com.example.spellbeecomptetion;

/**
 * Author  : Indra
 **/

public class Student {
    int id;
    String name;
    String rollNumber;
    int engMarkPerc;
    String classIn;

    public Student(String name, String rollNumber, int attendancePercent, String gender) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.engMarkPerc = attendancePercent;
        this.classIn = gender;
    }

    public Student(int id, String name, String rollNumber, int attendancePercent, String gender) {
        this.id = id;
        this.name = name;
        this.rollNumber = rollNumber;
        this.engMarkPerc = attendancePercent;
        this.classIn = gender;
    }

    public Student() {
    }
}
