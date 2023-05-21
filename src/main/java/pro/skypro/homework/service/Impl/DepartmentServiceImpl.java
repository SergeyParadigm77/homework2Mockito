package pro.skypro.homework.service.Impl;


import org.springframework.stereotype.Service;
import pro.skypro.homework.Employee;
import pro.skypro.homework.service.DepartmentService;
import pro.skypro.homework.service.EmployeeService;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee ReturnEmployeeWithMaxSalary(Integer departmentId) {
        Collection<Employee> employees = employeeService.getAllEmployees();
        return employees.stream().filter(it -> it.getDepartment() == departmentId).max(Comparator.comparing(Employee::getSalary)).orElse(null);
    }

    @Override
    public Employee ReturnEmployeeWithMinSalary(Integer departmentId) {
        Collection<Employee> employees = employeeService.getAllEmployees();
        return employees.stream().filter(it -> it.getDepartment() == departmentId).min(Comparator.comparing(Employee::getSalary)).orElse(null);
    }

    @Override
    public List<Employee> ReturnAllEmployeeDepartment(Integer departmentId) {
        Collection<Employee> employees = employeeService.getAllEmployees();
        return employees.stream().filter(it -> it.getDepartment() == departmentId).collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> ReturnAllEmployeeCollectedDepartment() {
        Collection<Employee> employees = employeeService.getAllEmployees();
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
