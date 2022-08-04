
public class InputSecurity {

    public static void checkSession() {
        if (EmployeesOperations.session == null) {
            System.exit(0);
        }
    }
}
