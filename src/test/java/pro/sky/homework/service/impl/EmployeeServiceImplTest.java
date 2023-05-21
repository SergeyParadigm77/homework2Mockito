package pro.sky.homework.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.skypro.homework.Employee;
import pro.skypro.homework.exceptions.EmployeeAlreadyAddedException;
import pro.skypro.homework.exceptions.EmployeeNotFoundException;
import pro.skypro.homework.service.EmployeeService;
import pro.skypro.homework.service.Impl.EmployeeServiceImpl;

import java.util.*;



public class EmployeeServiceImplTest {
    private final EmployeeService employeeService = new EmployeeServiceImpl();

    @Test
    public void shouldThrowExceptionWhenEmployeeIsAlreadyPresentedInRepository() {
        //given
        Employee employee = new Employee("Ivan", "Petrov", 100000, 1);
        employeeService.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getSalary(), employee.getDepartment());

        //when
        // then
        Assertions.assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getSalary(), employee.getDepartment()));
    }

    @Test
    public void shouldReturnCorrectEmployee() {
        //given
        Employee employee = new Employee("Ivan", "Petrov", 100000, 1);

        //when
        Employee addedEmployee = employeeService.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getSalary(), employee.getDepartment());

        //then
        Assertions.assertEquals(employee, addedEmployee);
    }

    @Test
    public void shouldReturnCorrectAllEmployees() {
        //given
        Employee employee1 = new Employee("Ivan", "Petrov", 100000, 1);
        Employee employee2 = new Employee("Petr", "Ivanov", 200000, 2);
        Employee employee3 = new Employee("Ivan", "Ivanov", 300000, 3);
        Collection<Employee> allEmployees2 = new HashSet<>() {
        };
        allEmployees2.add(employee1);
        allEmployees2.add(employee2);
        allEmployees2.add(employee3);

        employeeService.addEmployee(employee1.getFirstName(), employee1.getLastName(), employee1.getSalary(), employee1.getDepartment());
        employeeService.addEmployee(employee2.getFirstName(), employee2.getLastName(), employee2.getSalary(), employee2.getDepartment());
        employeeService.addEmployee(employee3.getFirstName(), employee3.getLastName(), employee3.getSalary(), employee3.getDepartment());
        //when
        Collection<Employee> allEmployees = new HashSet<>(employeeService.getAllEmployees());
        //then
        Assertions.assertEquals(allEmployees, allEmployees2);
    }

    @Test
    public void shouldReturnCorrectFindEmployee() {
        //given
        Employee employee1 = new Employee("Ivan", "Petrov", 100000, 1);
        Employee employee2 = new Employee("Petr", "Ivanov", 200000, 2);

        employeeService.addEmployee(employee1.getFirstName(), employee1.getLastName(), employee1.getSalary(), employee1.getDepartment());
        employeeService.addEmployee(employee2.getFirstName(), employee2.getLastName(), employee2.getSalary(), employee2.getDepartment());
        //when
        Employee findedEmployee = employeeService.findEmployee(employee1.getFirstName(), employee1.getLastName());
        //then
        Assertions.assertEquals(employee1, findedEmployee);
    }
    @Test
    public void shouldThrowNotFoundExceptionWhenEmployeeIsNotFound() {
        //given
        Employee employee1 = new Employee("Ivan", "Petrov", 100000, 1);
        Employee employee2 = new Employee("Petr", "Ivanov", 200000, 2);

        employeeService.addEmployee(employee1.getFirstName(), employee1.getLastName(), employee1.getSalary(), employee1.getDepartment());
        //when
        // then
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> employeeService.findEmployee(employee2.getFirstName(), employee2.getLastName()));
    }
    @Test
    public void shouldCorrectRemoveEmployee() {
        //given
        Employee employee1 = new Employee("Ivan", "Petrov", 100000, 1);
        Employee employee2 = new Employee("Petr", "Ivanov", 200000, 2);
        Employee employee3 = new Employee("Ivan", "Ivanov", 300000, 3);
        Collection<Employee> allEmployees2 = new HashSet<>() {};
        allEmployees2.add(employee1);
        allEmployees2.add(employee2);

        employeeService.addEmployee(employee1.getFirstName(), employee1.getLastName(), employee1.getSalary(), employee1.getDepartment());
        employeeService.addEmployee(employee2.getFirstName(), employee2.getLastName(), employee2.getSalary(), employee2.getDepartment());
        employeeService.addEmployee(employee3.getFirstName(), employee3.getLastName(), employee3.getSalary(), employee3.getDepartment());
        //when
        employeeService.removeEmployee(employee3.getFirstName(), employee3.getLastName());
        Collection<Employee> allEmployees = new HashSet<>(employeeService.getAllEmployees());

        //then
        Assertions.assertEquals(allEmployees, allEmployees2);
    }
    @Test
    public void shouldThrowNotFoundExceptionWhenRemoveEmployeeIsNotFound() {
        //given
        Employee employee1 = new Employee("Ivan", "Petrov", 100000, 1);
        Employee employee2 = new Employee("Petr", "Ivanov", 200000, 2);

        employeeService.addEmployee(employee1.getFirstName(), employee1.getLastName(), employee1.getSalary(), employee1.getDepartment());
        //when
        // then
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> employeeService.removeEmployee(employee2.getFirstName(), employee2.getLastName()));
    }
}