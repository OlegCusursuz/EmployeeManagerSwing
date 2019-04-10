package employeemanager.service;

import employeemanager.models.Employee;
import employeemanager.models.Position;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author sscerbatiuc
 */
public class EmployeeDao {

    private static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/emp_manager";
    private static final String DB_USER = "postgres";
    private static final String DB_PASS = "postgres";

    public EmployeeDao() {
    }

    private Connection connect() throws SQLException {
        System.out.println("Connected to postgresql server successfully.");
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }

    public ArrayList<Employee> getAll() {
        String sql = "SELECT id, name, surname, position FROM app.Employee";
        try (Connection conn = connect();
                Statement dbStatement = conn.createStatement();
                ResultSet rs = dbStatement.executeQuery(sql)) {
            ArrayList empList = new ArrayList<Employee>();
            while (rs.next()) {
                Employee emp = new Employee(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        Position.getByPositionName(rs.getString("position")));
                empList.add(emp);
            }
            return empList;
        } catch (SQLException ex) {
            System.err.println("Caught an error trying to get all the employees");
        }
        return null;
    }

    public int add(Employee emp) {
        String insertSql = "INSERT INTO app.employee(name,surname,position) VALUES (?,?,?)";
        // = "INSERT INTO app.employee(name,surname,position) VALUES ('Ion','Mocanu','Programmer')";
        try (Connection conn = connect();
                PreparedStatement dbStatement = conn.prepareStatement(insertSql)) {

            dbStatement.setString(1, emp.getName());
            dbStatement.setString(2, emp.getSurname());
            dbStatement.setString(3, emp.getPosition().getName());

            int affectedRows = dbStatement.executeUpdate();
            System.out.println(String.format("Executed insert statement. Affected %d rows", affectedRows));
            return affectedRows;
        } catch (SQLException ex) {
            System.err.println("Caught an error trying to insert the employee");
        }
        return -1;
    }

    public int add(ArrayList<Employee> empList) throws SQLException {
        String insertSql = "INSERT INTO app.employee(name,surname,position) VALUES (?,?,?)";
        try (Connection conn = connect();
                PreparedStatement dbStatement = conn.prepareStatement(insertSql)) {

            for (Employee emp : empList) {
                dbStatement.setString(1, emp.getName());
                dbStatement.setString(2, emp.getSurname());
                dbStatement.setString(3, emp.getPosition().getName());
                dbStatement.addBatch();
            }

            int affectedRows = dbStatement.executeUpdate();
            System.out.println(String.format("Executed insert statement. Affected %d rows", affectedRows));
            return affectedRows;
        } catch (SQLException ex) {
            System.err.println("Caught an error trying to insert the employees");
            throw ex;
        }
    }

    public int edit(Employee emp) throws SQLException {
        String updateSql = "UPDATE app.employee SET name=?, surname=?, position=? WHERE id=?";
        try (Connection conn = connect();
                PreparedStatement dbStatement = conn.prepareStatement(updateSql)) {

            dbStatement.setString(1, emp.getName());
            dbStatement.setString(2, emp.getSurname());
            dbStatement.setString(3, emp.getPosition().getName());
            dbStatement.setInt(4, emp.getId());

            int affectedRows = dbStatement.executeUpdate();
            System.out.println(String.format("Executed insert statement. Affected %d rows", affectedRows));
            return affectedRows;
        } catch (SQLException ex) {
            System.err.println("Caught an error trying to insert the employees");
            throw ex;
        }
    }
    
    public Employee getEmployee(String name, String surname, String position){
        String sql = "SELECT id, name, surname, position FROM app.employee "
                + "WHERE name=? AND surname=? AND position=?";
        try(Connection conn = connect(); PreparedStatement prepStmt = conn.prepareStatement(sql)){
            prepStmt.setString(1, name);
            prepStmt.setString(2, surname);
            prepStmt.setString(3, position);
            ResultSet rs = prepStmt.executeQuery();
            Employee emp = null;
            while(rs.next()){
                emp = new Employee(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"), 
                        Position.getByPositionName(rs.getString("position")));
            }
            return emp;
        } catch (SQLException ex){
            System.err.println("Error trying to get one employee");
        }
        return null;
    }

    public int remove(Employee emp) throws SQLException {
        String updateSql = "DELETE FROM app.employee WHERE id=?";
        try (Connection conn = connect();
                PreparedStatement dbStatement = conn.prepareStatement(updateSql)) {

            dbStatement.setInt(1, emp.getId());
            int affectedRows = dbStatement.executeUpdate();
            System.out.println(String.format("Executed delete statement. Affected %d rows", affectedRows));
            return affectedRows;
        } catch (SQLException ex) {
            System.err.println("Caught an error trying to delete the employee");
            throw ex;
        }
    }

}
