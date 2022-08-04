
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeesOperations {

    private Connection conn = null;
    private Statement statement = null;
    private PreparedStatement ps = null;
    public static String session;

    public EmployeesOperations() {
        String url = "jdbc:mysql://" + Database.host + ":" + Database.port + "/" + Database.dbName + "?useUnicode=true&characterEncoding=utf8&autoReconnect=true&useSSL=false";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, Database.userName, Database.password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Verilənlər bazası ilə əlaqə yaradıla bilmədi.");
        }
    }

    public boolean login(String userName, String password) {
        String loginQuery = "Select * From admin Where userName = ? and password = ?";
        try {
            ps = conn.prepareStatement(loginQuery);
            ps.setString(1, userName);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                session = userName;
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("SQLException");
        }
        return false;
    }

    public ArrayList<Employee> getEmployees() {
        ArrayList<Employee> result = new ArrayList<>();
        try {
            statement = conn.createStatement();
            String query = "Select * From employees";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String department = rs.getString("department");
                float salary = rs.getInt("salary");
                result.add(new Employee(id, name, surname, department, salary));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeesOperations.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public void addEmployee(String name, String surname, String department, float salary) {
        String query = "Insert Into employees (name, surname, department, salary) Values (?, ?, ?, ?)";

        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, surname);
            ps.setString(3, department);
            ps.setFloat(4, salary);

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeesOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateEmployee(int id, String name, String surname, String department, float salary) {
        String query = "Update employees Set name = ?, surname = ?, department = ?, salary = ? Where id = ?";

        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, surname);
            ps.setString(3, department);
            ps.setFloat(4, salary);
            ps.setInt(5, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeesOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteEmployee(int id) {
        String query = "Delete from employees Where id = ?";

        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQLException");
        }
    }
}
