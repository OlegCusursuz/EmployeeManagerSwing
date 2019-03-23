package employeemanager.service;

import employeemanager.models.Employee;
import java.util.ArrayList;

/**
 *
 * @author sscerbatiuc
 */
public class EmployeeService {

    private static final ArrayList<Employee> EMPLOYEE_LIST = new ArrayList<>();

    public static ArrayList<Employee> getEmployeesList() {
        return EMPLOYEE_LIST;
    }
}
