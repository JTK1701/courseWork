public class EmployeeBook {
    private Employee[] employeeBook = new Employee[10];
    public Employee[] inDept; //массив с сотрудниками отдела
    public float allSalary = 0f;
    public int employeeInDept;//сотрудников в отделе
    public float allSalaryInDept = 0f;//общая зп на отдел
    int[] idList = new int[20]; //Хранилище для id


    public EmployeeBook(int size) {
        this.employeeBook = new Employee[size];
    }
    public void addToEmployeeBook(Employee employee) {
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] == null) {
                employeeBook[i] = employee;
                for (int r = 0; r < idList.length; r++) {
                    if (idList[r] == 0) {
                        idList[r] = employee.getId();
                        break;
                    }
                }
                break;
            }
        }
    }
    //1 lvl
    //Получить список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения всех полей
    public void printAllEmployees() {
        System.out.println("Список всех сотрудников:");
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] == null) {
                System.out.println("На данную позицию сотрудник еще не назначен.");
            } else {
                System.out.println(employeeBook[i].toString());
            }
        }
    }
    //Посчитать сумму затрат на ЗП в месяц
    public void printAllSalaryInMonth() {
        for (int i = 0; i < employeeBook.length; i++) {
            allSalary += employeeBook[i].getSalary();
        }
        System.out.println("Затраты на заработную плату в месяц составляют - " + allSalary);
    }

    //Найти сотрудника с минимальной ЗП
    public void printMinSalary() {
        Employee minSalary = employeeBook[0];
        for (int i = 0; i <= employeeBook.length - 1; i++) {
            if (employeeBook[i].getSalary() < minSalary.getSalary()) {
                minSalary = employeeBook[i];
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой - " + minSalary.getFirstName() + " " +
                minSalary.getSurname() + " " + minSalary.getLastName() + ". Его заработная плата составляет - " +
                minSalary.getSalary());
    }

    //Найти сотрудника с максимальной ЗП
    public void printMaxSalary() {
        Employee maxSalary = employeeBook[0];
        for (int i = 0; i <= employeeBook.length - 1; i++) {
            if (employeeBook[i].getSalary() > maxSalary.getSalary()) {
                maxSalary = employeeBook[i];
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой - " + maxSalary.getFirstName() + " " +
                maxSalary.getSurname() + " " + maxSalary.getLastName() + ". Его заработная плата составляет - " +
                maxSalary.getSalary());
    }

    //Подсчитать среднее значение зарплат
    public void printMiddleSalary() {
        float middleSalary = allSalary / employeeBook.length;
        System.out.println("Средняя заработная плата составляет - " + middleSalary);
        System.out.println();
    }

    //Распечатать ФИО всех сотрудников
    public void printFullName() {
        for (int i = 0; i < employeeBook.length; i++) {
            System.out.println("ФИО сотрудника - " + employeeBook[i].getFirstName() + " " +
                    employeeBook[i].getSurname() + " " + employeeBook[i].getLastName());
        }
    }

    //2lvl
    //Индексация зп
    public void indexAllSalary(float indexSalaryForAll) {
        for (int i = 0; i < employeeBook.length; i++) {
            employeeBook[i].setSalary(employeeBook[i].getSalary() * indexSalaryForAll);
            System.out.println(employeeBook[i].getSalary());
        }
    }

    //По отделам
    public void determineAndFillDeptLength(int dept) {
        for (Employee employee : employeeBook) {
            if (employee.getDepartment() == dept) {
                employeeInDept += 1;
            }
        }
        inDept = new Employee[employeeInDept];
        for (Employee employee : employeeBook) {
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
    public void calculateMinSalaryInDept(int dept) {
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
    public void calculateMaxSalaryInDept(int dept) {
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
    public float calculateFullSalaryInDept(int dept) {
        determineAndFillDeptLength(dept);
        for (int i = 0; i < inDept.length; i++) {
            allSalaryInDept = allSalaryInDept + inDept[i].getSalary();
        }
        return allSalaryInDept;
    }

    public void printFullSalaryInDept(int dept) {
        System.out.println("Ежемесячные затраты на зп отдела " + dept + " составляют - " + calculateFullSalaryInDept(dept));
    }

    //средняя зп по отделу
    public void calculateMiddleSalaryInDept(int dept) {
        determineAndFillDeptLength(dept);
        float middleSalary = calculateFullSalaryInDept(dept) / inDept.length;
        System.out.println("Средняя зп по отделу " + dept + " - " + middleSalary);
    }

    //индексация зп отдела
    public void indexAllSalaryInDept(int dept, float indexSalaryForDept) {
        determineAndFillDeptLength(dept);
        System.out.println("Индексированная зп отделa " + dept + ":");
        for (int i = 0; i < inDept.length; i++) {
            inDept[i].setSalary(inDept[i].getSalary() * indexSalaryForDept);
            System.out.println("Сотрудник - " + inDept[i].getFirstName() + " " + inDept[i].getSurname() + " " +
                    inDept[i].getLastName() + " - " + inDept[i].getSalary());
        }
    }

    //напечатать всех сотрудников отдела
    public void printAllEmployeesInDept(int dept) {
        determineAndFillDeptLength(dept);
        System.out.println("Список сотрудников отдела " + dept);
        for (int i = 0; i < inDept.length; i++) {
            System.out.println(" Id сотрудника - " + inDept[i].getId() + " Сотрудник - " +
                    inDept[i].getFirstName() + " " + inDept[i].getSurname() + " " + inDept[i].getLastName() +
                    " Зарплата сотрудника составляет - " + inDept[i].getSalary());
        }
    }

    //зп меньше чем
    public void printEmployeesSalaryLessThan(int salaryThan) {
        System.out.println("Список сотрудников с заработной платой меньше " + salaryThan);
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i].getSalary() < salaryThan) {
                System.out.println(employeeBook[i].getFirstName() + " " + employeeBook[i].getSurname() + " " +
                        employeeBook[i].getLastName() + " Id сотрудника - " + employeeBook[i].getId() +
                        " Заработная плата сотрудника составляет - " + employeeBook[i].getSalary());
            }
        }
    }

    //Зп больше чем
    public void printEmployeesSalaryMoreThan(int salaryThan) {
        System.out.println("Список сотрудников с заработной платой больше " + salaryThan);
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i].getSalary() >= salaryThan) {
                System.out.println(employeeBook[i].getFirstName() + " " + employeeBook[i].getSurname() + " " +
                        employeeBook[i].getLastName() + " Id сотрудника - " + employeeBook[i].getId() +
                        " Заработная плата сотрудника составляет - " + employeeBook[i].getSalary());
            }
        }
    }

    //Добавить нового сотрудника
    public boolean addNewEmployee(Employee employee) {
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] == null) {
                employeeBook[i] = employee;
                System.out.printf("Сотрудник %s %s %s успешно занесен в список.",
                        employeeBook[i].getFirstName(),
                        employeeBook[i].getSurname(),
                        employeeBook[i].getLastName());
                for (int r = 0; r < idList.length; r++) {
                    if (idList[r] == 0) {
                        idList[r] = employee.getId();
                        break;
                    }
                }
                break;
            } else if (employeeBook[employeeBook.length - 1] != null) {
                System.out.println("Мест нет. Увольте кого-нибудь, чтобы освободить вакансию, или воспользуйтесь методом" +
                        " stretchArrayAndAddEmployees.");
                return false;
            }
        }
        return true;
    }
    //Удалить сотрудника
    public void deleteThisEmployee(int id) {
        for (int i = 0; i < employeeBook.length; i++) {
            System.out.println(employeeBook[i]);
            if (employeeBook[i].getId() == id) {
                System.out.println(employeeBook[i]);
                employeeBook[i] = null;
            }
        }
    }

    //Добавить метод для получения сотрудника по id
    public void searchId(int id) {
        int notFound = 0;
        int inIdList = 0;
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] != null) {
                if (employeeBook[i].getId() == id) {

                    System.out.println("Сотрудник с id " + id + " - " + employeeBook[i].getFirstName() + " " +
                            employeeBook[i].getSurname() + " " + employeeBook[i].getLastName() +
                            " из отдела " + employeeBook[i].getDepartment());
                    notFound++;
                    break;
                } else if (i == employeeBook.length - 1 && notFound == 0) {
                    System.out.println("Сотрудник с id " + id + " в списке не значится");
                }

            }
        }
        for (int r = 0; r < idList.length; r++) {
            if (idList[r] == id) {
                inIdList = idList[r];
            }
        }
        if (notFound == 0 && inIdList == id) {
            System.out.println("Сотрудник с данным id был ранее удален из списка.");
        }
    }

    //Лишний метод для увеличения массива, если очень хочется
    Employee[] y;

    private void stretchArrayEmployees() {
        y = new Employee[employeeBook.length + 1];
        for (int i = 0; i < employeeBook.length; i++) {
            y[i] = employeeBook[i];
        }
        employeeBook = y;
    }
    //еще один лишний метод
    public boolean stretchArrayAndAddEmployees(Employee employee) {
        stretchArrayEmployees();
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] == null) {
                employeeBook[i] = employee;
                System.out.printf("Сотрудник %s %s %s успешно занесен в список.",
                        employeeBook[i].getFirstName(),
                        employeeBook[i].getSurname(),
                        employeeBook[i].getLastName());
                for (int r = 0; r < idList.length; r++) {
                    if (idList[r] == 0) {
                        idList[r] = employee.getId();
                        break;
                    }
                }
                break;
            } else if (employeeBook[employeeBook.length - 1] != null) {
                System.out.println("Мест нет. Увольте кого-нибудь, чтобы освободить вакансию, или воспользуйтесь методом" +
                        " stretchArrayAndAddEmployees.");
                return false;
            }
        }
        return true;
    }
    // И еще один
    public void printIdList() {
        System.out.println("Список всех id Когда либо хранившихся в списке сотрудников");
        for (int i = 0; i < idList.length; i++) {
            System.out.println(idList[i]);
        }
    }
}
