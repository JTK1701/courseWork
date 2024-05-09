public class EmployeeBook {
    private Employee[] employeeBook; //общий массив
    Employee[] oneDept;//массив с одним департаментом
    int department;//номер департамента для работы с одним департаментом
    int salaryThen;//переменная для зарплат больше и меньше этого
    int[] idList = new int[20]; //Хранилище для id

    //инициализация массива
    public EmployeeBook(int size) {
        this.employeeBook = new Employee[size];
    }

    //Заполнение массива
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

    //Получить список всех сотрудников со всеми имеющимися по ним данными
    public void getEmployeeBookPrint() {
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] == null) {
                System.out.println("На данную позицию сотрудник еще не назначен.");
            } else {
                System.out.println(employeeBook[i].toString());
            }
        }
    }

    //Посчитать сумму затрат на ЗП в месяц
    public float calculateAllSalary() {
        int i = 0;
        float sum = 0f;
        for (Employee emp : employeeBook) {
            if (employeeBook[i] != null) {
                sum = sum + emp.getSalary();
            }
        }
        return sum;
    }

    //Найти сотрудника с минимальной ЗП
    public void calculateAndPrintMinSalary() {
        Employee minSalary = employeeBook[0];
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i].getSalary() < minSalary.getSalary()) {
                minSalary = employeeBook[i];
            }
        }
        System.out.println("Сотрудник с минимальной заработной платой - " + minSalary.getFirstName() + " " +
                minSalary.getSurname() + " " + minSalary.getLastName() + " " + " Его заработная плата составляет - " +
                minSalary.getSalary());
    }

    //Найти сотрудника с максимальной ЗП
    public void calculateAndPrintMaxSalary() {
        Employee maxSalary = employeeBook[0];
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i].getSalary() > maxSalary.getSalary()) {
                maxSalary = employeeBook[i];
            }
        }
        System.out.println("Сотрудник с максимальной заработной платой - " + maxSalary.getFirstName() + " " +
                maxSalary.getSurname() + " " + maxSalary.getLastName() + " " + " Его заработная плата составляет - " +
                maxSalary.getSalary());
    }

    //Подсчитать среднее значение зарплат
    public float calculateAverageSalary(float allSalary) {
        float sum = allSalary;
        float ave = sum / employeeBook.length;
        return ave;
    }

    //Распечатать ФИО всех сотрудников
    public void printAllNames() {
        System.out.println("Имена всех сотрудников:");
        for (int i = 0; i < employeeBook.length; i++) {
            System.out.println(employeeBook[i].getFirstName() + " " + employeeBook[i].getSurname() +
                    " " + employeeBook[i].getLastName());
        }
    }

    //Проиндексировать зарплату
    public void calculateSalaryIndexation(float ind) {
        for (int i = 0; i < employeeBook.length; i++) {
            employeeBook[i].setSalary(employeeBook[i].getSalary() * (float) ind);
        }
    }

    //инициализация массива по отделу
    public void excludeDepartmentsAndNewArray(int department) {
        this.department = department;
        int size = 0;
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i].getDepartment() == department) {
                size = size + 1;

            }
        }
        oneDept = new Employee[size];
    }

    //Заполнение массива отдела
    public void addOnDeptEmployeeAddAndPrint() {
        System.out.println("Сотрудники отдела:");
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i].getDepartment() == department) {
                for (int r = 0; r < oneDept.length; r++) {
                    if (oneDept[r] == null) {
                        oneDept[r] = employeeBook[i];
                        System.out.println(oneDept[r]);
                        break;
                    }
                }
            }
        }
    }

    //Найти сотрудника с минимальной зп в отделе
    public float calculateAndPrintInDeptMinSalary() {
        float minSalaryInDept = oneDept[0].getSalary();
        Employee homeless = oneDept[0];
        for (int i = 0; i < oneDept.length; i++) {
            if (oneDept[i].getSalary() < minSalaryInDept) {
                minSalaryInDept = oneDept[i].getSalary();
                homeless = oneDept[i];
            }
        }
        System.out.println("минимальная зп в отделе составляет - " + minSalaryInDept + " Сотрудник - " +
                homeless.getFirstName() + " " + homeless.getSurname() + " " + homeless.getLastName());
        return minSalaryInDept;
    }

    //Найти сотрудника с максимальной зп
    public float calculateAndPrintInDeptMaxSalary() {
        float maxSalaryInDept = oneDept[0].getSalary();
        Employee richBitch = oneDept[0];
        for (int i = 0; i < oneDept.length; i++) {
            if (oneDept[i].getSalary() > maxSalaryInDept) {
                maxSalaryInDept = oneDept[i].getSalary();
                richBitch = oneDept[i];
            }
        }
        System.out.println("максимальная зп в отделе составляет - " + maxSalaryInDept + " Сотрудник - " +
                richBitch.getFirstName() + " " + richBitch.getSurname() + " " + richBitch.getLastName());
        return maxSalaryInDept;
    }

    //Найти сумму затрат на зп по отделу
    public float calculateInDeptAllSalary() {
        int i = 0;
        float sum = 0f;
        for (Employee emp : oneDept) {
            if (oneDept[i] != null) {
                sum = sum + emp.getSalary();
            }
        }
        return sum;
    }

    //Найти среднюю зп по отделу
    public float calculateInDeptAverageSalary(float inDeptAllSalary) {
        float sum = inDeptAllSalary;
        float ave = sum / oneDept.length;
        return ave;
    }

    //Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра;
    public void calculateInDeptSalaryIndexation(float index) {
        for (int i = 0; i < oneDept.length; i++) {
            oneDept[i].setSalary(oneDept[i].getSalary() * index);
        }
    }

    //Напечатать всех сотрудников отдела (все данные, кроме отдела)
    public void printInDeptEmployees() {
        System.out.println("Сотрудники отдела " + department + ": ");
        for (int i = 0; i < oneDept.length; i++) {
            System.out.println("Id сотрудника - " + oneDept[i].getId() + " ФИО - " + oneDept[i].getFirstName() + " " +
                    oneDept[i].getSurname() + " " + oneDept[i].getLastName() + " Заработная плата составляет - " +
                    oneDept[i].getSalary());
        }
    }

    //Получить в качестве параметра число и вывести:
    //Всех сотрудников с зп меньше числа
    public void calculateAndPrintListSalaryMoreThan(int chek) {
        salaryThen = chek;
        System.out.println("Сотрудники с заработной платой выше " + salaryThen);
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i].getSalary() > salaryThen) {
                System.out.println(employeeBook[i].toString());
            }
        }
    }

    //Всех сотрудников с зп больше (или равно) числа
    public void calculateAndPrintListSalaryLessThan(int chek) {
        salaryThen = chek;
        System.out.println("Сотрудники с заработной платой ниже " + salaryThen);
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i].getSalary() <= salaryThen) {
                System.out.println(employeeBook[i].toString());
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
                        " stretchArrayEmployees.");
                return false;
            }
        }
        return true;
    }

    //Лишний метод для увеличения массива, если очень хочется
    Employee[] y;

    public void stretchArrayEmployees() {
        y = new Employee[employeeBook.length + 2];
        for (int i = 0; i < employeeBook.length; i++) {
            y[i] = employeeBook[i];
        }
        employeeBook = y;
    }

    //Удалить сотрудника
    public void deleteThisEmployee(int id) {
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i].getId() == id) {
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


    public void printIdList() {
        System.out.println("Список всех id Когда либо хранившихся в списке сотрудников");
        for (int i = 0; i < idList.length; i++) {
            System.out.println(idList[i]);
        }
    }
}

