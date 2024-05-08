import java.util.Scanner;
import java.util.Objects;

public class Main {
    public static Employee[] employeesArray = new Employee[10];

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
        for (int i = 0; i < employeesArray.length; i++) {
            System.out.println(employeesArray[i]);
        }
        System.out.println();
        System.out.println();
        //1 уровень сложности.
        {
            float ollSalary = 0f;

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

            float middleSalary = ollSalary / employeesArray.length;
            System.out.println("Средняя заработная плата составляет - " + middleSalary);
            System.out.println();
            for (int i = 0; i < employeesArray.length; i++) {
                System.out.println("ФИО сотрудника - " + employeesArray[i].getFirstName() + " " +
                        employeesArray[i].getSurname() + " " + employeesArray[i].getLastName());
            }
        }
        //средненько
        //Индексация зп
        float salaryIndexing = 1.6f; //индексация всех сотрудников
        int salaryThan = 60;//зп меньше или больше этого
        {//Индексация для всех
            for (int i = 0; i < employeesArray.length; i++) {
                if (employeesArray[i] != null) {
                    employeesArray[i].setSalary(employeesArray[i].getSalary() * salaryIndexing);
                    System.out.println(employeesArray[i].getSalary());
                }
            }
        }
        {
            //Действия по отделам
            int departmentOnly = 2; //отдел
            int employeeInDept = 0;//сотрудников в отделе
            //размер отдела
            for (int i = 0; i < employeesArray.length; i++) {
                if (employeesArray[i].getDepartment() == departmentOnly) {
                    employeeInDept += 1;
                }
            }
            Employee[] inDept = new Employee[employeeInDept]; //массив с сотрудниками отдела
            //сотрудники
            for (int i = 0; i < employeesArray.length; i++) {
                if (employeesArray[i].getDepartment() == departmentOnly) {
                    for (int r = 0; r <= inDept.length - 1; r++) {
                        if (inDept[r] == null) {
                            inDept[r] = employeesArray[i];
                            break;
                        }
                    }
                }
            }
            float allSalary = 0f;//общая зп на отдел
            Employee minSalary = inDept[0];//минимальная зп
            Employee maxSalary = inDept[0];//максимальная зп


            { //минимальная зп в отделе
                for (int i = 0; i < inDept.length; i++) {
                    if (inDept[i].getSalary() < minSalary.getSalary() && inDept[i].getDepartment() == departmentOnly) {
                        minSalary = inDept[i];
                    }
                }
                System.out.println("Сотрудник с минимальной зарплатой в отделе - " + minSalary.getFirstName() + " " +
                        minSalary.getSurname() + " " + minSalary.getLastName() + ". Его заработная плата составляет - " +
                        minSalary.getSalary());
            }
            { //максимальная зп в отделе
                for (int y = 0; y < inDept.length; y++) {
                    if (inDept[y] != null && inDept[y].getDepartment() == departmentOnly) {
                        maxSalary = inDept[y];
                    }
                }
                for (int i = 0; i < inDept.length; i++) {
                    if (inDept[i].getSalary() > maxSalary.getSalary() && inDept[i].getDepartment() == departmentOnly) {
                        maxSalary = inDept[i];
                    }
                }
                System.out.println("Сотрудник с максимальной зарплатой в отделе - " + maxSalary.getFirstName() + " " +
                        maxSalary.getSurname() + " " + maxSalary.getLastName() + ". Его заработная плата составляет - " +
                        maxSalary.getSalary());
            }

            {//сумма затрат на зп по отделу
                for (int i = 0; i < inDept.length; i++) {
                    if (inDept[i].getDepartment() == departmentOnly) {
                        allSalary = allSalary + inDept[i].getSalary();
                    }
                }
                System.out.println("Затраты на заработную плату отдела составляют - " + allSalary);

            }
            {//средняя зп
                for (int i = 0; i < inDept.length; i++) {
                    if (inDept[i].getDepartment() == departmentOnly) {
                        employeeInDept++;
                    }
                }
                System.out.println("Средняя зп по отделу - " + allSalary / employeeInDept);
            }
            {//индексация зп
                float indexSalary = 1.8f;
                for (int i = 0; i <= inDept.length - 1; i++) {
                    inDept[i].setSalary(inDept[i].getSalary() * indexSalary);
                    System.out.println("Индексированная зп - " + inDept[i].getSalary());
                }
            }
            {//напечатать всех сотрудников
                System.out.println("Список сотрудников отдела " + departmentOnly);
                for (int i = 0; i < inDept.length; i++) {
                    System.out.println(" Id сотрудника - " + inDept[i].getId() + " Сотрудник - " +
                            inDept[i].getFirstName() + " " + inDept[i].getSurname() + " " + inDept[i].getLastName() +
                            " Зарплата сотрудника составляет - " + inDept[i].getSalary()
                    );
                }
            }
        }
        System.out.println();
        System.out.println();
        //зп меньше чем
        System.out.println("Список сотрудников с заработной платой меньше " + salaryThan);
        for (int i = 0; i < employeesArray.length; i++) {
            if (employeesArray[i].getSalary() < salaryThan) {
                System.out.println(employeesArray[i].getFirstName() + " " + employeesArray[i].getSurname() + " " +
                        employeesArray[i].getLastName() + " Id сотрудника - " + employeesArray[i].getId() +
                        " Заработная плата сотрудника составляет - " + employeesArray[i].getSalary());
            }
        }
        System.out.println();
        System.out.println();
        //Зп больше чем
        System.out.println("Список сотрудников с заработной платой больше " + salaryThan);
        for (int i = 0; i < employeesArray.length; i++) {
            if (employeesArray[i].getSalary() >= salaryThan) {
                System.out.println(employeesArray[i].getFirstName() + " " + employeesArray[i].getSurname() + " " +
                        employeesArray[i].getLastName() + " Id сотрудника - " + employeesArray[i].getId() +
                        " Заработная плата сотрудника составляет - " + employeesArray[i].getSalary());
            }
        }

    }
}
