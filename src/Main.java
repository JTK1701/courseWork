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

        System.out.println("printAllEmployees");
        newBook.printAllEmployees();
        System.out.println();
        System.out.println("printAllSalaryInMonth");
        newBook.printAllSalaryInMonth();
        System.out.println();
        System.out.println("printMinSalary");
        newBook.printMinSalary();
        System.out.println();
        System.out.println("printMaxSalary");
        newBook.printMaxSalary();
        System.out.println();
        System.out.println("printMiddleSalary");
        newBook.printMiddleSalary();
        System.out.println();
        System.out.println("printFullName");
        newBook.printFullName();
        System.out.println();
        System.out.println("indexAllEmployeesSalary");
        newBook.indexAllEmployeesSalary(1.6f);
        newBook.printAllEmployees();
        System.out.println();
        System.out.println("calculateMaxSalaryInDept");
        newBook.calculateMaxSalaryInDept(1);
        System.out.println();
        System.out.println("calculateMinSalaryInDept");
        newBook.calculateMinSalaryInDept(2);
        System.out.println();
        System.out.println();
        System.out.println("printFullSalaryInDept");
        newBook.printFullSalaryInDept(3);
        System.out.println();
        System.out.println("calculateMiddleSalaryInDept");
        newBook.calculateMiddleSalaryInDept(4);
        System.out.println();
        System.out.println("indexAllSalaryInDept");
        newBook.indexAllSalaryInDept(5, 1.6f);
        System.out.println();
        System.out.println("printAllEmployeesInDept");
        newBook.printAllEmployeesInDept(1);
        System.out.println();
        System.out.println("printEmployeesSalaryLessThan");
        newBook.printEmployeesSalaryLessThan(80);
        System.out.println();
        System.out.println("printEmployeesSalaryMoreThan");
        newBook.printEmployeesSalaryMoreThan(80);
        System.out.println();
        System.out.println("addNewEmployee");
        newBook.addNewEmployee(newEmployee1);
        System.out.println();
        System.out.println("stretchArrayAndAddEmployees");
        newBook.stretchArrayAndAddEmployees(newEmployee1);
        System.out.println();
        System.out.println();
        System.out.println("deleteThisEmployee");
        newBook.deleteThisEmployee(3);
        System.out.println();
        System.out.println("searchAndPrintId");
        newBook.searchAndPrintId(3);
        System.out.println();
        System.out.println("PrintDeletedEmployees");
        newBook.PrintDeletedEmployees();
    }
}
