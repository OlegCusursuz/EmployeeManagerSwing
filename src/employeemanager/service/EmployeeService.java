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

    public static void edit(Integer employeeId, String newName, String newSurname, String newPosition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void printBtnActionPerformed(java.awt.event.ActionEvent evt) {                                         
        for(Employee emp: EMPLOYEE_LIST){
            System.out.println(emp);
        }
    }
}
