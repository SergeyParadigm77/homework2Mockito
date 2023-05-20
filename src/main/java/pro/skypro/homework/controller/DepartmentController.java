package pro.skypro.homework.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.skypro.homework.Employee;
import pro.skypro.homework.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee ReturnEmployeeWithMaxSalary(@RequestParam Integer departmentId){
        return departmentService.ReturnEmployeeWithMaxSalary(departmentId);
    }
    @GetMapping("/min-salary")
    public Employee ReturnEmployeeWithMinSalary(@RequestParam Integer departmentId){
        return departmentService.ReturnEmployeeWithMinSalary(departmentId);
    }
    @GetMapping("/all-department")
    public List<Employee> ReturnAllEmployeeDepartment(@RequestParam Integer departmentId){
        return departmentService.ReturnAllEmployeeDepartment(departmentId);
    }
    @GetMapping("/all")
    public Map<Integer, List<Employee>> ReturnAllEmployeeCollectedDepartment(){
        return departmentService.ReturnAllEmployeeCollectedDepartment();
    }
}
