package employeemanager.models.implementation;

import employeemanager.models.Employee;
import employeemanager.models.Position;

/**
 *
 * @author sscerbatiuc
 */
public class Accountant extends Employee {

    public Accountant(String name, String surname) {
        super(name, surname, Position.Accountant);
    }

}
