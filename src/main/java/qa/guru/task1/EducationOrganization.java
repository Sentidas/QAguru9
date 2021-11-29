package qa.guru.task1;

public class EducationOrganization {

    private String nameOrganization;
    private String countryOfOrganization;

    public EducationOrganization(String nameOrganization, String countryOfOrganization) {
        this.nameOrganization = nameOrganization;
        this.countryOfOrganization = countryOfOrganization;
    }

    public String getNameOrganization() {
        return nameOrganization;
    }

    public void printInfo() {
        System.out.println("It's " + nameOrganization + " and it location in " +countryOfOrganization);
    }

    public static void printInfoOfEducation() {
        System.out.println("Education it's very important");
    }

//        public void setNameOrganization(String nameOrganization) {
//        this.nameOrganization = nameOrganization;
//    }
//
//    public String getCountryOfOrganization() {
//        return countryOfOrganization;
//    }
//
//    public void setCountryOfOrganization(String countryOfOrganization) {
//        this.countryOfOrganization = countryOfOrganization;
//    }

}

