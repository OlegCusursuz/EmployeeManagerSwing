package employeemanager.models.implementation;

import employeemanager.models.Employee;
import employeemanager.models.Position;

/**
 *
 * @author sscerbatiuc
 */
public class Cleaner extends Employee {

    public Cleaner(String name, String surname) {
        super(name, surname, Position.Cleaner);
    }

}
