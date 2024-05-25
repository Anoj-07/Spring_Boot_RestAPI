package Daily_code_buffer.Spring_BootLearning.controller;


import Daily_code_buffer.Spring_BootLearning.entity.Department;
import Daily_code_buffer.Spring_BootLearning.error.DepartmentNotFoundException;
import Daily_code_buffer.Spring_BootLearning.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /*Loggers*/
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    /*This all GET, POST, DELETE, UPDATE are APIs*/

    /*Saving Department Entity to DB (POST)
     * @valid is for validation it wil valid it msg of Department entity @NotBlank*/
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        /*logger impl*/
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    /*Fetching Data form DB (GET)*/
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        /*logger impl.*/
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    /*Fetching Data by ID*/
    /*lets add Exception Handling*/
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentByID(@PathVariable("id") Long departmentId)
            throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentByID(departmentId);
    }


    /*Deleting data form DB (DELETE) */
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "department deleted Successfully !!";
    }

    /*Update data to DB (PUT)*/
    @PutMapping("/departments/{id}")
    public Department UpdateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
        return departmentService.UpdateDepartment(departmentId, department);
    }

    /*Fetching data by property name*/
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.fetchDepartmentByName(departmentName);
    }

}
