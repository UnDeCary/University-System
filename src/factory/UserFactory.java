package factory;

public class UserFactory {
    public static User createUser(String type){
        switch (type.toUpperCase()){
            case "TEACHER":
                return new Teacher();
            case "STUDENT":
                return new Student();
            case "ADMIN":
                return new Admin();
            case "MANAGER":
                return new Manager();
            case "GRADUATE":
                return new GraduateStudent();
            case "TECH_SUPPORT":
                return new TechSupportSpecialist();
            default:
                throw new IllegalArgumentException("Unknown user type: " + type);
        }
    }
}
