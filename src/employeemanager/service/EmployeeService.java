package employeemanager.service;

import employeemanager.models.Employee;
import employeemanager.models.Position;
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

    public static Employee getById(Integer id) {
        for (Employee emp : EMPLOYEE_LIST) {
            if (emp.getId().equals(id)) {
                return emp;
            }
        }
        return null;
    }

    public static void edit(Integer employeeId, String newName, String newSurname, String newPosition) {
        int index;
        for(index = 0; index < EMPLOYEE_LIST.size(); index++ ){
            if(employeeId.equals(EMPLOYEE_LIST.get(index).getId())){
                break;
            }
        }
        EMPLOYEE_LIST.get(index).setName(newName);
        EMPLOYEE_LIST.get(index).setSurname(newSurname);
    }

    private void printBtnActionPerformed(java.awt.event.ActionEvent evt) {
        for (Employee emp : EMPLOYEE_LIST) {
            System.out.println(emp);
        }
    }
}
