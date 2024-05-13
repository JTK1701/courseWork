import java.util.Scanner;
import java.util.Objects;

public class Main {
    public static Employee[] employeesArray = new Employee[10];
    public static Employee[] inDept; //массив с сотрудниками отдела
    public static float allSalary = 0f;
    public static int employeeInDept;//сотрудников в отделе
    public static float allSalaryInDept = 0f;//общая зп на отдел

    //1 lvl
    //Получить список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения всех полей
    public static void printAllEmployees() {
        System.out.println("Список всех сотрудников:");
        for (int i = 0; i < employeesArray.length; i++) {
            System.out.println(employeesArray[i]);
        }
    }

    //Посчитать сумму затрат на ЗП в месяц
    public static void printAllSalaryInMonth() {
        for (int i = 0; i < employeesArray.length; i++) {
            allSalary += employeesArray[i].getSalary();
        }
        System.out.println("Затраты на заработную плату в месяц составляют - " + allSalary);
    }

    //Найти сотрудника с минимальной ЗП
    public static void printMinSalary() {
        Employee minSalary = employeesArray[0];
        for (int i = 0; i <= employeesArray.length - 1; i++) {
            if (employeesArray[i].getSalary() < minSalary.getSalary()) {
                minSalary = employeesArray[i];
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой - " + minSalary.getFirstName() + " " +
                minSalary.getSurname() + " " + minSalary.getLastName() + ". Его заработная плата составляет - " +
                minSalary.getSalary());
    }

    //Найти сотрудника с максимальной ЗП
    public static void printMaxSalary() {
        Employee maxSalary = employeesArray[0];
        for (int i = 0; i <= employeesArray.length - 1; i++) {
            if (employeesArray[i].getSalary() > maxSalary.getSalary()) {
                maxSalary = employeesArray[i];
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой - " + maxSalary.getFirstName() + " " +
                maxSalary.getSurname() + " " + maxSalary.getLastName() + ". Его заработная плата составляет - " +
                maxSalary.getSalary());
    }

    //Подсчитать среднее значение зарплат
    public static void printMiddleSalary() {
        float middleSalary = allSalary / employeesArray.length;
        System.out.println("Средняя заработная плата составляет - " + middleSalary);
        System.out.println();
    }

    //Распечатать ФИО всех сотрудников
    public static void printFullName() {
        for (int i = 0; i < employeesArray.length; i++) {
            System.out.println("ФИО сотрудника - " + employeesArray[i].getFirstName() + " " +
                    employeesArray[i].getSurname() + " " + employeesArray[i].getLastName());
        }
    }

    //2lvl
    //Индексация зп
    public static void indexAllSalary(float indexSalaryForAll) {
        for (int i = 0; i < employeesArray.length; i++) {
            employeesArray[i].setSalary(employeesArray[i].getSalary() * indexSalaryForAll);
            System.out.println(employeesArray[i].getSalary());
        }
    }

    //По отделам
    public static void determineAndFillDeptLength(int dept) {
        for (Employee employee : employeesArray) {
            if (employee.getDepartment() == dept) {
                employeeInDept += 1;
            }
        }
        inDept = new Employee[employeeInDept];
        for (Employee employee : employeesArray) {
            if (employee.getDepartment() == dept) {
                for (int r = 0; r < inDept.length; r++) {
                    if (inDept[r] == null) {
                        inDept[r] = employee;
                        break;
                    }
                }
            }
        }
        employeeInDept = 0;
    }

    //минимальная зп в отделе
    public static void calculateMinSalaryInDept(int dept) {
        determineAndFillDeptLength(dept);
        {
            Employee minSalary = inDept[0];
            for (int i = 0; i < inDept.length; i++) {
                if (inDept[i].getSalary() < minSalary.getSalary()) {
                    minSalary = inDept[i];
                }
            }
            System.out.println("Сотрудник с минимальной зарплатой в отделе " + dept + " - " + minSalary.getFirstName() + " " +
                    minSalary.getSurname() + " " + minSalary.getLastName() + ". Его заработная плата составляет - " +
                    minSalary.getSalary());
        }
    }

    //максимальная зп в отделе
    public static void calculateMaxSalaryInDept(int dept) {
        determineAndFillDeptLength(dept);
        {
            Employee maxSalary = inDept[0];
            for (int i = 0; i < inDept.length; i++) {
                if (inDept[i].getSalary() > maxSalary.getSalary()) {
                    maxSalary = inDept[i];
                }
            }
            System.out.println("Сотрудник с максимальной зарплатой в отделе " + dept + " - " + maxSalary.getFirstName() + " " +
                    maxSalary.getSurname() + " " + maxSalary.getLastName() + ". Его заработная плата составляет - " +
                    maxSalary.getSalary());
        }
    }

    //сумма затрат на зп по отделу
    public static float calculateFullSalaryInDept(int dept) {
        determineAndFillDeptLength(dept);
        for (int i = 0; i < inDept.length; i++) {
            allSalaryInDept = allSalaryInDept + inDept[i].getSalary();
        }
        return allSalaryInDept;
    }

    public static void printFullSalaryInDept(int dept) {
        System.out.println("Ежемесячные затраты на зп отдела " + dept + " составляют - " + calculateFullSalaryInDept(dept));
    }

    //средняя зп по отделу
    public static void calculateMiddleSalaryInDept(int dept) {
        determineAndFillDeptLength(dept);
        float middleSalary = calculateFullSalaryInDept(dept) / inDept.length;
        System.out.println("Средняя зп по отделу " + dept + " - " + middleSalary);
    }

    //индексация зп отдела
    public static void indexAllSalaryInDept(int dept, float indexSalaryForDept) {
        determineAndFillDeptLength(dept);
        System.out.println("Индексированная зп отделa " + dept + ":");
        for (int i = 0; i < inDept.length; i++) {
            inDept[i].setSalary(inDept[i].getSalary() * indexSalaryForDept);
            System.out.println("Сотрудник - " + inDept[i].getFirstName() + " " + inDept[i].getSurname() + " " +
                    inDept[i].getLastName() + " - " + inDept[i].getSalary());
        }
    }

    //напечатать всех сотрудников отдела
    public static void printAllEmployeesInDept(int dept) {
        determineAndFillDeptLength(dept);
        System.out.println("Список сотрудников отдела " + dept);
        for (int i = 0; i < inDept.length; i++) {
            System.out.println(" Id сотрудника - " + inDept[i].getId() + " Сотрудник - " +
                    inDept[i].getFirstName() + " " + inDept[i].getSurname() + " " + inDept[i].getLastName() +
                    " Зарплата сотрудника составляет - " + inDept[i].getSalary());
        }
    }

    //зп меньше чем
    public static void printEmployeesSalaryLessThan(int salaryThan) {
        System.out.println("Список сотрудников с заработной платой меньше " + salaryThan);
        for (int i = 0; i < employeesArray.length; i++) {
            if (employeesArray[i].getSalary() < salaryThan) {
                System.out.println(employeesArray[i].getFirstName() + " " + employeesArray[i].getSurname() + " " +
                        employeesArray[i].getLastName() + " Id сотрудника - " + employeesArray[i].getId() +
                        " Заработная плата сотрудника составляет - " + employeesArray[i].getSalary());
            }
        }
    }

    //Зп больше чем
    public static void printEmployeesSalaryMoreThan(int salaryThan) {
        System.out.println("Список сотрудников с заработной платой больше " + salaryThan);
        for (int i = 0; i < employeesArray.length; i++) {
            if (employeesArray[i].getSalary() >= salaryThan) {
                System.out.println(employeesArray[i].getFirstName() + " " + employeesArray[i].getSurname() + " " +
                        employeesArray[i].getLastName() + " Id сотрудника - " + employeesArray[i].getId() +
                        " Заработная плата сотрудника составляет - " + employeesArray[i].getSalary());
            }
        }
    }

    public static void main(String[] args) {
        employeesArray[0] = new Employee(1, 60, "Natalia", "_BlackWidow_", "Romanoff");
        employeesArray[1] = new Employee(2, 80, "Nicholas", "Joseph", "Fury");
        employeesArray[2] = new Employee(3, 90, "Alexander", "_Goodwin_", "Pierce");
        employeesArray[3] = new Employee(4, 100, "Anthony", "Edward", "Stark");
        employeesArray[4] = new Employee(5, 50, "Brock", "_CrossBones_", "Ramlow");
        employeesArray[5] = new Employee(1, 70, "Clinton", " Francis", "Barton");
        employeesArray[6] = new Employee(2, 20, "Steven", "Grant", "Rogers");
        employeesArray[7] = new Employee(3, 10, "James", "_Bucky_", "Barnes");
        employeesArray[8] = new Employee(4, 40, "Robert", "Bruce", "Banner");
        employeesArray[9] = new Employee(5, 30, "Jack", "_Bear_", "Rollins");

        printAllSalaryInMonth();
        System.out.println();
        System.out.println();
        printMinSalary();
        System.out.println();
        System.out.println();
        printMaxSalary();
        System.out.println();
        System.out.println();
        printMiddleSalary();
        System.out.println();
        System.out.println();
        printFullName();
        System.out.println();
        System.out.println();
        indexAllSalary(1.6f);
        System.out.println();
        System.out.println();
        calculateMaxSalaryInDept(1);
        System.out.println();
        System.out.println();
        calculateMinSalaryInDept(2);
        System.out.println();
        System.out.println();
        printFullSalaryInDept(3);
        System.out.println();
        System.out.println();
        calculateMiddleSalaryInDept(4);
        System.out.println();
        System.out.println();
        indexAllSalaryInDept(5, 1.6f);
        System.out.println();
        System.out.println();
        printAllEmployeesInDept(1);
        System.out.println();
        System.out.println();
        printEmployeesSalaryLessThan(80);
        System.out.println();
        System.out.println();
        printEmployeesSalaryMoreThan(80);


    }
}
