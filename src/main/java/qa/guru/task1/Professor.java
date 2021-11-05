package qa.guru.task1;

public class Professor {
    String fullNameProfessor;
    String countryOfProfessor;
    int degreeOfProfessor;
    int course;


    void teach(String course){
        System.out.println("I'm a professor of . I teach of" + course);
    }

    void info(String fullNameStudent, String countryStudent, String courseStudent) {
        System.out.println("I'm a professor. Mi mane is + " + fullNameProfessor + ", from " +  countryOfProfessor + ".I teach: " + course);
    }

    public void sleepInClass() {
        System.out.println("I'm a professor. I'm sleeping in my class");
    }

    public int getDegree() {
        return degreeOfProfessor;
    }
}
