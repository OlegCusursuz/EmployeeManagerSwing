package employeemanager.models;

/**
 *
 * @author sscerbatiuc
 */
public enum Position {
    Programmer("Programmer"),
    Accountant("Accountant"),
    HRManager("HR Manager"),
    Cleaner("Cleaner");

    private String name;

    private Position(String name) {
        this.name = name;
    }

    public static Position getByPositionName(String positionName) {
        for (Position pos : Position.values()) {
            if (pos.name.equals(positionName)) {
                return pos;
            }
        }
        throw new IllegalArgumentException("Position does exist in the enum. Misconfiguration");
    }

}
