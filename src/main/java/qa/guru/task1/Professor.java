package qa.guru.task1;

public class Professor {

    private String fullNameProfessor;
    private int course;

    public Professor(String fullNameProfessor, int course) {
        this.fullNameProfessor = fullNameProfessor;
        this.course = course;
    }

    public String getFullNameProfessor() {
        return fullNameProfessor;
    }


    void teach(String subject){
        System.out.println("I'm a professor. I teach " + subject);
    }

    void printInfo() {
        System.out.println("I'm a professor. Mi mane is " + fullNameProfessor + " .I teach on " + course + " course");
    }

    public void sleepInClass() {
        System.out.println("I'm a professor. I'm sleeping in my class");
    }

//        public void setFullNameProfessor(String fullNameProfessor) {
//        this.fullNameProfessor = fullNameProfessor;
//    }
//
//    public int getCourse() {
//        return course;
//    }
//
//    public void setCourse(int course) {
//        this.course = course;
//    }

}
