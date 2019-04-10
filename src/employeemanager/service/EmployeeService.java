package employeemanager.service;

import employeemanager.models.Employee;
import employeemanager.models.Position;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sscerbatiuc
 */
public class EmployeeService {

    private static EmployeeDao empDao = new EmployeeDao();

    public static Employee getById(Integer id) {
        return null;
    }

    public static void edit(Integer employeeId, String newName, String newSurname, String newPosition) {
    }

    public static void add(Employee emp) {
        empDao.add(emp);
    }

    public static ArrayList<Employee> getAll() {
        return empDao.getAll();
    }

    public static Employee getByParams(String... params) {
       return empDao.getEmployee(params[0], params[1], params[2]);
    }

    private void printBtnActionPerformed(java.awt.event.ActionEvent evt) {
    }
}
