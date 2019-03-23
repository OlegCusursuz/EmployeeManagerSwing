package employeemanager.models.implementation;

import employeemanager.models.Employee;
import employeemanager.models.Position;

/**
 *
 * @author sscerbatiuc
 */
public class HRManager extends Employee{

    public HRManager(String name, String surname) {
        super(name, surname, Position.HRManager);
    }
    
    
}
