package employeemanager.models.implementation;

import employeemanager.models.Employee;
import employeemanager.models.Position;

/**
 *
 * @author sscerbatiuc
 */
public class Programmer extends Employee {

    public Programmer(String name, String surname) {
        super(name, surname, Position.Programmer);
    }

}
