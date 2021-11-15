package qa.guru.task1;

public class Student {
    static int countStudent=0;
    private String fullNameStudent;
    IdCardStudent idCardStudent;


    public Student(String fullNameStudent, IdCardStudent idCardStudent){
        this.fullNameStudent = fullNameStudent;
        this.idCardStudent = idCardStudent;
    }

    public String getFullNameStudent() {
        return fullNameStudent;
    }

    public void setFullNameStudent(String fullNameStudent) {
        this.fullNameStudent = fullNameStudent;
    }

    public void study(){
        System.out.println("I'm a student. I'm studying.");
    }

    public void printInfo() {
        countStudent++;
        System.out.println("I'm a student. My mane is " + fullNameStudent + ", my number is " + countStudent + ". I study " + idCardStudent.getCourse());
    }

    public void skippClasses() {
        System.out.println("I'm a student. I'm skipping my classes.");
    }

    public static class IdCardStudent{
        private String course;
        private int numberOfCourse;

        public IdCardStudent(String course, int numberOfCourse) {
            this.course = course;
            this.numberOfCourse = numberOfCourse;
        }

        public String getCourse() {
            return course;
        }

        public void setCourse(String course) {
            this.course = course;
        }

        public int getNumberOfCourse() {
            return numberOfCourse;
        }

        public void setNumberOfCourse(int numberOfCourse) {
            this.numberOfCourse = numberOfCourse;
        }
    }

}
