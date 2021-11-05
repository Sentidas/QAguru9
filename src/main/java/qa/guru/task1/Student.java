package qa.guru.task1;

import java.util.SplittableRandom;

public class Student {
    String fullNameStudent;
    int ageStudent;
    String countryStudent;
    int gradeStudent;
    String course;

    public Student(String fullNameStudent, int ageStudent, String countryStudent, String course){
        this.fullNameStudent = fullNameStudent;
        this.ageStudent = ageStudent;
        this.countryStudent = countryStudent;
        this.course = course;
    }

    public void study(){
        System.out.println("I'm a student. I'm studying.");
    }

    public void info() {
        System.out.println("I'm a student. My mane is " + fullNameStudent + ", from " + countryStudent + ".I like to study: " + course);
    }

    public void skippClasses() {
        System.out.println("I'm a student. I'm skipping my classes.");
    }

    public int getGrade() {
        return gradeStudent;
    }

    public void graduateOfEducationOrganization(){
        System.out.println("I'm a student. I graduated from my Education Organization");
    }





}
