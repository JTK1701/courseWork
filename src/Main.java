import java.util.Scanner;
import java.util.Objects;

public class Main {
    public static Employee[] employeesArray = new Employee[10];

    public static void main(String[] args) {
        employeesArray[0] = new Employee(1, 545455, "Natalia", "BlackWidow", "Romanoff");
        employeesArray[1] = new Employee(2, 365454, "Nicholas", "Joseph", "Fury");
        employeesArray[2] = new Employee(3, 2542546, "Alexander", "Goodwin", "Pierce");
        employeesArray[3] = new Employee(4, 25425434, "Anthony", "Edward", "Stark");
        employeesArray[4] = new Employee(5, 552528, "Brock", "CrossBones", "Ramlow");
        employeesArray[5] = new Employee(1, 254252, "Clinton", " Francis", "Barton");
        employeesArray[6] = new Employee(2, 364535, "Stiven", "Grant", "Rogers");
        employeesArray[7] = new Employee(3, 25425, "James", "Bucky", "Barnes");
        employeesArray[8] = new Employee(4, 254254, "Robert", "Bruce", "Banner");
        employeesArray[9] = new Employee(5, 258546, "Jack", "Bear", "Rollins");
        for (int i = 0; i < employeesArray.length; i++) {
            System.out.println(employeesArray[i]);
        }
        System.out.println();
        System.out.println();
        double ollSalary = 0;

        {
            for (int i = 0; i < employeesArray.length; i++) {
                ollSalary += employeesArray[i].getSalary();
            }
        }
        System.out.println("Затраты на заработную плату в месяц составляют - " + ollSalary);
        System.out.println();
        Employee minSalary = employeesArray[0];
        for (int i = 0; i <= employeesArray.length - 1; i++) {
            if (employeesArray[i].getSalary() < minSalary.getSalary()) {
                minSalary = employeesArray[i];
            }
        }

        System.out.println("Сотрудник с минимальной зарплатой - " + minSalary.getFirstName() + " " +
                minSalary.getSurname() + " " + minSalary.getLastName() + ". Его заработная плата составляет - " +
                minSalary.getSalary());
        System.out.println();
        Employee maxSalary = employeesArray[0];
        for (int i = 0; i <= employeesArray.length - 1; i++) {
            if (employeesArray[i].getSalary() > maxSalary.getSalary()) {
                maxSalary = employeesArray[i];
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой - " + maxSalary.getFirstName() + " " +
                maxSalary.getSurname() + " " + maxSalary.getLastName() + ". Его заработная плата составляет - " +
                maxSalary.getSalary());

        double middleSalary = ollSalary/employeesArray.length;
        System.out.println("Средняя заработная плата составляет - " + middleSalary);
        System.out.println();
        for (int i = 0; i < employeesArray.length; i++) {
            System.out.println("ФИО сотрудника - " + employeesArray[i].getFirstName() + " " +
                    employeesArray[i].getSurname() + " " + employeesArray[i].getLastName());
        }
    }
}
