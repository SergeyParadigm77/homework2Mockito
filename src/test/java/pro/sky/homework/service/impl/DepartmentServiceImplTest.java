package pro.sky.homework.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.skypro.homework.Employee;
import pro.skypro.homework.service.Impl.DepartmentServiceImpl;
import pro.skypro.homework.service.Impl.EmployeeServiceImpl;

import java.util.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {
    @Mock
    private EmployeeServiceImpl employeeService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;
    @Test
    public void shouldReturnEmployeeWithMaxSalaryDepartment() {
        //given
        Employee employee1 = new Employee("Ivan", "Petrov", 100000, 1);
        Employee employee2 = new Employee("Petr", "Ivanov", 200000, 1);
        Employee employee3 = new Employee("Ivan", "Ivanov", 300000, 2);

        Collection<Employee> employees = new HashSet<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        when(employeeService.getAllEmployees()).thenReturn(employees);
        //when
        Employee employeeWithMaxSalaryDepartment = departmentService.ReturnEmployeeWithMaxSalary(1);
        //then
        Assertions.assertEquals(employee2, employeeWithMaxSalaryDepartment);
    }
    @Test
    public void shouldReturnEmployeeWithMinSalaryDepartment() {
        //given
        Employee employee1 = new Employee("Ivan", "Petrov", 200000, 1);
        Employee employee2 = new Employee("Petr", "Ivanov", 300000, 1);
        Employee employee3 = new Employee("Ivan", "Ivanov", 100000, 2);

        Collection<Employee> employees = new HashSet<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        when(employeeService.getAllEmployees()).thenReturn(employees);
        //when
        Employee employeeWithMinSalaryDepartment = departmentService.ReturnEmployeeWithMinSalary(1);
        //then
        Assertions.assertEquals(employee1, employeeWithMinSalaryDepartment);
    }
    @Test
    public void shouldReturnNullMaxSalaryWhenDepartmentIsEmpty() {
        //given
        when(employeeService.getAllEmployees()).thenReturn(Collections.EMPTY_SET);
        //when
        Employee employeeWithMaxSalaryDepartment = departmentService.ReturnEmployeeWithMaxSalary(1);
        //then
        Assertions.assertNull(employeeWithMaxSalaryDepartment);
    }

    @Test
    public void shouldReturnNullMinSalaryWhenDepartmentIsEmpty() {
        //given
        when(employeeService.getAllEmployees()).thenReturn(Collections.EMPTY_SET);
        //when
        Employee employeeWithMinSalaryDepartment = departmentService.ReturnEmployeeWithMinSalary(1);
        //then
        Assertions.assertNull(employeeWithMinSalaryDepartment);
    }
    @Test
    public void shouldReturnAllEmployeeDepartment() {
        //given
        Employee employee1 = new Employee("Ivan", "Petrov", 200000, 1);
        Employee employee2 = new Employee("Petr", "Ivanov", 300000, 1);
        Employee employee3 = new Employee("Ivan", "Ivanov", 100000, 2);
        Collection<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        Collection<Employee> employees2 = new ArrayList<>();
        employees2.add(employee1);
        employees2.add(employee2);

        when(employeeService.getAllEmployees()).thenReturn(employees);
        //when
        Collection<Employee> allEmployeeDepartment = departmentService.ReturnAllEmployeeDepartment(1);
        //then
        Assertions.assertEquals(employees2, allEmployeeDepartment);
    }
    @Test
    public void shouldReturnNullWhenNoEmployeeInDepartment() {
        //given
        Employee employee1 = new Employee("Ivan", "Petrov", 200000, 1);
        Employee employee2 = new Employee("Petr", "Ivanov", 300000, 1);
        Employee employee3 = new Employee("Ivan", "Ivanov", 100000, 2);
        Collection<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        Collection<Employee> employees2 = new ArrayList<>();

        when(employeeService.getAllEmployees()).thenReturn(employees);
        //when
        Collection<Employee> allEmployeeDepartment = departmentService.ReturnAllEmployeeDepartment(3);
        //then
        Assertions.assertEquals(employees2, allEmployeeDepartment);
    }
    @Test
    public void shouldReturnAllEmployeeCollectedByDepartment() {
        //given
        Employee employee1 = new Employee("Ivan", "Petrov", 200000, 1);
        Employee employee2 = new Employee("Petr", "Ivanov", 300000, 1);
        Employee employee3 = new Employee("Ivan", "Ivanov", 100000, 2);
        Collection<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee3);
        employees.add(employee2);

        List<Employee> employeesDepartment1 = new ArrayList<>();
        employeesDepartment1.add(employee1);
        employeesDepartment1.add(employee2);

        List<Employee> employeesDepartment2 = new ArrayList<>();
        employeesDepartment2.add(employee3);

        Map<Integer, List<Employee>> employees2 = new HashMap<>();
        employees2.put(1, employeesDepartment1);
        employees2.put(2, employeesDepartment2);


        when(employeeService.getAllEmployees()).thenReturn(employees);
        //when
        Map<Integer, List<Employee>> allEmployeeCollectedByDepartment = departmentService.ReturnAllEmployeeCollectedDepartment();
        //then
        Assertions.assertEquals(employees2, allEmployeeCollectedByDepartment);
    }
}
