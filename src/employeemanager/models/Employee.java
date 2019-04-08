package employeemanager.models;

/**
 *
 * @author sscerbatiuc
 */
public class Employee {

    private Integer id;
    private String name;
    private String surname;
    protected Position position;

    public Employee() {
    }

    public Employee(String name, String surname, Position position) {
        this.name = name;
        this.surname = surname;
        this.position = position;
    }

    public Employee(Integer id, String name, String surname, Position position) {
        this(name, surname, position);
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Position getPosition() {
        return position;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isValid() {
        return !this.name.isEmpty();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", position=" + position + '}';
    }
    
}
