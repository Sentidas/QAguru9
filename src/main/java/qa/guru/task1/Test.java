package qa.guru.task1;

public class Test {

    public static void main(String[] args) {

        Student student1 = new Student("Alejandro Miguel Sanchez", 22, "Cuba", "programming");
        Student student2 = new Student("Bharath Thippireddy", 21, "India", "mathematics");

        student1.info();
        student1.skippClasses();

        student2.info();
        student2.study();
    }


}
