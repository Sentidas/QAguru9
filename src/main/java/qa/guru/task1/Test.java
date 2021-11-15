package qa.guru.task1;

public class Test {

    public static void main(String[] args) {

        EducationOrganization educationOrganization = new EducationOrganization("University of Pennsylvania","Philadelphia");
        educationOrganization.printInfo();
        System.out.println("The best university is " + educationOrganization.getNameOrganization());
        EducationOrganization.printInfoOfEducation();

        Student.IdCardStudent idCardStudent1 = new Student.IdCardStudent("IT", 3);
        Student student1 = new Student("Alejandro Miguel Sanchez", idCardStudent1);
        Student.IdCardStudent idCardStudent2 = new Student.IdCardStudent("MUSIC", 2);
        Student student2 = new Student("Bharath Thippireddy", idCardStudent2 );
        student1.printInfo();
        student1.skippClasses();
        student2.printInfo();
        student2.study();

        Professor professor = new Professor("Alexander Gol", 4);
        professor.teach("music");
        professor.sleepInClass();
        professor.printInfo();
        System.out.println("The best professor is " + professor.getFullNameProfessor());

    }
}
