package employeemanager.service;

import employeemanager.models.Employee;
import employeemanager.models.Position;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sscerbatiuc
 */
public class DBDemo {

    public static void main(String[] args) throws SQLException {
        EmployeeDao empDao = new EmployeeDao();
        ArrayList<Employee> allEmps = empDao.getAll();
        System.out.println(allEmps);
        // Insert
        Employee ionMocanuEmp = new Employee("Ion", "Mocanu", Position.Programmer);
        // System.out.print(String.format("Adding 1 employee: affected %d", empDao.add(new Employee(/* add here new data */))));

        // Update
        Employee editedEmp = allEmps.get(0);
        editedEmp.setName("new name");
        empDao.edit(editedEmp);

        // Delete
        // System.out.print(String.format("Adding 1 employee: affected %d", empDao.add(new Employee(/* add here new data */))));
        System.out.println(String.format("Removed %s employee: %d rows", editedEmp, empDao.remove(editedEmp)));
    }
}
