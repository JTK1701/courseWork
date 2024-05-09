import java.util.Scanner;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Employee[] employeeData = new Employee[10];
        EmployeeBook newBook = new EmployeeBook(10);
        //Основные сотрудники
        employeeData[0] = new Employee(1, 60, "Natalia", "_BlackWidow_", "Romanoff");
        employeeData[1] = new Employee(2, 80, "Nicholas", "Joseph", "Fury");
        employeeData[2] = new Employee(3, 90, "Alexander", "_Goodwin_", "Pierce");
        employeeData[3] = new Employee(4, 100, "Anthony", "Edward", "Stark");
        employeeData[4] = new Employee(5, 50, "Brock", "_CrossBones_", "Ramlow");
        employeeData[5] = new Employee(1, 70, "Clinton", " Francis", "Barton");
        employeeData[6] = new Employee(2, 20, "Steven", "Grant", "Rogers");
        employeeData[7] = new Employee(3, 10, "James", "_Bucky_", "Barnes");
        employeeData[8] = new Employee(4, 40, "Robert", "Bruce", "Banner");
        employeeData[9] = new Employee(5, 30, "Jack", "_Bear_", "Rollins");
        //Дополнительные сотрудники
        Employee newEmployee1 = new Employee(2, 40, "Loki", "Lodur", "Loptr");
        Employee newEmployee2 = new Employee(4, 20, "Piter", "_Spidey_", "Parker");

        for (int i = 0; i < employeeData.length; i++) {
            newBook.addToEmployeeBook(employeeData[i]);
        }
        System.out.println();
        System.out.println();
        float index = 1.6f;

        System.out.println("Затраты на зп в месяц составляют - " + newBook.calculateAllSalary());
        System.out.println();
        System.out.println("Распечатать массив всех сотрудников");
        newBook.getEmployeeBookPrint();
        System.out.println();
        System.out.println();
        System.out.println("Минимальная зп среди всех сотрудников");
        newBook.calculateAndPrintMinSalary();
        System.out.println();
        System.out.println();
        System.out.println("Максимальная зп среди всех сотрудников");
        newBook.calculateAndPrintMaxSalary();
        System.out.println();
        System.out.println();
        System.out.println("Средняя зп составляет - " + newBook.calculateAverageSalary(newBook.calculateAllSalary()));
        System.out.println();
        System.out.println();
        System.out.println("Проиндексировать зп всех сотрудников");
        newBook.calculateSalaryIndexation(index);
        System.out.println();
        System.out.println();
        System.out.println("Создать новый массив для отдела");
        newBook.excludeDepartmentsAndNewArray(3);
        System.out.println();
        System.out.println();
        System.out.println("Добавить в массив и распечатать сотрудников отдела");
        newBook.addOnDeptEmployeeAddAndPrint();
        System.out.println();
        System.out.println();
        System.out.println("Затраты на зп отдела в месяц составляют - " + newBook.calculateInDeptAllSalary());
        System.out.println();
        System.out.println();
        System.out.println("Максимальная зп в отделе");
        newBook.calculateAndPrintInDeptMaxSalary();
        System.out.println();
        System.out.println();
        System.out.println("минимальная зп в отделе");
        newBook.calculateAndPrintInDeptMinSalary();
        System.out.println();
        System.out.println();
        System.out.println("средняя зп сотрудников из отдела");
        System.out.println(newBook.calculateInDeptAverageSalary(newBook.calculateInDeptAllSalary()));
        System.out.println();
        System.out.println();
        System.out.println("Проиндексировать зп отдела");
        newBook.calculateInDeptSalaryIndexation(index);
        System.out.println();
        System.out.println();
        System.out.println("Распечатать сотрудников отдела");
        newBook.printInDeptEmployees();
        System.out.println();
        System.out.println();
        System.out.println("Зп меньше заданного значения");
        newBook.calculateAndPrintListSalaryMoreThan(80);
        System.out.println();
        System.out.println();
        System.out.println("Зп больше заданного числа");
        newBook.calculateAndPrintListSalaryLessThan(80);
        System.out.println();
        System.out.println();
        System.out.println("Увеличить массив");
        newBook.stretchArrayEmployees();
        System.out.println();
        System.out.println();
        System.out.println("Распечатать всех сотрудников");
        newBook.getEmployeeBookPrint();
        System.out.println();
        System.out.println();
        System.out.println("Добавить нового сотрудника");
        newBook.addNewEmployee(newEmployee1);
        System.out.println();
        System.out.println();
        System.out.println("Добавить нового сотрудника");
        newBook.addNewEmployee(newEmployee2);
        System.out.println();
        System.out.println();
        System.out.println("Распечатать всех сотрудников");
        newBook.getEmployeeBookPrint();
        System.out.println();
        System.out.println();
        System.out.println("Найти сотрудника по id");
        newBook.searchId(7);
        System.out.println();
        System.out.println();
        System.out.println("Удалить сотрудника");
        newBook.deleteThisEmployee(3);
        System.out.println();
        System.out.println();
        System.out.println("Найти сотрудника по id");
        newBook.searchId(4);

    }
}