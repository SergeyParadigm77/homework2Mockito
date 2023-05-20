package pro.skypro.homework.service;



import pro.skypro.homework.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee ReturnEmployeeWithMaxSalary(Integer departmentId);
    Employee ReturnEmployeeWithMinSalary(Integer departmentId);
    List<Employee> ReturnAllEmployeeDepartment(Integer departmentId);
    Map<Integer, List<Employee>> ReturnAllEmployeeCollectedDepartment();
}
