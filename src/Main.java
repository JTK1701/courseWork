import java.util.Scanner;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Employee[] employesArray = new Employee[10];
        EmployeeBook newBook = new EmployeeBook(10);
        employesArray[0] = new Employee(1, 60, "Natalia", "_BlackWidow_", "Romanoff");
        employesArray[1] = new Employee(2, 80, "Nicholas", "Joseph", "Fury");
        employesArray[2] = new Employee(3, 90, "Alexander", "_Goodwin_", "Pierce");
        employesArray[3] = new Employee(4, 100, "Anthony", "Edward", "Stark");
        employesArray[4] = new Employee(5, 50, "Brock", "_CrossBones_", "Ramlow");
        employesArray[5] = new Employee(1, 70, "Clinton", " Francis", "Barton");
        employesArray[6] = new Employee(2, 20, "Steven", "Grant", "Rogers");
        employesArray[7] = new Employee(3, 10, "James", "_Bucky_", "Barnes");
        employesArray[8] = new Employee(4, 40, "Robert", "Bruce", "Banner");
        employesArray[9] = new Employee(5, 30, "Jack", "_Bear_", "Rollins");

        Employee newEmployee1 = new Employee(2, 40, "Loki", "Lodur", "Loptr");
        Employee newEmployee2 = new Employee(4, 20, "Piter", "_Spidey_", "Parker");

        for (int i = 0; i < employesArray.length; i++) {
            newBook.addToEmployeeBook(employesArray[i]);
        }


        newBook.printAllEmployees();
        System.out.println();
        System.out.println();
        newBook.printAllSalaryInMonth();
        System.out.println();
        System.out.println();
        newBook.printMinSalary();
        System.out.println();
        System.out.println();
        newBook.printMaxSalary();
        System.out.println();
        System.out.println();
        newBook.printMiddleSalary();
        System.out.println();
        System.out.println();
        newBook.printFullName();
        System.out.println();
        System.out.println();
        newBook.indexAllSalary(1.6f);
        System.out.println();
        System.out.println();
        newBook.calculateMaxSalaryInDept(1);
        System.out.println();
        System.out.println();
        newBook.calculateMinSalaryInDept(2);
        System.out.println();
        System.out.println();
        newBook.printFullSalaryInDept(3);
        System.out.println();
        System.out.println();
        newBook.calculateMiddleSalaryInDept(4);
        System.out.println();
        System.out.println();
        newBook.indexAllSalaryInDept(5, 1.6f);
        System.out.println();
        System.out.println();
        newBook.printAllEmployeesInDept(1);
        System.out.println();
        System.out.println();
        newBook.printEmployeesSalaryLessThan(80);
        System.out.println();
        System.out.println();
        newBook.printEmployeesSalaryMoreThan(80);
        System.out.println();
        System.out.println();
        newBook.addNewEmployee(newEmployee1);
        System.out.println();
        System.out.println();
        newBook.stretchArrayAndAddEmployees(newEmployee1);
        System.out.println();
        System.out.println();
        newBook.deleteThisEmployee(3);
        System.out.println();
        System.out.println();
        newBook.searchId(3);
    }
}
