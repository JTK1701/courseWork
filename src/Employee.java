import java.util.Objects;

public class Employee {
    private int department;
    private int id;
    private String firstName;
    private String surname;
    private String lastName;
    private float salary;
    private static int idCounter;

    public Employee(int department, float salary, String firstName, String surname, String lastName) {
        this.department = department;
        this.firstName = firstName;
        this.surname = surname;
        this.lastName = lastName;
        this.salary = salary;
        this.id = counterId();
    }

    private static int counterId() {
        idCounter++;
        return idCounter;
    }

    public int getDepartment() {
        return this.department;
    }

    public int getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getLastName() {
        return this.lastName;
    }

    public float getSalary() {
        return this.salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Сотрудник - " + firstName + " " + surname + " " + lastName + ". " +
                "Id сотрудника - " + id + ". " +
                "Отдел - " + department + "."+
                "Заработная плата - " + salary + ". ";
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(this.department, this.id, this.salary, this.firstName, this.surname, this.lastName);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return false;
        }
        if (other == null) {
            return false;
        }
        if (this.hashCode() != other.hashCode()) {
            return false;
        }
        if (this.getClass() != other.getClass()) {
            return false;
        }
        return this.department == ((Employee) other).department && this.id == ((Employee) other).id &&
                this.salary == ((Employee) other).salary && this.firstName.equals(((Employee) other).firstName) &&
                this.surname.equals(((Employee) other).surname) &&
                this.lastName.equals(((Employee) other).lastName);
    }
}
